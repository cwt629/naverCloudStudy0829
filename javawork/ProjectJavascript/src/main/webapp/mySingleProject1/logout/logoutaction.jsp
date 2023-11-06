<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie []cookies = request.getCookies();

	// 쿠키를 다시 지운다
	if (cookies != null)
	{
		for (Cookie ck: cookies)
		{
			if (ck.getName().equals("loggedinCode")){
				ck.setMaxAge(0);
				ck.setPath("/");
				response.addCookie(ck);
				break;
			}
		}
	}
	
	response.sendRedirect("../main.jsp");
%>