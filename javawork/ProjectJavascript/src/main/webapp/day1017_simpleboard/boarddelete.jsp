<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// num
	String num = request.getParameter("num");

	// dao
	SimpleBoardDao dao = new SimpleBoardDao();
	
	// delete 메소드 호출
	dao.deleteBoard(num);
	
	// list.jsp로 이동
	response.sendRedirect("list.jsp");
%>