<%@page import="escthemes.data.EscThemesDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String roomcode = request.getParameter("roomcode");
	
	EscThemesDao dao = new EscThemesDao();
	dao.deleteTheme(roomcode);
	
	response.sendRedirect("themelist.jsp");
%>