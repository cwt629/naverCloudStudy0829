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
		// ������ ���ε��� ������ ������Ʈ �� ����� ��ġ ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// ���� ���ε��� ���ϸ�
		String originalFilename = upload.getOriginalFilename();
		
		// ���� ���ϸ����� Ȯ���ڸ� ��� ���:
		// ������ .(dot)�� ��ġ
		int dotIdx = originalFilename.lastIndexOf(".");
		String extName = originalFilename.substring(dotIdx); // abc.jpg => .jpg ����
		
		// ���� ���ϸ��� �ƴ� �������ϸ����� �����ϱ�
		// (���ÿ� ���� ������ ���� ������ �÷��� ���� ������ �� �ֵ��� ��)
		String filename = UUID.randomUUID().toString() + extName;
		
		// ���ε�
		try {
			upload.transferTo(new File(path + "/" + filename));
			model.addAttribute("path", path); // ������ ��¿�(���� �ʿ� ����)
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
		// ������ ���ε��� ������ ������Ʈ �� ����� ��ġ ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		// ���� ���� �𵨿� ����
		model.addAttribute("title", title);
		
		// ������ �������̹Ƿ�, �ݺ������� ���ε��Ѵ�
		// ���� ���ϸ��� ������ List ����
		List<String> files = new ArrayList<String>();
		
		for (MultipartFile multi: upload)
		{
			String f = multi.getOriginalFilename(); // ���� ���ϸ�
			// ���� ���ϸ����� Ȯ���� �и�
			int extIdx = f.lastIndexOf(".");
			String ext = f.substring(extIdx);
			
			// ���ε��� ���� ���ϸ�
			String filename = UUID.randomUUID().toString() + ext;
			
			files.add(filename); // �������ϸ� ����
			// ���ε�
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
		
		model.addAttribute("files", files); // �������� ���ϸ���
		return "uploadresult2";
	}
}