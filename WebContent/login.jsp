<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
<title>登陆</title>
</head>
<body>
	<div class="pic">
		<img alt="oceans" src="image/login/ocean.png">
	</div>
	
	<div class="login">
			<div class="manager"><a>欢迎博主大人登录！</a></div><hr>
			<form action="<%=request.getContextPath() %>/servlet/LoginServlet" name="loginform" method="post">
				<table border="2">
					<tr>
						<td>用户名</td>
						<td><input type="text" class="username" name="username" placeholder="请输入用户名"/></td>
					</tr>
						<tr>
						<td>密码</td>
						<td><input type="password" class="password" name="password" placeholder="请输入密码"/></td>
					</tr>
						<tr><td colspan="2" align="center"><input class="submit" type="submit" name="submit" value="登录"/></td>
						<tr><td colspan="2" align="center"><input class="return" type="button" name="return" value="返回" onclick="javascript:window.location.href='index.jsp'"/></td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>