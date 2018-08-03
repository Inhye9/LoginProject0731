<%@page import="LoginTask.model.Joiner"%>
<%@page import="LoginTask.service.selectMypageService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%-- <jsp:useBean id="joiner" scope="session" class="LoginTask.model.Joiner" /> --%>

<jsp:include page="index.jsp" flush="false" />

<% request.setCharacterEncoding("UTF-8"); %>
<% Joiner joiner = (Joiner)request.getAttribute("joiner"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/MyPageForm.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<style>
</style>
</head>
<body>
	<div id="containAll">
		<%if(joiner!=null){%>
		<div id="container">
			<h1>My Page</h1>
		 	<%if(joiner.getPhoto()!=null){ %>	
			<img src='<%=request.getContextPath()%>/file/photo/${joiner.photo}' style="width:200px;">
		  	<%}%>
			<p>
			<table>
				<tr>
					<td>아이디</td>
					<td>${joiner.id}</td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td>${joiner.pwd}</td>
				</tr>

				<tr>
					<td>이름</td>
					<td>${joiner.name}</td>
				</tr>

				<tr>
					<td>생년월일</td>
					<td>${joiner.birth}</td>
				</tr>

				<tr>
					<td>성별</td>
					<td>${joiner.gender}</td>
				</tr>

				<tr>
					<td>이메일</td>
					<td>${joiner.email}</td>
				</tr>

				<tr>
					<td>핸드폰 번호</td>
					<td>${joiner.phone}</td>
				</tr>

				<tr>
					<td colspan="2"><input type="button" value="비밀번호 변경하기"
						onclick="location.href='<c:url value="/pwd/changePassword"/>'" /></td>
					<td colspan="2"><input type="button" value="홈으로 가기"
						onclick="location.href='indexHome'" /></td>
				</tr> 
			</table>
		</div>
	</div>
</body>
</html>
<%}else{ %>
<script>
alert('로그인 해주세요.');
location.href='loginForm';
</script>
<%}%>


<jsp:include page="footer.jsp" flush="false" />