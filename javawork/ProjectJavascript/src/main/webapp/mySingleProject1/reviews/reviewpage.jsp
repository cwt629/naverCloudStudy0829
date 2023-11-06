<%@page import="java.util.List"%>
<%@page import="escreviews.data.EscReviewsDao"%>
<%@page import="escreviews.data.EscReviewsDto"%>
<%@page import="escthemes.data.EscThemesDto"%>
<%@page import="escthemes.data.EscThemesDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="escmembers.data.EscMembersDto"%>
<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESCAPERS 테마 정보</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    span.clickableStars {
    	cursor: pointer;
    }
    
    div.app {
    	margin-top: 40px;
    }
    
    div.app>h3 {
    	text-align: center;
    	margin-bottom: 20px;
    }
    
    div.app>div {
    	margin: 0 auto;
    }
    
    div.infodiv>div.infotable {
    	display: flex;
    	justify-content: center;
    }
    
    div.infodiv table td.imagearea img {
    	width: 450px;
    	height: auto;
    }
    
    div.infobuttons {
    	display: flex;
    	justify-content: center;
    	margin-bottom: 20px;
    }
    
    div.infobuttons button {
    	margin: 0 20px;
    }
    
    div.reviewdiv {
    	text-align: center;
    }
    
    div.reviewdiv>div {
    	margin: 0 auto;
    }
    
    div.reviewdiv div.myreviewdiv {
    	background-color: black;
    	border-radius: 10px;
    	width: 700px;
    	padding: 20px 10px;
    }
    
    div.reviewdiv div.reviewstar {
    	
    	color: #FFD700;
    	font-size: 45px;
    }
    
    div.reviewdiv div.reviewstar div.starpoints{
    	font-size: 25px;
    }
    
    div.reviewdiv div.reviewstar span {
    	margin: 10px 20px;
    }
    
    div.reviewdiv div.reviewcomment {
    	color: white;
    }
    
    div.reviewdiv div.otherreviewsdiv {
    	margin: 30px;
    }
    
    div.reviewdiv div.otherreviewsdiv div.otherreviews div.otherreviewcard{
    	/*background-color: #252B48;*/
    	/*border-radius: 10px;*/
    	width: 500px;
    	padding: 10px;
    	margin: 5px auto;
    }
    
    div.reviewdiv div.otherreviewsdiv div.otherreviews div.otherreviewcard div.otherreviewstar {
    	color: #FFD700;
    	font-size: 15px;
    }
    
</style>
</head>
<%
	// 쿠키(로그인 정보)
	Cookie []cookies = request.getCookies();
	boolean loggedIn = false;
	String loggedinCode = "";
	EscMembersDao memberDao = new EscMembersDao();
	EscMembersDto memberDto = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
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
			}
		}
	}
	
	String roomcode = request.getParameter("roomcode");
	EscThemesDao themedao = new EscThemesDao();
	EscThemesDto themedto = themedao.getThemeByCode(roomcode);
	
	// 리뷰 가져오기
	EscReviewsDao reviewdao = new EscReviewsDao();
	EscReviewsDto reviewdto = reviewdao.getThemeReviewByMemcode(roomcode, loggedinCode);
	List<EscReviewsDto> otherreviewdtos = reviewdao.getReviewsByTheme(roomcode);
	
	// 리뷰 작성 여부
	boolean reviewed = (reviewdto.getMemcode() != null);
	
	// 본인이 작성한 테마인지 여부
	boolean isMyTheme = themedto.getMemcode().equals(loggedinCode);
