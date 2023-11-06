<%@page import="escreviews.data.EscReviewsDto"%>
<%@page import="escreviews.data.EscReviewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String score = request.getParameter("point");
	String memcode = request.getParameter("memcode");
	String roomcode = request.getParameter("roomcode");
	String comment = request.getParameter("comment");
	
	EscReviewsDao dao = new EscReviewsDao();
	EscReviewsDto dto = new EscReviewsDto();
	
	dto.setScore(score);
	dto.setMemcode(memcode);
	dto.setRoomcode(roomcode);
	dto.setComment(comment);
	
	dao.insertReview(dto);
	
	// 다시 그 페이지로 돌아간다
	response.sendRedirect("reviewpage.jsp?roomcode=" + roomcode);
%>