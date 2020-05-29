<%@page import="com.simple.util.StringUtil"%>
<%@page import="com.simple.service.simpleBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int no = StringUtil.stringToInt(request.getParameter("no"));
String title = request.getParameter("title");
String content = request.getParameter("content");

simpleBoardService service = new simpleBoardService();
service.updateBoard(title, content, no);

response.sendRedirect("detail.jsp?no="+no);

%>