<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
<script>
	const END_POINT = "http://apis.data.go.kr/B551011/Durunubi";
	const ENC_KEY = "t%2BaPlQWgYTpT%2FIe4h2Ew%2FDfmCh3lHWaleDh311A5XZPa3DWZ3uiXuJ6se8aI4oO188kaRL6xO11aHuCw3VPtfw%3D%3D";
	
	$(function(){
		$.ajax({
			type: "get",
			dataType: "json",
			url: "http://apis.data.go.kr/B551011/Durunubi/courseList?serviceKey=" + ENC_KEY + "&pageNo=1&numOfRows=10&MobileOS=ETC&MobileApp=AppTest&crsKorNm=밀양강&crsLevel=2&brdDiv= DNBW",
			success: function(res){
				console.log(res);
			}
		});
	})
</script>
</head>
<body>
	<h2>되냐?</h2>
</body>
</html>