<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
   
   span.day {
       font-size: 11px;
       color: gray;
   }
  
</style>
<script>
	$(function(){
		list();
		
		// 댓글 카메라 클릭 시 파일 업로드 버튼 실행
		$(".uploadcamera").click(function(){
			$("#upload").trigger("click");
		});
		
		// 사진 업로드
		$("#upload").change(function(){
			let formData = new FormData();
			// 참고: 파일 여러개면 i에 대해 for문 돌리면서 files[i]로 넣어주기?
			formData.append("upload", $("#upload")[0].files[0]);
			$.ajax({
				type: "post",
				dataType: "json",
				url: "../answer/upload",
				data: formData,
				processData: false,
				contentType: false,
				success: function(res){
					// 업로드 후에 반환받은 파일명을 댓글의 이미지에 넣어준다
					$("img.answerphoto").attr("src", `../res/upload/\${res.photoname}`);
				}
			});
		});
		
		// 댓글 추가 이벤트
		$("#btnansweradd").click(function(){
			let msg = $("#answermsg").val();
			let num = ${dto.num};
			if (msg.length == 0) {
				alert("댓글 내용을 입력하세요.");
				return;
			}
			//alert(msg + ":" + num);
			
			$.ajax({
				type: "post",
				dataType: "text",
				url: "../answer/insert",
				data: {"num": num, "msg": msg},
				success: function(res){
					// DB insert 성공 후 댓글 목록 다시 출력
					list();
					// 입력창 초기화
					$("#answermsg").val("");
					// 댓글 사진 초기화
					$("img.answerphoto").attr("src", "../res/photo/noimage.png");
				}
			});
		});
		
		// 댓글 삭제 이벤트
		$(document).on("click", ".ansdel", function(){
			if (!confirm("정말로 해당 댓글을 삭제하시겠습니까?")) return;
			
			let ansidx = $(this).attr("ansidx");
			$.ajax({
				type: "get",
				dataType: "text",
				url: "../answer/delete",
				data: {"ansidx": ansidx},
				success: function(res){
					// DB delete 성공 후 댓글 목록 다시 출력
					list();
				}
			});
		});
	}); // end of function
	
	function list()
	{
		let num = ${dto.num};
		
		// 댓글 출력하는 함수
		$.ajax({
			type: "get",
			dataType: "json",
			url: "../answer/list",
			data: {"num": num},
			success: function(res){
				$("#answercount").text("댓글 " + res.length);
				
				let s = "";
				$.each(res, function(idx, item){
					s += 
					`
					\${item.ansname}(\${item.ansid}) : 
					`;
					if (item.ansphoto != null){
						s += 
							`
							<img src="../res/upload/\${item.ansphoto}" width=60 height=60 border=1 hspace=20>
							`;
					}
					s += 
						`<span style="margin-left: 20px;">\${item.ansmsg}</span>
						&nbsp;
						<span style="color: gray; font-size: 0.9em;">\${item.writeday}</span>
						`;
					
					// 본인으로 로그인한 상태에서만 삭제 버튼이 보인다
					if (${sessionScope.loginok != null} && item.ansid == "${sessionScope.myid}"){
						s += `<i class="bi bi-trash ansdel" ansidx="\${item.ansidx}" style="cursor: pointer;"></i>`;
					}
					
					s += "<br>";
					
				});
				
				$("div.answerlist").html(s);
			}
		});
	}
</script>
</head>
<body>
	<div>
		<h3 style="text-align: left;"><b>${dto.subject}</b></h3>
		<br>
		<img src="../res/upload/${profile_photo}"
		class="rounded-circle" border="1" hspace="10" align="left"
		width="50" height="50" onerror="this.src = '../res/photo/default.gif'">
		<div style="text-align: left;">
			<b>${dto.writer}</b><br>
			<span class="day">
				<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
			</span>
			<br><br>
			<pre style="font-size: 17px;">${dto.content}</pre>
			<br><br>
			<c:if test="${dto.photocount > 0}">
				<c:forEach var="photo" items="${dto.photoNames}">
					<!-- max-width 70%로 하니까, 브라우저 크기에 따라 달라진다 -->
					<img src="../res/upload/${photo}" style="max-width: 70%;">
					<br><br>
				</c:forEach>
				<br><br>
			</c:if>
		</div>
		<div style="text-align: left;">
			<!-- 20231127: 댓글 -->
			<div id="answercount">댓글 0</div>
			<div class="answerlist" style="margin-left: 10px;">
				
			</div>
			<c:if test="${sessionScope.loginok != null}">
				<div class="answerform input-group" style="text-align: left; width: 600px;">
					<input type="file" id="upload" style="display: none;">
					<i class="bi bi-camera-fill uploadcamera" style="cursor: pointer; font-size: 23px;"></i>
					<img src="" class="answerphoto" width="50" height="50" border="1"
					onerror="this.src = '../res/photo/default.gif'" hspace="10">
					
					<input type="text" class="form-control" style="width: 300px;" placeholder="댓글내용"
					id="answermsg">
					<button type="button" class="btn btn-sm btn-outline-success" id="btnansweradd">저장</button>
				</div>
			</c:if>
		
			<!-- 새 글: 파라미터를 아무것도 넘기지 않으므로, default로 처리 -->
			<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;"
			onclick="location.href = './form'">글쓰기</button>
			
			<!-- 답글: 파라미터 5개를 모두 보내줘야 함 -->
			<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;"
			onclick="location.href = './form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">답글</button>
			
			<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;"
			onclick="location.href = './list?currentPage=${currentPage}'">목록</button>
			
			<!-- 로그인한 사람이 쓴 글에만 수정/삭제 버튼이 보이도록 한다 -->
			<c:if test="${sessionScope.loginok != null and sessionScope.myid == dto.myid }">
				<button type="button" class="btn btn-outline-secondary btn-sm"
				style="width: 80px;"
				onclick="location.href = './updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
				
				<button type="button" class="btn btn-outline-secondary btn-sm"
				style="width: 80px;"
				onclick="location.href = './delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
			</c:if>
		</div>
		<div id="answerend"></div> <!-- 댓글부 자동 이동용 div -->
	</div>
</body>
</html>