%>
<script>
	// 꽉찬 별 & 빈 별 아이콘
	const FULL_STAR_ICON_TAG = `<i class="bi bi-star-fill"></i>`;
	const EMPTY_STAR_ICON_TAG = `<i class="bi bi-star"></i>`;
	// 최대 별점
	const MAX_POINT = 5;
	// 선택 별점
	let point = 5;

	$(function(){
		fillMyReview(); // 상황에 따라 리뷰칸 채우기
		
		// 테마의 제작자만이 수정/삭제 버튼을 볼 수 있게 한다
		if (!<%=isMyTheme%>){
			$("button.themeupdatebtn").hide();
			$("button.themedelbtn").hide();
		}
		
		// 별점(수정 시) 클릭 이벤트
		$(document).on("click", "span.clickableStars", function(){
			point = parseInt($(this).attr("num"));
			
			let newStars = 
				`
				\${getStarClickable(point)}
				<div class="starpoints">
					<b class="selectedpoint">\${point}</b>&nbsp;<b>/ 5점</b>
				</div>
				`;
			$("div.reviewstar").html(newStars);
			$("#selPoint").val(point); // 폼에도 밸류 적용
		});
		
		// 테마 수정 버튼 클릭 이벤트
		$("button.themeupdatebtn").click(function(){
			if (!<%=isMyTheme%>){
				alert("테마를 수정할 권한이 없습니다.");
				return;
			}
			location.href = '../themes/themeupdate.jsp?roomcode=' + `<%=roomcode%>`;
		})
		
		// 테마 삭제 버튼 클릭 이벤트
		$("button.themedelbtn").click(function(){
			// 본인이 아닌 경우 삭제 불가
			if (!<%=isMyTheme%>){
				alert("테마를 삭제할 권한이 없습니다.");
				return;
			}
			// 삭제 확인
			if (confirm("정말로 테마를 삭제하시겠습니까?\n삭제 이후에는 복구할 수 없습니다.")){
				location.href = '../themes/themedeleteaction.jsp?roomcode=' + `<%=roomcode%>`;
			}
		})
	});
	
	// 나의 리뷰 칸을 채우는 함수
	function fillMyReview(){
		let contents = "";
		
		// 1. 로그인하지 않은 경우
		if (!<%=loggedIn %>){
			contents = `<button class="btn btn-outline-secondary loginbtn"
			onclick="location.href = '../login/loginpage.jsp'">
				<i class="bi bi-exclamation-circle">&nbsp;로그인 필요</i>
			</button>`;
		}
		// 2. 리뷰를 작성하지 않은 경우
		else if (!<%=reviewed%>){
			let curMemcode = `<%=loggedinCode%>`;
			let curRoomcode = `<%=roomcode%>`;
			contents = 
			`
			<p style="color: white">플레이하신 리뷰를 남겨주세요!</p>
			<div class="reviewstar">
				\${getStarClickable(5)}
				<div class="starpoints">
					<b class="selectedpoint">5</b>&nbsp;<b>/ 5점</b>
				</div>
			</div>
			<form action="reviewaction.jsp">
				<input type="hidden" name="point" id="selPoint" value="\${point}">
				<input type="hidden" name="memcode" value="\${curMemcode}">
				<input type="hidden" name="roomcode" value="\${curRoomcode}">
				
				<textarea name="comment" style="width: 50%; height: 150px;"></textarea>
				<br>
				<button type="submit" class="btn btn-outline-success">리뷰 작성</button>
			</form>
			`;
		}
		// 3. 리뷰를 작성한 경우
		else {
			point = parseInt(<%=reviewdto.getScore()%>);
			//let comment = 
			//let mycomment = comment.replace("\n", "<br>");
			contents = 
			`
			<p style="color: white">회원님이 작성하신 리뷰입니다.</p>
			<div class="reviewstar">
				\${getStarDisplay(point)}
				<div class="starpoints">
				<b class="selectedpoint">\${point}</b>&nbsp;<b>/ 5점</b>
				</div>
			</div>
			<div class="reviewcomment">
				<%=
				(reviewdto.getComment() != null)?
				reviewdto.getComment().replace("\n", "<br>") : ""
				%>
			</div>
			`;
		}
		
		$("div.myreview").html(contents);
	}
	
	// 클릭한 별이 몇번째인지에 따라 보여줄 별 5개 태그 배열을 반환하는 함수
	function getStarComponents(num){
		let stars = [];
		for (let i = 1; i <= MAX_POINT; i++){
			let curStarIcon = (i <= num)? FULL_STAR_ICON_TAG : EMPTY_STAR_ICON_TAG;
			stars.push(curStarIcon);
		}
		
		return stars;
	}
	
	// 단순 보여주기 위한 별점을 출력하는 함수
	function getStarDisplay(num){
		let stars = getStarComponents(num).map((star) => (`<span>\${star}</span>`)).join("");
		let starDiv = 
			`
			<div class="stars">
				\${stars}
			</div>
			`;
		
		return starDiv;
	}
	
	// 클릭하여 별점 설정할 수 있는 별점을 출력하는 함수
	function getStarClickable(num){
		let stars = getStarComponents(num).map((star, index) => (`<span class="clickableStars" num=\${index + 1}>\${star}</span>`)).join("");
		let starDiv = 
			`
			<div class="stars">
				\${stars}
			</div>
			`;
		
		return starDiv;
	}
	
