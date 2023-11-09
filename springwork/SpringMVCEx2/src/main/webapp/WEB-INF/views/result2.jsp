<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
</head>
<body>
	<h2 class="alert alert-info">TestController로부터 포워드됨</h2>
	<hr>
	<h3>${message}</h3>
	<h5>오늘의 브런치</h5>
	<!-- /board/update -> /res/image/1.jpg -->
	<img src="../res/image/1.jpg" width="300"> <!-- 상대경로: 3개짜리에선 안나옴 -->
	<img src="${root}/res/image/1.jpg" width="300"> <!-- 절대경로: 모두 잘나옴 -->
	<!-- /board/update -> /photo/1.jpg -->
	<img src="../photo/1.jpg" width="300">
	<img src="${root}/photo/1.jpg" width="300">
</body>
</html>