<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 게시판 : update form</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    .uploadcamera {
    	font-size: 25px;
		cursor: pointer;    	
    }
</style>
<script type="text/javascript">
	$(function(){
		// 카메라 이벤트
		$(".uploadcamera").click(function(){
			$("#upload").trigger("click"); // 클릭 이벤트 강제 발생
		});
		
		$("#upload").change(function(){
			  console.log("1:"+$(this)[0].files.length);
			  console.log("2:"+$(this)[0].files[0]);

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
				   /* 
				   Self: 원래 사진이 없던 글에 사진을 추가한 경우
				   display 속성을 바꿔서 다시 보여줘야 함
				   */
			   	$("#showimg").attr("src",e.target.result)
			   	.css("display", "block");
			   }

			   reader.readAsDataURL($(this)[0].files[0]);
			  }
		});
	})
</script>
</head>
<%
	// num
	String num = request.getParameter("num");

	// dao
	SimpleBoardDao dao = new SimpleBoardDao();
	
	// dto
	SimpleBoardDto dto = dao.getData(num);
%>
<body>
	<!-- 이미지 출력할곳 -->
 	<img id="showimg" src="../save/<%=dto.getPhoto() %>" 
 	style="position: absolute;left:600px;top:50px;max-width: 300px;"
 	onerror="this.style.display = 'none';"> <!-- error 발생 시 안보이게 처리(해당 파일이 없는 경우) -->
 	
	<div style="margin: 30px 50px;">
		<form action="./updateaction.jsp" method="post" enctype="multipart/form-data">
			<!-- num은 hidden으로 전달 -->
			<input type="hidden" name="num" value="<%=num %>">
			
			<table class="table table-bordered" style="width: 500px;">
				<caption align="top">글수정</caption>
				<tr>
					<th width="100">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control"
						style="width: 150px;" autofocus required
						value="<%=dto.getWriter()%>">
					</td>
				</tr>
				<tr>
					<th width="100">제목</th>
					<td class="input-group">
						<input type="text" name="subject" class="form-control" required
						value="<%=dto.getSubject()%>">
						
						<input type="file" name="upload" id="upload"
						style="display: none;">
						&nbsp;&nbsp;
						<!-- 카메라 아이콘 -->
						<i class="bi bi-camera-fill uploadcamera"></i>
					</td>
				</tr>
				<tr>
					<th width="100">내용</th>
					<td>
						<!-- 닫는 태그 앞에서는 엔터 누르면 들어가는듯..? 닫는 태그는 꼭 바로 옆에 붙여주자
						(옛날엔 그랬다는데 지금은 고쳐진듯? 이클립스 문제였나봄) -->
						<textarea style="width: 100%; height: 150px;" 
						name="content" required
						class="form-control"><%=dto.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success"
						style="width: 100px;">수정</button>
						
						<button type="button" class="btn btn-outline-success"
						style="width: 100px;" onclick="history.back()">이전</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>