package data.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.dto.MemoDto;
import data.dto.MemoDto2;

//@Controller
//public class RestTestController1 {
//
//	@GetMapping("/test/list1")
//	// @ResponseBody : 匂趨球 是帖亜 焼艦虞 JSON 坦軒背辞 鋼発
//	@ResponseBody public List<MemoDto2> list1()
//	{
//		List<MemoDto2> list = new Vector<MemoDto2>();
//		list.add(new MemoDto2(1, "wontae", "1.jpg", "ぞしせせ", 5, "2023-10-10"));
//		list.add(new MemoDto2(2, "galerhee", "2.jpg", "確 託獄険暗醤", 2, "2022-05-01"));
//		list.add(new MemoDto2(3, "leesm", "3.jpg", "蟹澗 含鍵陥 壱稽 糎仙廃陥", 6, "2021-10-10"));
//		
//		return list; 
//	}
//	
//	@GetMapping("/test/add")
//	@ResponseBody public MemoDto2 add(String nickname, String photo, String memo)
//	{
//		MemoDto2 dto = new MemoDto2(1, nickname, photo, memo, 10, "2022-12-25");
//		return dto;
//	}
//}

@RestController // 匂趨球遂戚 焼艦壱, @ResponseBody 琶推 蒸嬢像
public class RestTestController1 {

	@GetMapping("/test/list1")
	public List<MemoDto2> list1()
	{
		List<MemoDto2> list = new Vector<MemoDto2>();
		list.add(new MemoDto2(1, "wontae", "1.jpg", "ぞしせせ", 5, "2023-10-10"));
		list.add(new MemoDto2(2, "galerhee", "2.jpg", "確 託獄険暗醤", 2, "2022-05-01"));
		list.add(new MemoDto2(3, "leesm", "3.jpg", "蟹澗 含鍵陥 壱稽 糎仙廃陥", 6, "2021-10-10"));
		
		return list; 
	}
	
	@GetMapping("/test/add")
	public MemoDto2 add(String nickname, String photo, String memo)
	{
		MemoDto2 dto = new MemoDto2(1, nickname, photo, memo, 10, "2022-12-25");
		return dto;
	}
	
	@PostMapping("/test/list2")
	public Map<String, String> test()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "畠掩疑");
		map.put("age", "35");
		
		return map;
	}
}
