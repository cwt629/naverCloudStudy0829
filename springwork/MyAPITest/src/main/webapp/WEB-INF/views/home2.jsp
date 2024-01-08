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
	const BASE_URL = "http://apis.data.go.kr/B551011/KorService1";
	const ENC_KEY = "t%2BaPlQWgYTpT%2FIe4h2Ew%2FDfmCh3lHWaleDh311A5XZPa3DWZ3uiXuJ6se8aI4oO188kaRL6xO11aHuCw3VPtfw%3D%3D";
	const DEC_KEY = "t+aPlQWgYTpT/Ie4h2Ew/DfmCh3lHWaleDh311A5XZPa3DWZ3uiXuJ6se8aI4oO188kaRL6xO11aHuCw3VPtfw=="
	const REQUEST_CATEGORY = "areaBasedList1";
	$(function(){
		$("#apicall").click(function(){
			$.ajax({
			type: "get",
			url: `\${BASE_URL}/\${REQUEST_CATEGORY}`,
			data: {
				"MobileOS": "ETC",
				"MobileApp": "testing",
				"_type": "json",
				"contentTypeId": "12",
				"serviceKey": ENC_KEY
			},
			success: function(res){
				console.log(res);
				$("#apiresultalarm").text("된다 콘솔 봐봐라");
			},
			error: function(err){
				console.log("Error Occurred: ");
				console.log(err);
			}
		});
		})
		
	})
</script>
</head>
<body>
	<h2>되냐?</h2>
	<button type="button" class="btn btn-outline-secondary" id="apicall">호출해보기</button>
	<div id="apiresultalarm"></div>
</body>
</html>