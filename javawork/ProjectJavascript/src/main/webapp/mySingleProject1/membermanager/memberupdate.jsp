<%@page import="escmembers.data.EscMembersDto"%>
<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESCAPERS 회원 정보 수정</title>
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
    
    div.btndiv {
    	display: flex;
    	justify-content: center;
    }
    
    div.btndiv button {
    	margin: 0 20px;
    }
</style>
</head>
<%
	String memcode = request.getParameter("memcode");
	EscMembersDao dao = new EscMembersDao();
	EscMembersDto dto = dao.getMemberDto(memcode);
%>
<script>
	$(function(){
		// option을 선택 되게 하기
		let options = $("select.myfavorplace option");
		let selectedOption = `<%=dto.getFavorplace()%>`;
		for (let option of options){
			if (option.value == String(selectedOption))
				option.selected = true;
		}
	})
</script>
<body>
	<div class="app">
		<h3>
			<i class="bi bi-person-plus-fill">&nbsp;회원정보 수정</i>
		</h3>
		
		<form action="memberupdateaction.jsp" method="post">
			<input type="hidden" name="memcode" value="<%=memcode %>">
			<table class="table table-bordered" style="width: 400px;">
				<tr>
					<td width=150>
						ID
					</td>
					<td>
						<%=dto.getId() %>
					</td>
				</tr>
				<tr>
					<td>
						Password 변경<br>
						(변경 시에만 입력)
					</td>
					<td>
						<input type="password" class="form-control" maxlength="20" name="pw"
						style="width: 200px; margin-left: 10px;">
					</td>
				</tr>
				<tr>
					<td>
						새 Password 확인 <br>
						(변경 시에만 입력)
					</td>
					<td>
						<input type="password" class="form-control" maxlength="20" name="pwCheck"
						style="width: 200px; margin-left: 10px;">
					</td>
				</tr>
				<tr>
					<td>
						선호 장소
					</td>
					<td>
						<select class="form-control myfavorplace" name="favorplace" required>
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
				<button type="submit" class="btn btn-outline-secondary">정보 수정</button>
				<button type="button" class="btn btn-outline-warning"
				onclick="location.href = '../main.jsp'">홈으로</button>
			</div>
			
		</form>
	</div>
	
</body>
</html>