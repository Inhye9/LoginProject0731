<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/pwd/changePassword" method="post">
	<table>
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
			<td><input type="text" name="Checkpwd"></td>
		</tr>
		<tr>
			<td><input type="submit" value="확인"></td>
		</tr>
	</table>
</form>
</body>
</html>