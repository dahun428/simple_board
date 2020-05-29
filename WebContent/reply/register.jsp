<%@page import="com.simple.service.simpleBoardService"%>
<%@page import="com.simple.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

int boardNo = StringUtil.stringToInt(request.getParameter("boardNo"));
String content = request.getParameter("content");
String writer = (String) session.getAttribute("userId");

simpleBoardService service = new simpleBoardService();
service.addNewReply(writer, content, boardNo);

response.sendRedirect("../board/detail.jsp?no="+boardNo);

%>