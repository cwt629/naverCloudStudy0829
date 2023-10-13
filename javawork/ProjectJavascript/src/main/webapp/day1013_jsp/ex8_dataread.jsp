<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>8. data read</title>
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}
</style>
</head>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("myname");
	String javaScore = request.getParameter("java");
	String jspScore = request.getParameter("jsp");
	String springScore = request.getParameter("spring");
	
	String phoneStart = request.getParameter("hp1");
	String phoneRest = request.getParameter("hp2");
	
	String tcolor = request.getParameter("tcolor");
	String bcolor = request.getParameter("bcolor");
	int sum = 0;
	
	// 예외 처리가 필요할 수 있다(들어오는 값이 숫자가 아닌 경우)
	try {
		sum = Integer.parseInt(javaScore) + Integer.parseInt(jspScore) + Integer.parseInt(springScore);
	} catch (NumberFormatException e){
		sum = 0;
	}
%>
<body>
	<h5
		style="font-size: 1.5em; color: <%=tcolor%>; background-color: <%=bcolor%>; width: 300px;">
		이름:
		<%=name %><br> 핸드폰:
		<%=phoneStart %>-<%=phoneRest %><br> 점수: java
		<%=javaScore %>점, jsp
		<%=jspScore %>점, spring
		<%=springScore %>점<br> 합계:
		<%=sum %>점<br> 평균:
		<%=(float)sum / 3 %>점<br>
	</h5>
</body>
</html>