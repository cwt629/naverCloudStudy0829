<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트: upload action</title>
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
	// 프로젝트의 save 폴더의 배포된 곳의 경로 구하기(실제로는 tomcat 안에서 배포되는 것임)
	ServletContext context = getServletContext();
	String realPath = context.getRealPath("/save");
	// 업로드할 파일의 크기 지정
	int uploadSize = 1024 * 1024 * 3; // 3MB = 2^20 * 3 Byte
%>
<body>
	<h5>save 폴더의 경로 구하기<br><%=realPath %></h5>
	<%
		MultipartRequest multiRequest = null;
	
		try {
			multiRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8",
					new DefaultFileRenamePolicy()); // 같은 이름으로 업로드 될 경우 파일명 뒤에 숫자 붙여주는 기능 policy
					
			String title = multiRequest.getParameter("title");
			String originalFileName = multiRequest.getOriginalFileName("upload");
			String uploadName = multiRequest.getFilesystemName("upload");
		%>
			<h4>
				제 목 : <%=title %><br>
				오리지널 파일명 : <%=originalFileName %><br>
				실제 업로드된 파일명 : <%=uploadName %><br>
				실제 업로드된 이미지<br>
			</h4>
			<img src="../save/<%=uploadName %>" style="max-width: 400px;">
			
		<%} catch (Exception e){
			out.print("<h2>업로드 오류 발생 : " + e.getMessage() + "</h2>");
		}
	%>
</body>
</html>