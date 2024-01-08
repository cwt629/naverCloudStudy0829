package com.api.data.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.data.service.DataService;

@Controller
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	/**
	 * description    : 로그인 체크
	 * @param reqMap
	 * @param req
	 * @param res
	 * @return
	 */
	@PostMapping(value="/dataSet")
	public @ResponseBody HashMap<String, Object> dataSet(@RequestBody HashMap<String, Object> reqMap) {
		HashMap<String, Object> resultVO = new HashMap<String, Object>();
		try {
			
			System.out.println("reqMap ======= : " + reqMap.get("test"));
			
			resultVO = dataService.dataSet();
			
		} catch(Exception e) {
			resultVO.put("result", false);
			resultVO.put("message", e.getMessage());
			e.printStackTrace();
		}
		return resultVO;
	}
	

}
