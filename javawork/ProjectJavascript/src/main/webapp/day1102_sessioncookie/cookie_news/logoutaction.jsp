<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전체 쿠키 중 loginok 쿠키를 찾아 삭제 후 메인으로 이동
	Cookie []cookies = request.getCookies();
	if (cookies != null)
	{
		for (Cookie ck: cookies)
		{
			if (ck.getName().equals("loginok")){
				// ck의 유지시간과 path 다시 지정
				ck.setMaxAge(0); // 유효 시간을 0으로 만들어서 삭제
				ck.setPath("/");
				// 브라우저에 다시 저장 -> 유효 시간 0이므로 삭제됨
				response.addCookie(ck);
				break;
			}
		}
	}
	response.sendRedirect("loginmain.jsp");
%>