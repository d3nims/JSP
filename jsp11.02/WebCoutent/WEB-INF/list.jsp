<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.sbs.board.Article"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sbs.board.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 목록</h1>
	
	<% 
		Member loginedMember = (Member)application.getAttribute("loginedMember");
		if(loginedMember != null) {
	%>
		안녕하세요. <%= loginedMember.getNickname() %> 님! <a href="/TestServlet?action=doLogout">로그아웃</a>
	<% } else { %>
		로그인해주세요.
	<% } %>
	
	<form method="POST"> 
		<%
			List<Article> articles = (List<Article>) request.getAttribute("articles");
			for (int i = 0; i < articles.size(); i++) {
		%>
		<div>
			번호 :
			<%=articles.get(i).getId()%>
			제목 :
			<%=articles.get(i).getTitle()%>
			<input type="checkbox" name="chk" value="<%=articles.get(i).getId()%>" />
		</div>
		<hr>
		<%
			}
		%>
		<input type="submit"/>
	</form>

</body>
</html>
