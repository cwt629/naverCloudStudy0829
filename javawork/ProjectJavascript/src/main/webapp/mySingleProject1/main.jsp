<%@page import="escthemes.data.EscThemesDto"%>
<%@page import="java.util.List"%>
<%@page import="escreviews.data.EscReviewsDto"%>
<%@page import="escreviews.data.EscReviewsDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="escmembers.data.EscMembersDto"%>
<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESCAPERS : 방탈출 정보 페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>

    div.app {
		margin: 30px;
		font-family: 'Jua';
	}
	
	div.escTitle>h2 {
		font-size: 50px;
		text-align: center;
		color: #3D0C11;
		font-family: 'Permanent Marker';
	}
	
	div.escBreadcrumb {
		display: flex;
		justify-content: center;
	}
	
	div.escBreadcrumb button {
		margin: 20px;
		width: 200px;
		height: 50px;
		font-size: 22px;
	}
	
	div.escrank {
		width: 1300px;
		text-align: center;
		margin: 0 auto;
	}
	
	div.escrank div.rankrooms {
		display: flex;
		justify-content: center;
	}
	
	div.escrank div.rankrooms figure.themefig{
		margin: 15px;
    	padding: 10px;
    	border: 5px ridge #495E57;
    	box-shadow: 10px 5px 5px #333;
    	cursor: pointer;
    }
    
    div.escrank div.rankrooms figure.themefig:hover {
    	border-color: black;
    	box-shadow: 15px 7px 7px #111;
    }
    
</style>
</head>
<%
	Cookie []cookies = request.getCookies();
	boolean loggedIn = false;
	String loggedinCode = "";
	EscMembersDao dao = new EscMembersDao();
	EscMembersDto dto = null;
	EscReviewsDao reviewdao = new EscReviewsDao();
	
	if (cookies != null)
	{
		for (Cookie ck: cookies)
		{
			String name = ck.getName();
			// 로그인한 회원 코드를 쿠키에 저장해놓았으며, 이를 받아옴
			if (name.equals("loggedinCode")){
				loggedIn = true;
				loggedinCode = ck.getValue();
				dto = dao.getMemberDto(loggedinCode);
			}
		}
	}
	
	// 모달에 띄울 정보들
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String userId = (dto != null)? dto.getId() : "로그인 필요"; 
	String userFavorplace = (dto != null)? dto.getFavorplace() : "로그인 필요"; 
	String userRegistereddate = (dto != null)? sdf.format(dto.getRegisteredDate()) : "로그인 필요";
	// 유저가 리뷰 쓴 방 개수
	int userEscapedCount = (dto != null)? reviewdao.getReviewsByMember(loggedinCode).size() : 0;
%>
<script>
	$(function(){
		$("button.searchbtn").click(function(){
			location.href = 'themes/themelist.jsp';
		})
		
		$("button.addthemebtn").click(function(){
			location.href = 'themes/themeregister.jsp';
		})
		
		// 평점 좋은 방탈출 클릭 이벤트
		$("figure.themefig").click(function(){
			// roomcode 받기
			let roomcode = $(this).attr("num");
			location.href = 'reviews/reviewpage.jsp?roomcode=' + roomcode;
		})
	})
	
	
</script>
<body>
	<div class="loginControl">
		<%
		if (loggedIn) {%>
			<jsp:include page="./logout/logoutpart.jsp"></jsp:include>
		<%} else {%>
			<jsp:include page="./login/loginpart.jsp"></jsp:include>
		<%}
		%>
	</div>
	
	<div class="app">
		<div class="escTitle">
			<h2>ESCAPERS</h2>
		</div>
		<div class="escBreadcrumb">
			<button type="button" class="btn btn-outline-secondary searchbtn">
				<i class="bi bi-search"></i>
				&nbsp;
				테마 검색
			</button>
			<button type="button" class="btn btn-outline-primary addthemebtn">
				<i class="bi bi-door-open-fill"></i>
				&nbsp;
				테마 등록
			</button>
			<button type="button" class="btn btn-outline-success myinfobtn"
			data-bs-toggle="modal" data-bs-target="#myModal">
				<i class="bi bi-person-bounding-box"></i>
				&nbsp;
				나의 정보
			</button>
		</div>
		
		<div class="escrank">
			<h2>평가 좋은 방탈출 테마 TOP 3</h2>
			<div class="rankrooms">
			<%
				List<EscThemesDto> topThemes = reviewdao.getRoomTopN(3);
				for (EscThemesDto theme:topThemes){%>
					<figure class="themefig" num="<%=theme.getRoomcode()%>">
						<img src="<%=theme.getImage().equals("none")?  "../myimage/default.gif" : "../save/" + theme.getImage()%>" 
						style="width: 400px; margin-bottom: 20px;">
						<figcaption>
							<h3><%=theme.getThemename() %></h3>
							<h5 style="color: #555;"><%=theme.getCafename() %></h5>
							<h5 style="color: #777;"><%=theme.getGenre() %></h5>
							<h5>평점: <%=String.format("%.1f", reviewdao.getAveragePoint(theme.getRoomcode())) %> / 5.0</h5>
						</figcaption>
					</figure>
				<%}
			%>
			</div>
			
		</div>
	</div>
	
	<%-- 나의 정보를 보여줄 Modal --%>
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
	
		   		<!-- Modal Header -->
		   		<div class="modal-header">
		   			<h4 class="modal-title">사용자 정보</h4>
		   			<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		  		</div>
					
		  		<!-- Modal body -->
		   		<div class="modal-body">
	        		<table class="table table-bordered">
	        			<tr>
	        				<td width=200>아이디</td>
	        				<td><%=userId %></td>
	        			</tr>
	        			<tr>
	        				<td width=50>선호 장소</td>
	        				<td><%=userFavorplace %></td>
	        			</tr>
	        			<tr>
	        				<td width=50>회원등록일</td>
	        				<td><%=userRegistereddate %></td>
	        			</tr>
	        			<tr>
	        				<td width=50>방탈출 개수</td>
	        				<td>
	        				<b><%=userEscapedCount%>방</b><br>
	        				* 리뷰 작성 기준입니다
	        				</td>
	        			</tr>
	        		</table>
	      		</div>
				
	      		<!-- Modal footer -->
	      		<div class="modal-footer">
	        		<button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
	      		</div>
		
	   		</div>
		</div>
	</div>
	
</body>
</html>