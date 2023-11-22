<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Main</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
</head>
<body>
	
	<c:if test="${sessionScope.loginok == null}">
		<button type="button" class="btn btn-success"
		style="width: 100px;" data-bs-toggle="modal" data-bs-target="#myLoginModal">로그인</button>
	</c:if>
	
	<c:if test="${sessionScope.loginok != null}">
		<h5>${sessionScope.myid}님 ㅎㅇ</h5>
		<button type="button" class="btn btn-success"
		style="width: 100px;">로그아웃</button>
	</c:if>
</body>
</html>