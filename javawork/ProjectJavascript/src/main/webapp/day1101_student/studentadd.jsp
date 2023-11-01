<%@page import="student.data.StudentDto"%>
<%@page import="student.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 각 파라미터 받아오기
	String name = request.getParameter("name");
	String blood = request.getParameter("blood");
	String phone = request.getParameter("phone");
	
	// dao
	StudentDao dao = new StudentDao();
	
	// dto 
	StudentDto dto = new StudentDto();
	dto.setName(name);
	dto.setBlood(blood);
	dto.setPhone(phone);
	
	// 삽입
	dao.insertStudent(dto);
%>