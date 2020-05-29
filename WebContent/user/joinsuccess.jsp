<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style>
.error {
	color: red;
	font-weight: bold;
	font-style: italic;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="navi">
		
		<%
		
			String position = "join";
		%>
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>로그인 정보</h1>
		</div>
		<div class="body">
			<div>
				<p>회원가입이 완료되었습니다.</p>
				<a href="loginform.jsp">로그인하기</a>
			</div>

		</div>
		<div class="footer">
			<%@ include file="../common/footer.jsp"%>
		</div>
	</div>
</body>
</html>