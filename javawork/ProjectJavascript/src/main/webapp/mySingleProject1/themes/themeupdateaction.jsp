<%@page import="escthemes.data.EscThemesDto"%>
<%@page import="escthemes.data.EscThemesDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MultipartRequest multipartRequest = null;

String realPath = getServletContext().getRealPath("/save");
int uploadSize = 1024 * 1024 * 100; // 100MB

try {
	multipartRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8",
			new DefaultFileRenamePolicy());
	// dao, dto 선언
	EscThemesDao dao = new EscThemesDao();
	EscThemesDto dto = new EscThemesDto();
	
	// 데이터 읽기(파일 포함)
	String roomcode = multipartRequest.getParameter("roomcode");
	String memcode = multipartRequest.getParameter("memcode");
	String themename = multipartRequest.getParameter("themename");
	String genre = multipartRequest.getParameter("genre");
	String cafename = multipartRequest.getParameter("cafename");
	String region = multipartRequest.getParameter("region");
	String explanation = multipartRequest.getParameter("explanation");
	
	// 업로드된 실제 파일명. 업로드 안했을 경우는 null
	String image = multipartRequest.getFilesystemName("image"); // 업로드된 실제 파일명! getParameter로 받으면 null값 나온다.
	
	// dto에 넣기
	dto.setRoomcode(roomcode);
	dto.setMemcode(memcode);
	dto.setThemename(themename);
	dto.setGenre(genre);
	dto.setCafename(cafename);
	dto.setRegion(region);
	dto.setExplanation(explanation);
	dto.setImage(image);
	
	// update 메소드 호출
	dao.updateTheme(dto);
	
	// 해당 방탈출 테마 리뷰 페이지로 이동
	response.sendRedirect("../reviews/reviewpage.jsp?roomcode=" + roomcode);
			
} catch (Exception e){
	out.print("<h3>파일 업로드 오류 발생: " + e.getMessage() + "</h3>");
}
%>