<%@page import="com.simple.util.StringUtil"%>
<%@page import="com.simple.service.simpleBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	simpleBoardService service = new simpleBoardService();
	int boardNo =StringUtil.stringToInt(request.getParameter("no"));
	service.upHit(boardNo);
	response.sendRedirect("detail.jsp?no="+boardNo);
%>