<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="student.data.StudentDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 검색어 받아오기
	String searching = request.getParameter("searching");

	// dao
	StudentDao dao = new StudentDao();
	// 날짜 포맷
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	// 검색된 목록
	List<StudentDto> searchedList = dao.getSearchedStudents(searching);
	
	// JSON 형태로 전달
	JSONArray arr = new JSONArray();
	for (StudentDto dto: searchedList){
		JSONObject ob = new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("name", dto.getName());
		ob.put("blood", dto.getBlood());
		ob.put("phone", dto.getPhone());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr.toString()%>