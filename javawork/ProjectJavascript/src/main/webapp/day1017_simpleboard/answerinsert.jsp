<%@page import="simpleboard.data.AnswerBoardDto"%>
<%@page import="simpleboard.data.AnswerBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 한글 인코딩
	request.setCharacterEncoding("utf-8");
	// answer dto 선언
	AnswerBoardDto dto = new AnswerBoardDto();
	// answer dao 선언
	AnswerBoardDao dao = new AnswerBoardDao();
	// 데이터를 읽어서 dto에 담기
	String num = request.getParameter("num");
	String nickname = request.getParameter("nickname");
	String content = request.getParameter("content");
	
	dto.setNum(num);
	dto.setNickname(nickname);
	dto.setContent(content);
	
	// insert method 호출
	dao.insertAnswer(dto);
	
	// content.jsp로 이동(num 필요함)
	response.sendRedirect("content.jsp?num=" + num);
%>