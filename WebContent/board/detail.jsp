<%@page import="com.simple.vo.Reply"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.service.simpleBoardService"%>
<%@page import="com.simple.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style>
.bold-bordered {
	border-bottom: 1px double black;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="navi"><%
		
		String position = "board";
		
		%>
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>게시글 상세정보</h1>
		</div>
		<div class="body">
			<p>게시글의 내용을 확인하고, 댓글도 달아보세요.</p>
			<div>
				<table class="table bordered">
					<colgroup>
						<col width="10%">
						<col width="40%">
						<col width="10%">
						<col width="40%">
					</colgroup>
					<tbody>
						<%
							int boardNo = StringUtil.stringToInt(request.getParameter("no"));
							simpleBoardService service = new simpleBoardService();
							
							
							Board board = service.getBoardByNo(boardNo);
							List<Reply> replys = service.getAllReplyByBoardNo(boardNo);
				
						%>
						<c:set value="<%=board%>" var="board" />

						<tr>
							<th>제목</th>
							<td colspan="3">${board.title }.</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><a href="writers.jsp?userid=hong">${board.writer }</a></td>
							<th>등록일</th>
							<td>${board.boardCreateDate }</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td>${board.hit }</td>
							<th>댓글갯수</th>
							<td>${board.replyCnt }</td>
						</tr>
						<tr>
							<th style="vertical-align: top;">내용</th>
							<td colspan="3"
								style="vertical-align: top; height: 150px; min-height: 150px;">${board.content }</td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="text-right">
			<c:if test="${userId eq board.writer }">
				[<a href="modifyform.jsp?no=${board.no }">수정하기</a>] 
				
				
				[<a	href="delete.jsp?no=${board.no }">삭제하기</a>] 
			</c:if>
					
				[<a href="list.jsp">목록가기</a>]
			</div>

			<div>
				<p>댓글을 확인하세요.</p>
				<table class="table">
					<colgroup>
						<col width="10%">
						<col width="40%">
						<col width="10%">
						<col width="40%">
					</colgroup>
					<tbody>
						<c:forEach items="<%=replys%>" var="reply">
							<tr>
								<th>작성자</th>
								<td>${reply.writer }</td>
								<th>등록일</th>
								<td>${reply.replyCreateDate }</td>
							</tr>
							<tr class="bold-bordered">
								<th>내용</th>
								<td colspan="3">${reply.content }</td>
							</tr>
						</c:forEach>
							<tr>
							<c:if test="${userId == reply.writer }">
								<td><a href="../reply/delete.jsp?no=${reply.no }">삭제</a></td>
								<td><a href="../reply/modify.jsp?no=${reply.no }">수정</a></td>
							</c:if>
							</tr>
					</tbody>
				</table>
				<br />
				<div class="well">
					<form method="post" action="../reply/register.jsp">
						<input type="hidden" name="boardNo" value="${board.no }" />
						<div class="form-group">
							<textarea rows="3" name="content"></textarea>
						</div>
						<div class="text-right">
							<button type="submit">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="footer">
			<%@ include file="../common/footer.jsp"%>
		</div>
	</div>
</body>
</html>