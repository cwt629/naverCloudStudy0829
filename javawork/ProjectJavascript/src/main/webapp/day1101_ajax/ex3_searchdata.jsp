<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="myshop.data.MyShopDto"%>
<%@page import="java.util.List"%>
<%@page import="myshop.data.MyShopDao"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// searching 읽기
	String searching = request.getParameter("searching");

	// dao 선언
	MyShopDao dao = new MyShopDao();
	// 날짜 포맷
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	// searching 단어가 포함된 목록 얻기
	List<MyShopDto> searchedList = dao.getSearchedSangpum(searching);
	
	// 위 리스트 목록을 JSONArray로 배열 형태의 JSON으로 구현
	JSONArray arr = new JSONArray();
	for (MyShopDto dto: searchedList){
		JSONObject jo = new JSONObject();
		jo.put("num", dto.getNum());
		jo.put("sangpum", dto.getSangpum());
		jo.put("price", dto.getPrice());
		jo.put("photo", dto.getPhoto());
		jo.put("color", dto.getColor());
		jo.put("writeday", sdf.format(dto.getWriteday()));
		
		// 배열에 추가
		arr.add(jo);
	}
%>
<%=arr.toString()%>