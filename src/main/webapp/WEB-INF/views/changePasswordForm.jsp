<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="index.jsp" flush="false" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>비밀번호 찾기</title>
    <style>
        body{
            margin: 0px;
            background: #f5f6f7;
        }
        
        #table{
        	margin: 10px auto;
        	padding:10px;
        }
        
        #contain{
        	margin: 0px auto;
        }
        
        #h2{
        	color: #08a600;
        }
        

        input[type=password]{
        	padding: 10px 0; 
        	margin-left: 30px;
        	margin-bottom: 10px;
        	width: 100%;
        }
        
        #table tr td{
        	text-align:center;
        }
        
         input[type=submit]{
            width: 100%;
            height: 55px;
            border: none;
 
            font-size: 20px;
            color: #fff;
            background: rgb(31, 188, 2);
 
            margin-top: 20px;
            margin-bottom: 10px;
            
            cursor:pointer;
        }
        
    </style>

</head>
<body>
<div id="contain">
<form action="<%=request.getContextPath()%>/pwd/changePassword" method="post">
	<table id="table">
		<tr>
			<td colspan="2"><h1 id="h2">비밀번호 변경</h1></td>
		</tr>
		<tr>
			<td>현재 비밀번호</td>
			<td><input type="password" name="prePw"></td>
		</tr>
		<tr>
			<td>변경 비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" name="Checkpwd"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="확인"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>

<jsp:include page="footer.jsp" flush="false" />