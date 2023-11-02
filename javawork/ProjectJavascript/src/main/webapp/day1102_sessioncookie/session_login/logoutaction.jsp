<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// loginok 세션 제거
	// [참고] session.invalidate() : 이건 다 지워버리므로 권장하지 않는다.
	session.removeAttribute("loginok");

	// 메인페이지로 이동
	response.sendRedirect("loginmain.jsp");
%>