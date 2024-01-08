package com.api.data.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
    
@Component    
public class JsonToMap {   
    //json을 받아 hashmap으로 변환하는 메소드
    public static HashMap<String, Object> jsonToMap(JSONObject json) throws JSONException {
    	HashMap<String, Object> retMap = new HashMap<String, Object>();
	    
	    if(json != null) {
	        retMap = toMap(json);
	    }
	    return retMap;
	}

	//json객체 안에 또다른 json 객체가 있을 경우
	public static HashMap<String, Object> toMap(JSONObject object) throws JSONException {
		HashMap<String, Object> map = new HashMap<String, Object>();

	    @SuppressWarnings("rawtypes")
		Set keys = object.keySet();
	    @SuppressWarnings("unchecked")
		Iterator<String> keysItr = keys.iterator();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);
	        
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }
	        
	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}
	
    //json객체 안에 json 배열이 있을경우
	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
 }