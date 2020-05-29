<%@page import="sun.rmi.server.Dispatcher"%>
<%@page import="com.simple.util.simpleBoardCheckFunction"%>
<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.service.simpleBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	String password = request.getParameter("pwd");

	simpleBoardService service = new simpleBoardService();
	User user = new User();
	user.setName(name);
	user.setEmail(email);
	user.setId(id);
	user.setPassword(password);
	int isSuccess = service.userSignUp(user);
	if (isSuccess != simpleBoardCheckFunction.USER_IS_SUCCESS) {
		response.sendRedirect("form.jsp?error=fail");

	} else {
		response.sendRedirect("joinsuccess.jsp");
	}
%>