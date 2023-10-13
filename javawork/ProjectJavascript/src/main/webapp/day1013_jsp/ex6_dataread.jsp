<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6. data read</title>
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
	/* 
	get방식은 tomcat 8부터 한글이 깨지지 않았지만,
	post방식은 버전에 상관없이 한글이 그냥 깨진다.
	그래서, post방식은 읽기 전 첫줄에 인코딩을 주어야 한글이 안깨진다.
	*/
	
	// POST 방식의 한글 인코딩
	request.setCharacterEncoding("utf-8"); // 데이터 읽기 전 - 첫줄
	
	// post 방식의 폼 데이터 읽기
	// (참고로 이렇게 body 위에 있다거나 이런 위치는 상관 없음)
	String irum = request.getParameter("irum");
	String lic = request.getParameter("license"); // 체크면 on, 안하면 null 된다.
	String gender = request.getParameter("gender"); // radio는 같은 그룹일 경우 선택된 value값을 읽는다
	String home = request.getParameter("home");
%>
<body>
	<pre style="font-size: 2em;">
	이름 : <%=irum %>
	운전면허 : <%=lic == null? "없음" : "있음" %>
	성별 : <%=gender %>
	주거지 : <%=home %>
	</pre>
</body>
</html>