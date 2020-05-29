<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.util.simpleBoardCheckFunction"%>
<%@page import="com.simple.service.simpleBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pwd");

simpleBoardService service = new simpleBoardService();
int isSuccess = service.userLogin(id, pw);
if(isSuccess != simpleBoardCheckFunction.USER_IS_SUCCESS){
	RequestDispatcher dispatcher = request.getRequestDispatcher("loginform.jsp?error="+isSuccess);
}
session.setAttribute("userId", id);
User user =  service.getUserById(id);
session.setAttribute("userName", user.getName());
session.setAttribute("isLogined", "yes");
response.sendRedirect("/simple_board/home.jsp");

%>