<%@page import="LoginTask.model.Joiner"%>
<%@page import="LoginTask.messageService.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="joiner" scope="session" class="LoginTask.model.Joiner" />
<jsp:useBean id="message" class="LoginTask.model.Message" />


<%
	request.setCharacterEncoding("utf-8");
 	boolean vaildPwd = (boolean)request.getAttribute("vaildPwd");
%>

<% if(vaildPwd){%>
	<script>
		alert("방명록을 성공적으로 삭제했습니다.");
		location.href = '<c:url value="/message/MessageListForm"/>';
	</script>
	
<%}else{%>
	<script>
		alert("방명록을 삭제를 실패했습니다.");
		location.href = '<c:url value="/message/MessageListForm"/>';
	</script>

<%}%>



