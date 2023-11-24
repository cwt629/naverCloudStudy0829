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
		<div>
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
	</div>
</body>
</html>