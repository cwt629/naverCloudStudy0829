package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import naver.storage.NcpObjectStorageService;

@RestController
public class StorageRestController {
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	//private String bucketName = "bitcamp-701-cwt629"; // 자기 bucket 이름 
	private String bucketName = "bitcamp-lmh"; // 강사님의 bucket 이름 
	private String bucketFolder = "photo"; // 그 bucket 내 업로드할 폴더명
	
	String fileName;
	
	@PostMapping("/storage/addphoto")
	public String addPhoto(@RequestParam MultipartFile upload)
	{
		// 스토리지에 업로드
		fileName = storageService.uploadFile(bucketName, bucketFolder, upload);
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";

		return photo80;
	}
}
