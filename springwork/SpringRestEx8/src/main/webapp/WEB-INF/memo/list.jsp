<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List - 간단한 메모</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<style>
   body * {
       font-family: 'Jua';
   }
  
   .memoform {
       position: absolute;
       top: 150px;
       left: 50px;
   }
   
   .memolist {
       position: absolute;
       top: 150px;
       left: 400px;
   }
   
   .photo, .photo2 {
       width: 120px;
       height: 120px;
       border: 1px solid gray;
       border-radius: 30px;
       box-shadow: 5px 5px 5px gray;
   }
   
   .cameraupload {
       font-size: 30px;
       cursor: pointer;
   }
   
   div.box {
       width: 500px;
       height: 160px;
       padding: 10px;
       border: 2px solid gray;
       box-shadow: 3px 3px 3px gray;
       margin-bottom: 10px;
       border-radius: 20px;
   }
   
</style>
<script>
	$(function(){
		list(); // 처음 로딩 시 기존 메모들 출력
		
		$(".cameraupload").click(function(){
			$("#upload").trigger("click");
		});
		
		// 파일 선택 시 이벤트
		$("#upload").change(function(){
			let form = new FormData();
			form.append("upload", $("#upload")[0].files[0]); // 선택한 1개의 파일만 추가
			
			/*
			(파일 전송일 경우에 설정할 것)
			
			processData: false
			=> 서버에 전달하는 데이터는 query string이라는 형태로 전달된다.
			파일 전송의 경우는 이를 하지 않아야 한다.
			그래서 설정을 false로 한다.
			
			contentType: false
			=> enctype은 원래 기본값이 application/x-www.... 인데,
			이를 multipart/form-data로 변경해준다.
			*/
			
			$.ajax({
				type: "post",
				dataType: "text",
				url: "./upload",
				processData: false,
				contentType: false,
				data: form,
				success: function(res){
					//alert(res); // 랜덤 파일명 확인 후 이미지 출력
					$(".photo").attr("src", `../res/upload/\${res}`);
				}
			});
		});
		
		$("#btnmemoadd").click(function(){
			let nick = $("#nickname").val();
			let memo = $("#memo").val();
			
			if (nick.length == 0){
				alert("닉네임을 입력해야 합니다.");
				return;
			}
			
			if (memo.length == 0){
				alert("메모 내용을 입력해야 합니다.");
				return;
			}
			
			$.ajax({
				type: "get",
				dataType: "text",
				url: "./add",
				data: {"nickname": nick, "memo": memo},
				success: function(res){
					// 다시 메모 전체 출력
					list();
					// 입력값들 지우기
					$("#nickname").val("");
					$("#memo").val("");
					$(".photo").attr("src", "../res/upload/default.gif")
				}
			});
		});
		
		// 메모 삭제
		$(document).on("click", ".memodel", function(){
			let num = $(this).attr("num");
			let a = confirm("이 메모를 삭제하시겠습니까?");
			if (a){
				$.ajax({
					type: "get",
					dataType: "text",
					url: "./delete",
					data: {"num": num},
					success: function(res){
						// 삭제 후 목록 재출력
						list();
					}
				});
			}	
		});
		
		// 좋아요 수 증가시키기
		$(document).on("click", ".increlikes", function(){
			let num = $(this).attr("num");
			let $prev = $(this).prev();
			$.ajax({
				type: "get",
				dateType: "json",
				url: "./likes",
				data: {"num": num},
				success: function(res){
					$prev.text(res.likes);
				}
			});
		});
		
	}); // function close
	
	function list()
	{
		// 전체 메모 출력해주는 함수
		$.ajax({
			type: "get",
			dataType: "json",
			url: "./view",
			success: function(res){
				let s = "";
				$.each(res, function(idx, item){
					// Self: 이미지 소스가 없는 경우 대비
					let imageSource = (item.photo != null)? item.photo : "default.gif";
					s += 
						`
						<div class="box">
							<img src="../res/upload/\${imageSource}" class="photo2" align="left"
							hspace="20">
							
							닉네임 : \${item.nickname}<br>
							메 &nbsp;모 : \${item.memo}<br>
							작성일 : \${item.writeday}<br>
							추천수 : <span>\${item.likes}</span><i class="bi bi-suit-heart increlikes" style="cursor: pointer; color: red; margin-left: 5px;"
							num="\${item.num}"></i><br>
							<a href="#" class="memodel" num="\${item.num}" style="cursor: pointer; color: red;">삭제</a>

						</div>
						`;
				});
				
				$(".memolist").html(s);
			}
		});
	}
</script>
</head>
<body>
	<!-- 
		<i class="bi bi-suit-heart-fill"></i>
	 -->
	<h3 class="alert alert-success">간단한 메모를 남겨봅시다</h3>
	<div class="memoform">
		<i class="bi bi-camera-fill cameraupload"></i>
		<input type="file" name="upload" id="upload" style="display: none;">
		<br>
		<img src="../res/upload/default.gif" class="photo">
		<br><br>
		<input type="text" id="nickname" class="form-control" style="width: 200px;"
		placeholder="닉네임 입력">
		<input type="text" id="memo" class="form-control" style="width: 300px;"
		placeholder="메모 메세지">
		<button type="button" class="btn btn-sm btn-outline-danger"
		id="btnmemoadd">Add Memo</button>
	</div>
	
	<div class="memolist">
		
	</div>
</body>
</html>