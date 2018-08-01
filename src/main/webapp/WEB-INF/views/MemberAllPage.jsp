<%@page import="LoginTask.model.Joiner"%>
<%@page import="LoginTask.model.MemberListView"%>
<%@page import="LoginTask.service.MemberListService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% request.setCharacterEncoding("UTF-8"); %>
<% MemberListView viewMem = (MemberListView)request.getAttribute("memberListView");
   String id = (String)request.getSession(true).getAttribute("id");
%>

<jsp:include page="index.jsp" flush="false" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/MemberAllPage.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemberList Page</title>
<style>
</style>
</head>
<body>

	<div id="containAll">

		<div id="container">
			<h1>모든 회원정보 보기</h1>

			<%
				if (viewMem.isEmpty()) {
			%>

			<h3>등록된 회원정보가 없습니다.</h3>
			<a href="<c:url value="/indexHome"/>">[홈으로 가기]</a>

			<%
				} else {
			%>

			<table>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>이메일</th>
					<th>핸드폰 번호</th>
				</tr>

				<%
					for (Joiner joiner : viewMem.getMemberList()) {
				%>
				<tr>
					<td><%=joiner.getId()%></td>
					<td><%=joiner.getPwd()%></td>
					<td><%=joiner.getName()%></td>
					<td><%=joiner.getBirth_year()%>/<%=joiner.getBirth_mon()%>/<%=joiner.getBirth_day()%></td>
					<td><%=joiner.getGender()%></td>
					<td><%=joiner.getEmail()%></td>
					<td><%=joiner.getPhone()%></td>
					<%if(id.equals("admin0")){ %>
					<td><input type="button" id="deleteBtn" onclick="location.href='<%=request.getContextPath()%>/MemberDelete/<%=joiner.getId()%>'"  value="삭제하기"></td>
					<%} %>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="7">
				<%
					for (int i = 1; i <= viewMem.getPageTotalCount(); i++) {
				%>
					<a href="<%=request.getContextPath()%>/MemberAllPage/<%=i%>">[<%=i%>]</a>
				<%
					}
				}
				%>
					</td>
				</tr>

				<tr>
					<td colspan="7"><input type="button" id="homeBtn" value="홈으로 가기"
						onclick="location.href='<%=request.getContextPath()%>/indexHome'" /></td>
				</tr>

			</table>
		</div>
	</div>

</body>
</html>



<jsp:include page="footer.jsp" flush="false" />