<%@page import="com.simple.service.simpleBoardService"%>
<%@page import="com.simple.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String userId = (String) session.getAttribute("userId");
	simpleBoardService service = new simpleBoardService();
	service.addBoard(title, userId, content);
	response.sendRedirect("list.jsp");
	
%>