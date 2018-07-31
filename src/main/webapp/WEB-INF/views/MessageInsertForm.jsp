<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="joiner" scope="session" class="LoginTask.model.Joiner" />
<jsp:setProperty name="joiner" property="*" />

<jsp:include page="index.jsp" flush="false" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/MessageInsertForm.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 쓰기</title>
<style>
</style>
</head>
<body>

<h1 id="header">방명록 글쓰기</h1>
	<div id="containAll">

<%if(joiner.getId()!=null){ %>

	    <form action="<c:url value="/message/MessageInsertAct"/>" method="post">
		ID : ${joiner.id} <br>
		<input type="hidden" name="id" value="${joiner.id}" />
		<input type="hidden" name="password" value="${joiner.pwd}" />
		
		메시지 :<br><br>
		 <textarea name="message" cols="30" row="3"></textarea><br>
		<input type="submit" id="submitBtn" value="입력" />

	</form>
    </div>
</body>
</html>

<%}else{%>
	<script>
		alert('로그인 해주세요.');
		location.href = '<c:url value="/login/loginForm"/>';
	</script>
<%}%>

<jsp:include page="footer.jsp" flush="false" />