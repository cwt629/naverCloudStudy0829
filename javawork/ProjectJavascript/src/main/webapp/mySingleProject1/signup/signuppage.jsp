<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESCAPERS 회원가입</title>
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
    	width: 600px;
    }
    
    div.btndiv {
    	display: flex;
    	justify-content: center;
    }
    
    div.btndiv button {
    	margin: 0 20px;
    }
</style>
</head>
<body>
	<div class="app">
		<h3>
			<i class="bi bi-person-plus-fill">&nbsp;회원가입</i>
		</h3>
		
		<form action="signupaction.jsp" method="post">
			<table class="table table-bordered" style="width: 400px;">
				<tr>
					<td width=150>
						ID
					</td>
					<td>
						<input type="text" class="form-control" maxlength="12" name="id"
						style="width: 200px; margin-left: 10px;" autofocus required>
					</td>
				</tr>
				<tr>
					<td>
						Password
					</td>
					<td>
						<input type="password" class="form-control" maxlength="20" name="pw"
						style="width: 200px; margin-left: 10px;" required>
					</td>
				</tr>
				<tr>
					<td>
						Password 확인
					</td>
					<td>
						<input type="password" class="form-control" maxlength="20" name="pwCheck"
						style="width: 200px; margin-left: 10px;" required>
					</td>
				</tr>
				<tr>
					<td>
						선호 장소
					</td>
					<td>
						<select class="form-control" name="favorplace" required>
							<option selected disabled hidden>--장소 선택--</option>
							<option value="강남">강남</option>
							<option value="홍대">홍대</option>
							<option value="신촌">신촌</option>
							<option value="대학로">대학로</option>
							<option value="압구정">압구정</option>
							<option value="건대">건대</option>
							<option value="인천">인천</option>
							<option value="대전">대전</option>
							<option value="대구">대구</option>
							<option value="부산">부산</option>
							<option value="제주">제주</option>
						</select>
					</td>
				</tr>
			</table>
			<div class="btndiv">
				<button type="submit" class="btn btn-outline-secondary">회원가입</button>
				<button type="button" class="btn btn-outline-warning"
				onclick="location.href = '../main.jsp'">홈으로</button>
			</div>
			
		</form>
	</div>
	
</body>
</html>