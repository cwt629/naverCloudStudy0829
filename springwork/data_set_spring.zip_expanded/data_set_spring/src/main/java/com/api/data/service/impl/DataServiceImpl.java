package com.api.data.service.impl;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.data.action.Action;
import com.api.data.action.JsonToMap;
import com.api.data.dao.DataDao;
import com.api.data.service.DataService;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private DataDao dao;
	
	@Autowired
	private Action act;
	
	
	public HashMap<String, Object> dataSet() throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		System.out.println(" =========== ");
		
		
		System.out.println(" === act get : " );
		
		JSONObject jobj = act.get("", ""); 
		
		resultMap = JsonToMap.toMap(jobj);
		 
		
		
		
		
		return resultMap;
	}
	
}
