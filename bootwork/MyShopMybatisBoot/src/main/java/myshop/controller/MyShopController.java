package myshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import myshop.data.MyShopDto;
import myshop.service.MyShopService;
import naver.storage.NcpObjectStorageService;

@Controller
// final이나 @nonnull 붙은 것만 생성자 주입
@RequiredArgsConstructor
public class MyShopController {
	private final MyShopService shopService;
	
	// storage class 선언
	private final NcpObjectStorageService storageService;
	
	// bucket name 지정
	private String bucketName = "bitcamp-701-cwt629";
	// 저장할 폴더 이름
	private String folderName = "bootmyshop";
	
	@GetMapping("/")
	public String list(Model model)
	{
		// 총 개수를 얻어온다
		int totalCount = shopService.getTotalCount();
		// 전체 목록 가져오기
		List<MyShopDto> list = shopService.getSangpumList();
		
		// model에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		return "myshop/shoplist";
	}
	
	@GetMapping("/form")
	public String form()
	{
		return "myshop/shopform";
	}
	
	@PostMapping("/insert")
	// 주의: 원래는 같은 이름일때 생략 가능했지만, RequestParam 뒤에 이제는 이름 다 붙여주자. 안붙이니까 오류 난다.
	public String insert(@ModelAttribute MyShopDto dto, @RequestParam("upload") MultipartFile upload)
	{
		// 네이버 스토리지에 업로드 후, 저장된 파일명을 리턴받아 dto의 photo에 저장
		String photo = storageService.uploadFile(bucketName, folderName, upload);
		dto.setPhoto(photo);
		
		// db에 insert
		shopService.insertShop(dto);
		return "redirect:./";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("num") int num, Model model)
	{
		// num에 해당하는 dto 얻기
		MyShopDto dto = shopService.getData(num);
		model.addAttribute("dto", dto);
		
		return "myshop/shopdetail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("num") int num)
	{
		// 해당 번호의 데이터
		MyShopDto dto = shopService.getData(num);
		// 사진 파일명 받기
		String fileName = dto.getPhoto();
		// 삭제
		shopService.deleteShop(num);
		// naver storage에서도 삭제해줌
		storageService.deleteFile(bucketName, folderName, fileName);
		
		return "redirect:./";
	}
}
