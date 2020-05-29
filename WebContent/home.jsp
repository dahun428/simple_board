<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources\css\style.css" />
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "home";
			%>
			<%@include file="common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>심플한 커뮤니티 게시판</h1>
		</div>
		<div class="body">
			<p>간단한 회원가입 후 다른 사람과 의견을 교환하세요</p>
		</div>
		<div class="footer">
			<%@ include file="common/footer.jsp"%>
		</div>

	</div>

</body>
</html>