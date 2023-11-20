<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
</head>
<!-- 어느 위치인지에 따라 상대경로가 달라지므로, root를 얻어 절대경로로 가야 한다 -->
<!-- 예컨대 홈페이지에서는 /mini까지 얻음 -->
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
	<a href="${root}/">
	<img src="${root}/res/photo/sim.gif" width="50" hspace="20">
	Spring5 + Tiles3 + Mybatis Mini Project
	<img src="${root}/res/photo/sim.gif" width="50" hspace="20">
	
	</a>
</body>
</html>