</script>
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
		<i class="bi bi-key">&nbsp;테마 정보</i>
		</h3>
		<div class="infodiv">
			<div class="infotable">
				<table class="table table-bordered" style="width: 800px;">
					<tr>
						<td width=450 class="imagearea">
							<img src="<%=themedto.getImage().equals("none")? "../../myimage/default.gif" : "../../save/" + themedto.getImage()%>">
						</td>
						<td width=350>
							<h4 class="themename"><%=themedto.getThemename() %></h4>
							<h6 style="color: gray;">등록자: <%=memberDao.getIdByMemcode(themedto.getMemcode())%></h6>
							<h6 style="color: gray;">지점명: <%=themedto.getCafename() %></h6>
							<h6 style="color: gray;">장르: <%=themedto.getGenre() %></h6>
							<h6 style="color: gray;">지역: <%=themedto.getRegion() %></h6>
							<h6 style="color: gray;">등록일: <%=sdf.format(themedto.getRegisteredDate()) %></h6>
							<h6 style="color: blue;">평점: <%=String.format("%.1f", reviewdao.getAveragePoint(themedto.getRoomcode())) %> / 5.0</h6>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="padding: 20px;">
							<%=themedto.getExplanation().replace("\n", "<br>") %>
						</td>
					</tr>
				</table>
			</div>
			<div class="infobuttons">
				<button type="button" class="btn btn-outline-primary themeupdatebtn">정보 수정</button>
				<button type="button" class="btn btn-outline-danger themedelbtn">테마 삭제</button>
				<button type="button" class="btn btn-outline-warning"
				onclick="location.href = '../themes/themelist.jsp'">목록으로</button>
			</div>
			
		</div>
		<div class="reviewdiv">
			<div class="myreviewdiv">
				<h3 style="color: white;">
					<i class="bi bi-chat-text-fill">&nbsp;My Review</i>
				</h3>
				<div class="myreview">
					
				</div>
			</div>
			<div class="otherreviewsdiv">
				<h3>
					<i class="bi bi-chat-text">&nbsp;All Reviews</i>
				</h3>
				<div class="otherreviews">
					<%
						if (otherreviewdtos.size() == 0){%>
							<b style="font-size: 18px;">아직 작성된 리뷰가 없습니다.</b>
						<%} else {
							for (EscReviewsDto rev: otherreviewdtos) {%>
								<div class="otherreviewcard">
									<hr>
									<b><%=memberDao.getIdByMemcode(rev.getMemcode()) %></b>
									<div class="otherreviewstar">
										<script>
											document.write(getStarDisplay(<%=rev.getScore()%>));
										</script>
									</div>
									<br>
									<b style="color: gray"><%=sdf.format(rev.getWriteday()) %></b>
									<div class="otherreviewcomment">
										<%= rev.getComment().replace("\n", "<br>") %>
									</div>
								</div>
							<%}
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>