<%@page import="escmembers.data.EscMembersDto"%>
<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String memcode = request.getParameter("memcode");
	String pw = request.getParameter("pw");
	String pw2 = request.getParameter("pwCheck");
	String favorplace = request.getParameter("favorplace");
	
	EscMembersDao dao = new EscMembersDao();
	EscMembersDto dto = new EscMembersDto();
	EscMembersDto prevDto = dao.getMemberDto(memcode);
	
	// 리턴 1: 비번을 입력했지만 확인이 제대로 안된 경우
	if (!pw.equals(pw2)){%>
		<script>
			alert("새 비밀번호 확인이 올바르게 되지 않았습니다");
			history.back();
		</script>
	<%
		return;
	}
	
	if (pw.equals("")){
		pw = prevDto.getPw(); // 새 비번을 입력하지 않았다면, 기존 비번으로 교체
	}
	
	dto.setPw(pw);
	dto.setFavorplace(favorplace);
	dto.setMemcode(memcode);
	
	dao.updateMember(dto);
	
	// 메인페이지로 이동
	response.sendRedirect("../main.jsp");
%>