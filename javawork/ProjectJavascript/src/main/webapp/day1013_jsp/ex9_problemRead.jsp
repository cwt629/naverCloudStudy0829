<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>9. 문제 read</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
</style>
</head>
<%
	request.setCharacterEncoding("utf-8");
	
	String borderStyle = request.getParameter("line");
	String photoURL = request.getParameter("photo");
	String today = request.getParameter("today");
%>
<body>
	<h4><%=today %></h4>
	<img src="<%=photoURL %>" style="border: <%=borderStyle %>;">
</body>
</html>