<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// pass를 읽는다
	String pass = request.getParameter("pass");
	// pass가 1234일 경우, loginok라는 쿠키 생성 후 브라우저에 추가
	if (pass.equals("1234")) {
		Cookie cookie = new Cookie("loginok", "yes");
		// 유지 시간 설정
		cookie.setMaxAge(60 * 60); // 1시간(60 * 60 * 1sec)
		// path: 저장되는 위치 지정
		cookie.setPath("/");
		// 브라우저에 쿠키 저장
		response.addCookie(cookie);
		
		// 메인 페이지로 이동
		response.sendRedirect("loginmain.jsp");
	} else {%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			history.back();
		</script>
	<%}
	
%>