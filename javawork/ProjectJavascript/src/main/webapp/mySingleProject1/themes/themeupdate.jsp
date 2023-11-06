<%@page import="escthemes.data.EscThemesDto"%>
<%@page import="escthemes.data.EscThemesDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESCAPERS 테마 등록</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    div.app {
    	margin: 10% auto;
    	width: 760px;
    }
    
    i.uploadphoto {
    	cursor: pointer;
    	margin-left: 20px;
    	font-size: 22px;
    }
    
    div.btndiv {
    	display: flex;
    	justify-content: center;
    }
    
    div.btndiv button {
    	margin: 0 20px;
    }
</style>
<script>
	$(function(){
		// 이미지 추가 버튼
		$("i.uploadphoto").click(function(){
			$("#themefile").trigger("click");
		})
		
		$("#themefile").change(function(){
			//정규표현식
			  var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
			  var f = $(this)[0].files[0];//현재 선택한 파일
			  if(!f.type.match(reg)){
			     alert("확장자가 이미지파일이 아닙니다");
			     return;
			  }
			
			  if($(this)[0].files[0]){
			   var reader=new FileReader();
			   reader.onload=function(e){
			   	$("#themeimg").attr("src",e.target.result)
			   	.css("display", "block");
			   }

			   reader.readAsDataURL($(this)[0].files[0]);
			  }
		})
	})
</script>
</head>
<%
	String roomcode = request.getParameter("roomcode");
	Cookie []cookies = request.getCookies();
	boolean loggedIn = false;
	String memcode = "";
	if (cookies != null)
	{
		for (Cookie ck: cookies)
		{
			String name = ck.getName();
			// 로그인한 회원 코드를 쿠키에 저장해놓았으며, 이를 받아옴
			if (name.equals("loggedinCode")){
				loggedIn = true;
				memcode = ck.getValue();
			}
		}
	}
	
	EscThemesDao dao = new EscThemesDao();
	EscThemesDto dto = dao.getThemeByCode(roomcode);
	// 본인이 작성한 테마인지 여부
	boolean isMyTheme = dto.getMemcode().equals(memcode);
%>
<body>
	<div class="app">
		<h3>
			<i class="bi bi-clipboard2-plus">&nbsp;테마 수정</i>
			
		</h3>
		
		<form action="themeupdateaction.jsp" method="post" enctype="multipart/form-data">
			<!-- memcode와 roomcode 넘겨주기 -->
			<input type="hidden" name="memcode" value="<%=memcode %>">
			<input type="hidden" name="roomcode" value="<%=roomcode %>">
			<table class="table table-bordered" style="width: 720px;">
				<tr>
					<td width=120>
						테마명
					</td>
					<td width=300>
						<input type="text" class="form-control" name="themename" value="<%=dto.getThemename() %>"
						style="width: 250px; margin-left: 10px;" required>
					</td>
					<td rowspan="5" id="themeimageTab" width=300>
						<%-- 이미지 부분 --%>
						<img id="themeimg" style="width: 300px; margin: 10px;"
						src="<%=dto.getImage().equals("none")? "../../myimage/default.gif" : "../../save/" + dto.getImage()%>">
					</td>
				</tr>
				<tr>
					<td>
						지점명
					</td>
					<td>
						<input type="text" class="form-control" name="cafename" value="<%=dto.getCafename() %>"
						style="width: 250px; margin-left: 10px;" required>
					</td>
				</tr>
				<tr>
					<td>
						지역
					</td>
					<td>
						<select class="form-control myregion" name="region" style="margin-left: 10px; width: 250px;" required>
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
							<option value="기타">기타</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						사진추가
					</td>
					<td>
						<input type="file" name="image" id="themefile"
							style="display: none;">
						<label class="photoadder">
							
							<i class="bi bi-images uploadphoto">사진 등록</i>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						장르
					</td>
					<td>
						<input type="text" class="form-control" name="genre" value="<%=dto.getGenre() %>"
						style="width: 100px; margin-left: 10px;" required>
					</td>
				</tr>
				<tr>
					<td>
						테마 설명
					</td>
					<td colspan="2">
						<textarea style="width: 100%; height: 150px;" name="explanation" required><%=dto.getExplanation().trim() %></textarea>
					</td>
				</tr>
			</table>
			<div class="btndiv">
				<button type="submit" class="btn btn-outline-primary">테마 수정</button>
				<button type="button" class="btn btn-outline-warning"
				onclick="history.back()">뒤로가기</button>
			</div>
		</form>
	</div>
	
	<script>
		// 선택된 지역
		let options = $("select.myregion option");
		let selectedOption = `<%=dto.getRegion()%>`;

		for (let option of options){
			if (option.value == selectedOption)
				option.selected = true;
		}
	</script>
</body>
</html>