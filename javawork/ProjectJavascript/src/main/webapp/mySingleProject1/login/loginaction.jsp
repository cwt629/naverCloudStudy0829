<%@page import="escmembers.data.EscMembersDao"%>
<%@page import="escmembers.data.EscMembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EscMembersDao dao = new EscMembersDao();

	// id와 pw 읽기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 해당 멤버 dto 받아오기
	EscMembersDto dto = dao.getMemberValidated(id, pw);
	
	// 해당 멤버가 존재하지 않는 경우
	if (dto.getMemcode() == null) {%>
		<script>
			alert("해당 회원정보가 존재하지 않습니다.");
			history.back();
		</script>
	<%} else {
		Cookie cookie = new Cookie("loggedinCode", dto.getMemcode());
		cookie.setMaxAge(60 * 60); // 1시간
		cookie.setPath("/");
		response.addCookie(cookie);
		
		// 메인 페이지로 다시 이동한다
		response.sendRedirect("../main.jsp");
	}
%>