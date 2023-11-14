<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result 1</title>
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
	<h2>폼 #1 결과 출력</h2>
	
	<h3>
		이름 : ${mdto.name}<br>
		핸드폰 : ${mdto.hp}<br>
		주소 : ${mdto.addr}<br>
		파일명 : ${mdto.photo}<br>
		<!-- member/upload1 > photo/파일명 -->
		<img src="../photo/${mdto.photo}" width="300" border="3">
	</h3>
</body>
</html>