<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="escthemes.data.EscThemesDao"%>
<%@page import="escthemes.data.EscThemesDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터 받아오기
	String searching = request.getParameter("searching");
	String standard = request.getParameter("standard");
	
	// dao
	EscThemesDao dao = new EscThemesDao();
	// 날짜 포맷
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	// 검색된 목록
	List<EscThemesDto> searchedThemes = null;
	
	// 검색 기준에 따라 다른 목록을 가져온다
	switch(standard){
	case "themename":
		searchedThemes = dao.getThemesByName(searching);
		break;
		
	case "cafename":
		searchedThemes = dao.getThemesByCafename(searching);
		break;
		
	case "region":
		searchedThemes = dao.getThemesByRegion(searching);
		break;
		
	case "genre":
		searchedThemes = dao.getThemesByGenre(searching);
		break;
		
	default:
		System.out.println("검색 기준이 잘못됐습니다");
		break;
	}
	
	// JSON 형태로 전달
	JSONArray arr = new JSONArray();
	for (EscThemesDto dto: searchedThemes){
		JSONObject ob = new JSONObject();
		ob.put("roomcode", dto.getRoomcode());
		ob.put("memcode", dto.getMemcode());
		ob.put("themename", dto.getThemename());
		ob.put("genre", dto.getGenre());
		ob.put("cafename", dto.getCafename());
		ob.put("region", dto.getRegion());
		ob.put("explanation", dto.getExplanation());
		ob.put("image", dto.getImage());
		ob.put("registereddate", sdf.format(dto.getRegisteredDate()));
		
		arr.add(ob);
	}
%>
<%=arr.toString()%>