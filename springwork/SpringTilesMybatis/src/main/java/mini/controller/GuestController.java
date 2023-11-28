package mini.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.GuestDto;
import mini.service.GuestService;
import naver.storage.NcpObjectStorageService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Date;

@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	private String bucketName = "guest-cwt";
	private String folderName = "guest";

	// 20231128 - 번역 후 반환하는 메소드
	public String translate(String originalText, String nara)
	{
		String clientId = "h912sq3ol7";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "Vmbvn8Wci0ZAx5v80Vypy3ht2I9nkUxpCI3k8yDE";//애플리케이션 클라이언트 시크릿값";
        String result = "";
        
        try {
            String text = URLEncoder.encode(originalText, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            
            // post request : nara를 넣어준다!
            String postParams = "source=ko&target=" + nara + "&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(), StandardCharsets.UTF_8));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            System.out.println(response.toString()); // response는 json 형태로 넘어옴
            
            /*
             * response는 StringBuffer로, 이를 json 형태로 만들고 데이터를 추출하려면
             * 1. pom.xml에 json dependency 추가
             * 2. JSONObject를 활용해 데이터 추출
             * 이러한 순서로 데이터를 뽑는다.
             */
            JSONObject ob = new JSONObject(response.toString());
            JSONObject jsonResult = ob.getJSONObject("message").getJSONObject("result");
            
            result = jsonResult.getString("translatedText");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
	}
	
	@GetMapping("/guest/list")
	public String guestList(Model model, @RequestParam(defaultValue = "en") String nara) // nara: 기본 번역 언어는 영어
	{
		int totalCount = guestService.getAllGuest().size();
		List<GuestDto> glist = guestService.getAllGuest();
		// dto에 번역 내용도 저장
		for (GuestDto dto: glist)
		{
			// 해당 나라 언어로 번역해서 반환
			String trans = translate(dto.getGuest_content(), nara);
			dto.setTrans_lang(trans);
		}
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("glist", glist);
		
		return "guest/guestlist";
	}
	
	// MultipartFile이 있으면 무조건 post로 하자
	@PostMapping("/guest/insert")
	public String insertGuest(@ModelAttribute GuestDto dto, @RequestParam MultipartFile upload,
			@RequestParam String nara)
	{
		// 네이버 스토리지에 업로드한 후, 랜덤 파일명 반환
		String guest_photo = storageService.uploadFile(bucketName, folderName, upload);
		// dto에 사진 파일명 저장
		dto.setGuest_photo(guest_photo);
		
		// db에 insert
		guestService.insertGuest(dto);
		
		// 목록으로 리다이렉트
		return "redirect:./list?nara=" + nara;
	}
	
	// 목소리 반환하는 메소드
	@GetMapping("/guest/voice")
	@ResponseBody public String getVoice(String message, String lang, HttpServletRequest request)
	{
		// 목소리 파일을 업로드할 경로 구하기
		String path = request.getSession().getServletContext().getRealPath("/resources/voice");
		System.out.println("보이스 넣는 경로: " + path);
		
		String clientId = "x776umil38";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "TbVi5kZ4xSwhneKUc7qxWcN5NXNGnXbriyQ2lUsT";//애플리케이션 클라이언트 시크릿값";
        
        try {
        	// 메세지 대입
            String text = URLEncoder.encode(message, "UTF-8"); // 13자
            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            
            // 나라별 목소리 지정하기
            String naraVoice = "";
            if (lang.equals("ko")) // 한국어
            	naraVoice = "napple";
            else if (lang.equals("en")) // 영어
            	naraVoice = "matt";
            else if (lang.equals("ja")) // 일어
            	naraVoice = "shinji";
            else if (lang.equals("zh-CN")) // 중국어
            	naraVoice = "meimei";
            else if (lang.equals("es")) // 스페인어
            	naraVoice = "jose";
            
            // post request
            String postParams = "speaker=" + naraVoice + "&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 기존: 랜덤한 이름으로 mp3 파일 생성(매번 새로운 이름으로 만들어 저장)
                // 근데 이름에서 언제 만들었는지 표시하고 싶은 경우
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                //String tempname = Long.valueOf(new Date().getTime()).toString();
                String tempname = sdf.format(new Date());
                // 매번 만들 필요가 없으므로, 우리가 이름을 정하...려고 했는데 덮어쓰기가 안돼서 기각함.
                
                //File f = new File(path + "/newvoice.mp3");
                File f = new File(path + "/" + tempname + ".mp3");
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
                return tempname + ".mp3";
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		
        // 파일명 반환
		return "";
	}
}
