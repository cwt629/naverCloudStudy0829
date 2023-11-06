<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Part</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    #logindiv {
    	text-align: right;
    	height: 30px;
    }
    
    #logindiv button.loginbtn, #logindiv button.signupbtn {
    	margin: 20px 20px 0px 0px;
    }
    
    
</style>
<script>
	$(function(){
		$("button.loginbtn").click(function(){
			location.href = "../login/loginpage.jsp";
		});
		
		$("button.signupbtn").click(function(){
			location.href = "../signup/signuppage.jsp";
		});
	})
	
</script>
</head>
<body>
	<div id="logindiv">
		<button type="button" class="btn btn-secondary loginbtn">
			<i class="bi bi-person-circle"></i>
			&nbsp;
			로그인
		</button>
		<button type="button" class="btn btn-primary signupbtn">
			<i class="bi bi-person-plus-fill"></i>
			&nbsp;
			회원가입
		</button>
	</div>
</body>
</html>