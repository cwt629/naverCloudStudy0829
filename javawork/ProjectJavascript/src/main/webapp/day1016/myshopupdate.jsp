<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 인코딩
	request.setCharacterEncoding("utf-8");

	// dao, dto 선언
	MyShopDao dao = new MyShopDao();
	MyShopDto dto = new MyShopDto();
	
	// 각 parameter 받아오기
	int num = Integer.parseInt(request.getParameter("num"));
	String sangpum = request.getParameter("sangpum");
	String photo = request.getParameter("photo");
	String color = request.getParameter("color");
	int price = Integer.parseInt(request.getParameter("price"));
	
	// dto에 담기
	dto.setNum(num);
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setPhoto(photo);
	dto.setPrice(price);
	
	// updateShop 메소드 호출
	dao.updateShop(dto);
	
	// myshopdetail.jsp로 이동(?로 num 넘길 것)
	response.sendRedirect("myshopdetail.jsp?num=" + num);
%>