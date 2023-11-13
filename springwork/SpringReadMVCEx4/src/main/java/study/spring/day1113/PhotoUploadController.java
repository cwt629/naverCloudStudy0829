package study.spring.day1113;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoUploadController {
	
	@GetMapping("/uploadform1")
	public String upload1()
	{
		return "uploadform1";
	}
	
	@GetMapping("/uploadform2")
	public String upload2()
	{
		return "uploadform2";
	}
	
	@PostMapping("/upload1")
	public String uploadgo1(Model model, @RequestParam String title, 
			@RequestParam MultipartFile upload, HttpServletRequest request)
	{
		// 사진을 업로드할 배포된 프로젝트 내 경로의 위치 구하기
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 현재 업로드한 파일명
		String originalFilename = upload.getOriginalFilename();
		
		// 실제 파일명에서 확장자만 얻는 방법:
		// 마지막 .(dot)의 위치
		int dotIdx = originalFilename.lastIndexOf(".");
		String extName = originalFilename.substring(dotIdx); // abc.jpg => .jpg 얻음
		
		// 실제 파일명이 아닌 랜덤파일명으로 저장하기
		// (동시에 같은 파일을 여러 곳에서 올려도 서로 구분할 수 있도록 함)
		String filename = UUID.randomUUID().toString() + extName;
		
		// 업로드
		try {
			upload.transferTo(new File(path + "/" + filename));
			model.addAttribute("path", path); // 브라우저 출력용(굳이 필요 없음)
			model.addAttribute("photo", filename);
			model.addAttribute("title", title);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "uploadresult1";
	}
	
	@PostMapping("/upload2")
	public String uploadgo2(Model model, HttpServletRequest request,
			@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> upload)
	{
		// 사진을 업로드할 배포된 프로젝트 내 경로의 위치 구하기
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// 제목 먼저 모델에 저장
		model.addAttribute("title", title);
		
		// 사진은 여러장이므로, 반복문으로 업로드한다
		// 랜덤 파일명을 저장할 List 선언
		List<String> files = new ArrayList<String>();
		
		for (MultipartFile multi: upload)
		{
			String f = multi.getOriginalFilename(); // 실제 파일명
			// 실제 파일명에서 확장자 분리
			int extIdx = f.lastIndexOf(".");
			String ext = f.substring(extIdx);
			
			// 업로드할 랜덤 파일명
			String filename = UUID.randomUUID().toString() + ext;
			
			files.add(filename); // 랜덤파일명 저장
			// 업로드
			try {
				multi.transferTo(new File(path + "/" + filename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("files", files); // 여러개의 파일명들
		return "uploadresult2";
	}
}
