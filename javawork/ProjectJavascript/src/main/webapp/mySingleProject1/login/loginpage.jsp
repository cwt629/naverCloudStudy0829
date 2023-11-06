<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESCAPERS 로그인</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    div.app {
    	margin: 15% auto;
    	width: 400px;
    }
    
    div.loginbtns {
    	display: flex;
    	justify-content: center;
    }
    
    div.loginbtns button {
    	margin: 0 20px;
    }
</style>
</head>
<body>
	<div class="app">
		<h3>
		<i class="bi bi-person-circle">&nbsp;로그인</i>
		
		</h3>
		<form action="loginaction.jsp" method="post">
			<table class="table table-bordered" style="width: 400px;">
				<tr>
					<td width=60>ID</td>
					<td>
						<input type="text" class="form-control" name="id"
						style="width: 200px; margin-left: 10px;" autofocus required>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<input type="password" class="form-control" name="pw"
						style="width: 200px; margin-left: 10px;" required>
					</td>
				</tr>
			</table>
			<br>
			<div class="loginbtns">
				<button type="submit" class="btn btn-success">로그인</button>
				<button type="button" class="btn btn-secondary"
				onclick="location.href = '../signup/signuppage.jsp'">회원가입</button>
				<button type="button" class="btn btn-outline-warning"
				onclick="location.href = '../main.jsp'">홈으로</button>
			</div>
		</form>
	</div>
	
</body>
</html>