<%@page import="escmembers.data.EscMembersDto"%>
<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Part</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    #logoutdiv {
    	text-align: right;
    	height: 30px;
    }
    
    #logoutdiv button {
    	margin: 10px 20px 0px 0px;
    }
</style>
</head>
<%
	String loggedinCode = "";
	String id = "";
	EscMembersDao dao = new EscMembersDao();

	// 쿠키에서 저장된 멤버코드 얻기
	Cookie []cookies = request.getCookies();
	
	if (cookies != null)
	{
		for (Cookie ck: cookies)
		{
			String name = ck.getName();
			// 로그인한 회원 코드를 쿠키에 저장해놓았으며, 이를 받아옴
			if (name.equals("loggedinCode")){
				loggedinCode = ck.getValue();
				// 아이디를 받아온다
				EscMembersDto dto = dao.getMemberDto(ck.getValue());
				id = dto.getId();
			}
		}
	}
%>
<script>
	$(function(){
		// 로그아웃
		$("button.logoutbtn").click(function(){
			alert("이용해주셔서 감사합니다! 또 들러주세요!");
			location.href = "../logout/logoutaction.jsp";
		})
		
		// 정보수정
		$("button.updatebtn").click(function(){
			location.href = "../membermanager/memberupdate.jsp?memcode=<%=loggedinCode%>";
		})
		
		// 회원탈퇴
		$("button.memdelbtn").click(function(){
			if (confirm("정말로 회원 탈퇴하시겠습니까?\n삭제되는 정보는 복구할 수 없습니다.")){
				location.href = "../membermanager/memberdeleteaction.jsp?memcode=<%=loggedinCode%>";
			}
		})
	})
</script>
<body>
	<div id="logoutdiv">
		<b><%=id %>님 환영합니다!</b>&nbsp;&nbsp;
		<button type="button" class="btn btn-outline-info updatebtn">
			<i class="bi bi-person-lines-fill">&nbsp;정보수정</i>
		</button>
		<button type="button" class="btn btn-outline-danger logoutbtn">
			<i class="bi bi-box-arrow-right">&nbsp;로그아웃</i>
		</button>
		<button type="button" class="btn btn-danger memdelbtn">
			<i class="bi bi-person-x-fill">&nbsp;회원탈퇴</i>
		</button>
	</div>
</body>
</html>