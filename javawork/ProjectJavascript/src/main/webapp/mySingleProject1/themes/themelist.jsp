<%@page import="escmembers.data.EscMembersDto"%>
<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESCAPERS 테마 검색</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
    
    div.app {
    	margin-top: 30px;
    	text-align: center;
    }
    
    div.app>div {
    	margin: 0 auto;
    }
    
    div.app>div.searchedResults {
    	margin: 30px auto;
    }
    
    div.usersinput {
    	display: flex;
    	width: 950px;
    }
    
    div.usersinput button {
    	margin: 0px 5px;
    }
    
    input.searchtab {
    	width: 350px;
    }
    
    div.searchedResults {
    	width: 500px;
    }
    
    div.resultcard {
    	margin: 15px;
    	padding: 10px;
    	border: 5px ridge #495E57;
    	box-shadow: 10px 5px 5px #333;
    	cursor: pointer;
    }
    
    div.resultcard:hover {
    	border-color: black;
    	box-shadow: 15px 7px 7px #111;
    }
    
    div.resultcard div.resultimg img {
    	width: 250px;
    	height: auto;
    }
    
    button.searchdropdown {
    	width: 100px;
    }
</style>
<%
	Cookie []cookies = request.getCookies();
	boolean loggedIn = false;
	String loggedinCode = "";
	EscMembersDao memberDao = new EscMembersDao();
	EscMembersDto memberDto = null;
	String favoriteRegion = "";
	
	if (cookies != null)
	{
		for (Cookie ck: cookies)
		{
			String name = ck.getName();
			// 로그인한 회원 코드를 쿠키에 저장해놓았으며, 이를 받아옴
			if (name.equals("loggedinCode")){
				loggedIn = true;
				loggedinCode = ck.getValue();
				memberDto = memberDao.getMemberDto(loggedinCode);
				favoriteRegion = memberDto.getFavorplace();
			}
		}
	}
%>
<script>
	$(function(){
		// 검색 기준
		let searchStandard = "themename";
		// 처음에는 모든 테마 보여주기
		displayThemes("", searchStandard);
		// 로그인되지 않았다면, 지역버튼 hide
		if (!<%=loggedIn%>){
			$("button.regionsearch").hide();
		}
		
		// dropdown 이벤트
		$("ul.dropdown-menu>li>a.dropdown-item").click(function(){
			// 선택한 검색 기준
			searchStandard = $(this).attr("src");
			let standardName = $(this).text();
			// 버튼의 텍스트와 입력창 placeholder 변경
			$("div.dropdown>button.searchdropdown").text(standardName);
			$("input.searchtab").attr("placeholder", `검색할 \${standardName} 입력...`);
			
			// 검색하던 거 지워주기
			$("input.searchtab").val("");
			displayThemes("", searchStandard);
		});
		
		// 검색어 입력 이벤트
		$("input.searchtab").keyup(function(e){
			let query = e.target.value;
			console.log(query);
			displayThemes(query, searchStandard);
		});
		
		// 선호 테마 검색 버튼 클릭 이벤트
		$("button.regionsearch").click(function(){
			let favoriteRegion = `<%=favoriteRegion%>`;
			// 버튼의 텍스트와 입력창 변경
			$("div.dropdown>button.searchdropdown").text("지역");
			$("input.searchtab").attr("placeholder", `검색할 지역 입력...`);
			$("input.searchtab").val(favoriteRegion);
			displayThemes(favoriteRegion, "region");
			// 기준도 같이 변경해주기
			searchStandard = "region";
		})
		
		// 테마 카드 클릭 이벤트
		$(document).on("click", "div.resultcard", function(){
			// 클릭한 테마의 번호
			let clickedCode = $(this).attr("num");
			// 정보 창으로 이동
			location.href = "../reviews/reviewpage.jsp?roomcode=" + clickedCode;
		})
	});
	
	// 검색어 입력 시마다, 검색 기준에 따라 테마를 불러오는 함수
	function displayThemes(query, searchStandard){
		$.ajax({
			type: "get",
			dataType: "json",
			url: "themesearch.jsp",
			data: {"searching": query, "standard": searchStandard},
			success: function(res){
				let results = "";
				$.each(res, function(idx, item){
					let imgSrc = (item.image == "none")? "../../myimage/default.gif" : `../../save/\${item.image}`;

					results += 
					`
					<div class="resultcard" num="\${item.roomcode}">
						<div class="resultimg">
							<img src=\${imgSrc}>
						</div>
						<div class="resultinfo" style="margin-top: 10px;">
							<h4>\${item.themename}</h4>
							<h5>지점: \${item.cafename}</h5>
							<h5>장르: \${item.genre}</h5>
							<h5>지역: \${item.region}</h5>
						</div>
					</div>
					`;
				});
				
				// 아무것도 없으면 없다고 쓰기
				if (results.length === 0)
					results = "<h5>검색된 테마가 없습니다.</h5>"
					
				// 내용 반영
				$("div.searchedResults").html(results);
			}
		});
	}
</script>
</head>

<body>
	<div class="loginControl">
		<%
		if (loggedIn) {%>
			<jsp:include page="../logout/logoutpart_insidefolder.jsp"></jsp:include>
		<%} else {%>
			<jsp:include page="../login/loginpart_insidefolder.jsp"></jsp:include>
		<%}
		%>
	</div>
	<div class="app">
		<h3>
			<i class="bi bi-search">&nbsp;방탈출 테마 검색</i>
			
		</h3>
		<div class="usersinput">
			<div class="dropdown">
		  		<button type="button" class="btn btn-primary dropdown-toggle searchdropdown" data-bs-toggle="dropdown">
		    		테마명
		  		</button>
		  		<ul class="dropdown-menu">
		    		<li><a class="dropdown-item" href="#" src="themename">테마명</a></li>
		    		<li><a class="dropdown-item" href="#" src="cafename">지점명</a></li>
		    		<li><a class="dropdown-item" href="#" src="region">지역</a></li>
		    		<li><a class="dropdown-item" href="#" src="genre">장르</a></li>
		  		</ul>
			</div>
			<input type="text" class="form-control searchtab" placeholder="검색할 테마명 입력...">
			<button type="button" class="btn btn-outline-primary"
			onclick="location.href = 'themeregister.jsp'">
				<i class="bi bi-door-open-fill">&nbsp;방탈출 테마 등록</i>
				
			</button>
			<button type="button" class="btn btn-outline-info regionsearch">
				<i class="bi bi-geo-alt">&nbsp;선호 지역 테마 찾기</i>
				
			</button>
			<button type="button" class="btn btn-outline-warning"
			onclick="location.href = '../main.jsp'">
				홈으로
			</button>
		</div>
		
		
		<%-- 검색 결과 나오는 div --%>
		<div class="searchedResults">
			<%-- 
			<div class="resultcard">
				<div class="resultimg">
					<img src="../../save/money2.png">
				</div>
				<div class="resultinfo">
					<h4>내 오만원권이 사라졌어요</h4>
					<h5>지점: 비트캠프 강남점</h5>
					<h5>장르: 스릴러</h5>
					<h5>지역: 강남</h5>
				</div>
			</div>
			<div class="resultcard">
				<div class="resultimg">
					<img src="../../save/money2.png">
				</div>
				<div class="resultinfo">
					<h4>Please Find my 50000 bill</h4>
					<h5>지점: 아앙탈출</h5>
					<h5>장르: 공포</h5>
					<h5>지역: 홍대</h5>
				</div>
			</div>
			--%>
		</div>
	</div>
</body>
</html>