<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%	request.setCharacterEncoding("utf-8"); %>
<div id="navibar">
	<ul>
		<li class="<%="home".equals(position) ? "active" : ""%>"><a
			href="/simple_board/home.jsp">홈</a></li>
		<li class="<%="board".equals(position) ? "active" : ""%>"><a
			href="/simple_board/board/list.jsp">게시판</a></li>
		<li class="<%="my".equals(position) ? "active" : ""%>"><a
			href="/simple_board/user/my.jsp">내정보</a></li>

<c:set value="yes" var="yes"/>
<c:set value="${sessionScope.isLogined }" var="isLogined" />
<c:set value="${sessionScope.userName }" var="userName"/>
<c:set value="${sessionScope.userId }" var="userId"/>
<c:choose>
	<c:when test="${yes eq isLogined }">
		<li class="right"><a href="/simple_board/user/logout.jsp">로그아웃</a></li>
		<li class="right <%="my".equals(position) ? "active" : "" %>"><a href="/simple_board/user/form.jsp">내정보</a></li>
		<p><c:out value="${userName }"/> 님 환영합니다.</p>
	
	</c:when>
	<c:otherwise>
		<li class="right <%="login".equals(position) ? "active" : "" %>"><a href="/simple_board/user/loginform.jsp">로그인</a></li>
		<li class="right <%="join".equals(position) ? "active" : "" %>"><a href="/simple_board/user/form.jsp">회원가입</a></li>
		
	</c:otherwise>
</c:choose>
		
		



	</ul>

</div>