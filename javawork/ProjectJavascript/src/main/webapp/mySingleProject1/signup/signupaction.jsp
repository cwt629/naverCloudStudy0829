<%@page import="escmembers.data.EscMembersDto"%>
<%@page import="escmembers.data.EscMembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	EscMembersDao dao = new EscMembersDao();

	// 받아온 정보들
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pw2 = request.getParameter("pwCheck");
	String favorplace = request.getParameter("favorplace");
	
	// 리턴 1: 비번 확인이 제대로 안된 경우
	if (!pw.equals(pw2)){%>
		<script>
			alert("비밀번호 확인이 올바르게 되지 않았습니다.");
			history.back();
		</script>
	<%
		return;
	}
	
	// 리턴 2: 이미 존재하는 아이디인 경우
	EscMembersDto dto = dao.getMemberValidated(id);
	if (dto.getMemcode() != null){%>
		<script>
			alert("같은 아이디가 이미 존재합니다.");
			history.back();
		</script>
	<%
		return;
	}
	
	// 모두 올바르게 된 경우 회원가입 진행
	EscMembersDto newDto = new EscMembersDto();
	newDto.setId(id);
	newDto.setPw(pw);
	newDto.setFavorplace(favorplace);
	
	dao.insertMember(newDto);
	
	// 메인 페이지로 이동
	response.sendRedirect("../main.jsp");
%>