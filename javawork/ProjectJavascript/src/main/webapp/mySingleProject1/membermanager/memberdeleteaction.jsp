<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memcode = request.getParameter("memcode");
	EscMembersDao dao = new EscMembersDao();
	dao.deleteMember(memcode);
	
	// 로그아웃 처리
	response.sendRedirect("../logout/logoutaction.jsp");
%>