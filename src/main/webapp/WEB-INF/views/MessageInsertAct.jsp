<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="LoginTask.messageService.InsertMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8");%>
<%-- 
<jsp:useBean id="message" class="LoginTask.model.Message"/>
<jsp:setProperty property="*" name="message"/> --%>

<%
	int resultCnt = (int)request.getAttribute("resultCntTmp");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<style>
</style>
</head>
<body>
</body>
</html>

<script>
<%if(resultCnt>0){ %>
	alert("방명록 메세지 등록이 완료되었습니다.");
	location.href = '<c:url value="/message/MessageListForm"/>';
<%}else{%>
	alert("방명록 메세지 등록이 실패하였습니다.");
	location.href = '<c:url value="/message/MessageInsertForm"/>';
<%}%>
</script>
