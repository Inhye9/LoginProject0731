<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%  request.setCharacterEncoding("UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:useBean id="joiner" scope="session" class="LoginTask.model.Joiner"/> --%>
<%
	String id = (String)request.getSession(true).getAttribute("id");
	String pwd = (String)request.getSession(true).getAttribute("pwd");
%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>홈</title>
    <style>
        body{
            margin: 0px;
        }
        
        #topnav{
            background: #08a600;
            width:100%;
            height: 51px;
        }
        
        #topnav a{
            float: left;
            background: #08a600;
            color: #fff;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
            
            cursor:pointer;
        }
        
        #topnav a:hover{
            opacity: 0.8;
        }
        
        #topnav a:active{
            background: white;
            color: #08a600;
        }
 
    </style>
</head>
<!--  <c:url value="/indexHome"/> -->
<body>
    <div id="topnav">
        <a href="<c:url value="/indexHome"/>">홈</a>
        <a href="<c:url value="/MyPageForm"/>">MyPage</a>
        <a href="<c:url value="/MemberAllPage"/>">MemberList</a>
        <a href="<c:url value="/message/MessageListForm"/>">방명록</a>
      <% if(id!=null && pwd!=null){ %>
        <a href="<c:url value="/logoutAct"/>">로그아웃</a>
      <%}else{%>
        <a href="<c:url value="/regi/RegisterFirst"/>">회원가입</a>
        <a href="<c:url value="/login/loginForm"/>">로그인</a>
     <%}%>
     
     
    </div>
</body>
</html>
 