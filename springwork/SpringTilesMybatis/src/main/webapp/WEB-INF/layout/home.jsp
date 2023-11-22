<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
   
   b.hometitle {
       color: red;
       font-size: 33px;
       text-shadow: 2px 2px 2px gray;
   }
   
   div.albumrow img {
       width: 200px;
       height: 200px;
       margin: 5px;
       border-radius: 200px;
       border: 1px solid gray;
       box-shadow: 3px 3px 3px gray;
   }
  
</style>
</head>
<body>
	<c:set var="root" value="<%=request.getContextPath() %>"/>
	
	<b class="hometitle">비트캠프에 당도한 것을 환영하오 낯선 이여</b>
	<div class="albumrow">
		<img src="${root}/res/photo/allthebox.png">
		<img src="${root}/res/photo/blacknight.png">
	</div>
	<div class="albumrow">
		<img src="${root}/res/photo/caller.jpg">
		<img src="${root}/res/photo/dolphin.jpg">
	</div>
</body>
</html>