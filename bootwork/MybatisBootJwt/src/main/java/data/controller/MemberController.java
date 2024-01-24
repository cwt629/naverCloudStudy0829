package data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin // 옛날에는 이게 반드시 필요했는데, 지금은 그냥 없어도 되는듯?
public class MemberController {

	private final MemberService memberService;
	
	// 스토리지 변수
	private final NcpObjectStorageService storageService;
	
	// 비밀번호 암호화를 위한 변수 선언
	private final PasswordEncoder passwordEncoder;
	
	private String bucketName = "bitcamp-701-cwt629";
	private String folderName = "reactboot";
	
	// 업로드한 파일명
	private String uploadFilename;
	
	@GetMapping("/member/list")
	public Map<String, Object> list()
	{
		Map<String, Object> map = new HashMap<>();
		int totalCount = memberService.getTotalCount();
		List<MemberDto> mlist = memberService.getAllMembers();
		
		map.put("totalCount", totalCount);
		map.put("mlist", mlist);
		
		return map;
	}
	
	// 가입 시 사진 저장
	@PostMapping("/member/upload")
	public String uploadFile(@RequestParam("upload") MultipartFile upload)
	{
		uploadFilename = storageService.uploadFile(bucketName, folderName, upload);
		
		return uploadFilename;
	}
	
	@PostMapping("/member/insert")
	public String insert(@RequestBody MemberDto dto)
	{
		// pass는 암호화하여 DB에 저장한다
		String pass = dto.getPass();
		String encodedPass = passwordEncoder.encode(pass);
		System.out.println("비번 암호화: " + encodedPass);
		
		// dto의 pass를 암호화된 pass로 변경
		dto.setPass(encodedPass);
		
		// 업로드된 사진
		dto.setPhoto(uploadFilename);
		
		memberService.insertMember(dto);
		uploadFilename = null;
		return "success";
	}
	
	@GetMapping("/member/idcheck")
	public int idcheck(@RequestParam("myid") String myid)
	{
		// 아이디가 DB에 존재하면 1, 그렇지 않으면 0 반환
		return memberService.getIdCheck(myid);
	}
	
	@DeleteMapping("/member/delete")
	public void delete(@RequestParam("num") int num)
	{
		// DB 삭제 전에 스토리지의 사진 먼저 삭제
		String dbPhotoname = memberService.getMember(num).getPhoto();
		storageService.deleteFile(bucketName, folderName, dbPhotoname);
		
		// DB 삭제
		memberService.deleteMember(num);
	}
}
