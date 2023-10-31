<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "홍 길동";
	int age = 23;
	
	// json 데이터로 만들기
	StringBuffer sb = new StringBuffer();
	sb.append("{\"name\": \"" + name + "\",");
	sb.append("\"age\":" + age + "}");
%>
<%= sb.toString() %>