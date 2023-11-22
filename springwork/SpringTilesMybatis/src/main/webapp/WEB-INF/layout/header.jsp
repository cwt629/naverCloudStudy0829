<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
<!-- 어느 위치인지에 따라 상대경로가 달라지므로, root를 얻어 절대경로로 가야 한다 -->
<!-- 예컨대 홈페이지에서는 /mini까지 얻음 -->
<c:set var="root" value="<%=request.getContextPath() %>"/>
<script>
	$(function(){
		// 로그인 버튼
		$("#btnlogin").click(function(){
			let saveid = $("#saveid").is(":checked"); // val()은 체크여부 상관없이 on이 들어오므로, checked가 true/false인지 봐야함
			let myid = $("#login_myid").val();
			let pass = $("#login_pass").val();
			//alert(saveid + "," + myid);
			
			$.ajax({
				type: "get",
				dataType: "json",
				url: "${root}/login/process",
				data: {"saveid": saveid, "myid": myid, "pass": pass},
				success: function(res){
					// 성공 여부: res.success
					if (res.success){
						$("#btnclose").trigger("click"); // 강제로 닫기 버튼 클릭하기
						location.reload(); // 새로고침
					} else {
						alert("아이디나 비밀번호가 맞지 않습니다");
					}
				}
			});
		});
		
		// 로그아웃 버튼
		$("#btnlogout").click(function(){
			$.ajax({
				type: "get",
				dataType: "text",
				url: "${root}/login/logout",
				success: function(res){
					location.reload(); // 새로고침
				}
			});
		})
		
		// [문제] 아이디 저장 여부에 따라 로그인창 변화
		// 선생님 구현: html에서 c:if로 구현(saveid=='yes'인 경우 & saveid==null || saveid=='no'인 경우)
		if (${sessionScope.saveid == "yes"}){
			$("#saveid").prop("checked", true); // 체크 유지
			$("#login_myid").val("${sessionScope.myid}"); // 저장한 아이디
		}
	});
</script>
</head>

<body>
	<!-- The Modal -->
	<div class="modal" id="myLoginModal">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h6 class="modal-title">회원 로그인</h6>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <table class="table table-bordered">
	        	<caption align="top">
	        		<label>
	        			<input type="checkbox" id="saveid">&nbsp;아이디저장
	        		</label>
	        	</caption>
	        	<tr>
	        		<th width="100">아이디</th>
	        		<td>
	        			<input type="text" id="login_myid" class="form-control">
	        		</td>
	        	</tr>
	        	<tr>
	        		<th width="100">비밀번호</th>
	        		<td>
	        			<input type="password" id="login_pass" class="form-control">
	        		</td>
	        	</tr>
	        </table>
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success"
	        id="btnlogin">로그인</button>
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
	        id="btnclose">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	
	<a href="${root}/" style="font-size: 30px;">
	<img src="${root}/res/photo/sim.gif" width="50" hspace="20">
	Spring5 Mini Project
	<!-- <img src="${root}/res/photo/sim.gif" width="50" hspace="20">
	 -->
	</a>
	
	<div style="width: 200px; position: fixed; right: 50px; top: 30px;">
		<c:if test="${sessionScope.loginok == null}">
			<button type="button" class="btn btn-success"
			style="width: 100px;" data-bs-toggle="modal" data-bs-target="#myLoginModal">로그인</button>
		</c:if>
		
		<c:if test="${sessionScope.loginok != null}">
			<img src="${root}/res/upload/${sessionScope.myphoto}" class="rounded-circle profile_photo"
			width="70" height="70" hspace="10"
			onerror="this.src = '${root}/res/photo/default.gif'"><br>
			<i class="bi bi-gear photochange" style="font-size: 2em; cursor: pointer;"></i>
			<input type="file" id="profile_upload" style="display: none;">
			<div class="input-group">
				<p style="font-size: 15px; color: blue;">${sessionScope.myname}님 ㅎㅇ</p>&nbsp;&nbsp;
				<button type="button" class="btn btn-success"
				style="width: 100px;" id="btnlogout">로그아웃</button>
			</div>
		</c:if>
	</div>
	<script>
		// 그냥 위에 있는거 바로 보면서 하려고 여기 씀..
		
		// 세팅 아이콘 클릭 시 파일 업로드 이벤트 트리거
		$(".photochange").click(function(){
			$("#profile_upload").trigger("click");
		});
		
		// 파일 업로드 이벤트
		$("#profile_upload").change(function(){
			let form = new FormData();
			alert($("#profile_upload")[0].files[0]);
			form.append("upload", $("#profile_upload")[0].files[0]);
			
			$.ajax({
				type: "post",
				dataType: "json",
				url: "${root}/login/photochange",
				processData: false,
				contentType: false,
				data: form,
				success: function(res){
					//$("img.profile_photo").attr("src", `${root}/res/upload/\${res.fileName}`);
					location.reload();
				}
			});
		})
	</script>
</body>
</html>