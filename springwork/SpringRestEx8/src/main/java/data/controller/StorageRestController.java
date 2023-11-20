package data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dao.PhotoDao;
import data.dto.PhotoDto;
import naver.storage.NcpObjectStorageService;

@RestController
public class StorageRestController {
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	@Autowired
	PhotoDao photoDao;
	
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
		//String photo80="https://9bsqlbeu1646.edge.naverncp.com/hH4v64dItE/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";

		return photo80;
	}
	
	@PostMapping("/storage/adddb")
	public void insertPhoto(@RequestParam String title)
	{
		PhotoDto dto = new PhotoDto();
		dto.setTitle(title);
		
		/* 내 경로들 */
//		// 원본사진 경로
//		String photo = "https://kr.object.ncloudstorage.com/bitcamp-701-cwt629/photo/" + fileName;
//		// 150*150 프로필 사진 경로
//		String photo150 = "https://9bsqlbeu1646.edge.naverncp.com/hH4v64dItE/photo/" + fileName + "?type=f&w=150&h=150&faceopt=true&ttype=jpg";
//		// 80*80 프로필 사진 경로
//		String photo80 = "https://9bsqlbeu1646.edge.naverncp.com/hH4v64dItE/photo/" + fileName + "?type=f&w=80&h=80&faceopt=true&ttype=jpg";
//		
		//원본사진경로
		String photo="https://kr.object.ncloudstorage.com/bitcamp-lmh/photo/"+fileName;
		//150*150
		String photo150="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=150&h=150&faceopt=true&ttype=jpg";
		//80*80
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";

		
		dto.setPhoto(photo);
		dto.setPhoto80(photo80);
		dto.setPhoto150(photo150);
		
		// db insert
		photoDao.insertPhoto(dto);
		
		fileName = null;
	}
	
	@GetMapping("/storage/list")
	public List<PhotoDto> getAllStorage()
	{
		return photoDao.getAllPhotos();
	}
	
	@GetMapping("/storage/delete")
	public void deletePhoto(@RequestParam int num)
	{
		photoDao.deletePhoto(num);
	}
}
