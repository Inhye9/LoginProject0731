<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="LoginTask.model.Joiner"%>
<%@page import="java.util.List"%>
<%@page import="LoginTask.service.MemberListService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>﻿[
<% 
	
	int resultCnt = 0;
	/* List<Joiner> viewMem = (List<Joiner>)request.getAttribute("viewMem"); */
%>

<%-- 	<%
		String birth = joiner.getBirth_year() +"/"+ joiner.getBirth_mon() +"/"+ joiner.getBirth_day(); 
	%> --%>
	
	<c:forEach var="viewMem" items="${viewMem}" varStatus="status">
	
	{
		"id" : "${viewMem.id}",
		"pwd" : "${viewMem.pwd}",
		"name" : "${viewMem.name}",
		"birth" : "${viewMem.birth_year}",
		"gender" : "${viewMem.gender}",
		"email" : "${viewMem.email}",
		"phone" : ${viewMem.phone},
		"photo" : "${viewMem.photo}"
	}
	
	</c:forEach>
	<%-- <c:forEach var="str" items="${array}-1">,</c:forEach> --%>

	<%-- <% resultCnt++;
		if(resultCnt!=viewMem.size()){%>,<%} %> --%>
	
]

<%-- "<%=joiner.getBirth_year()%>/<%=joiner.getBirth_mon()%>/<%=joiner.getBirth_day()%>" --%>