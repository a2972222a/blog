<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();//字符串以/开头
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+
			request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>博主管理界面</title>
	<base <%= basePath %>/>
	<link rel="stylesheet" type="text/css" href="css/manager.css"/>
</head>
<body class="blog-home">

<div class="header">
	<div class="navbar">
		<h1 class="logo">
			<a href="index.jsp" title="QinsCraft博客" alt="QinsCraft博客">QinsCraft<span>博客</span></a>
		</h1>
		<ul class="nav">
			<li class="blog-index">
				<a href="index.jsp">首页</a>
			</li>
			<li class="blog-frontEnd">
				<a href="building.jsp">前端</a>
				<ul class="secmenu">
					<li class="css">
						<a href="building.jsp">css</a>
					</li>
				</ul>
			</li>
			<li class="blog-backEnd">
				<a href="building.jsp">后端</a>
				<ul class="secmenu">
					<li class="mysql">
						<a href="building.jsp">mysql</a>
					</li>
					<li class="java">
						<a href="building.jsp">java</a>
					</li>
				</ul>
			</li>
			<li class="blog-picture">
				<a href="building.jsp">图库</a>
				<ul class="secmenu">
					<li class="nature">
						<a href="building.jsp">自然</a>
					</li>
					<li class="architecture">
						<a href="building.jsp">建筑</a>
					</li>
					<li class="acg">
						<a href="building.jsp">ACG</a>
					</li>
				</ul>
			</li>
			<li class="blog-about">
				<a href="building.jsp">关于</a>
				<ul class="secmenu">
					<li class="master">
						<a href="building.jsp">博主</a>
					</li>
					<li class="message">
						<a href="building.jsp">留言</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
	
	<div class="searchbar">
		<form action="building.jsp" method="get">
			<input name="search" type="text" placeholder="请输入关键词" size="20"/>		
			<input name="submit" type="submit" value="搜索"/>		
		</form>
	</div>
	
	<div class="logoff">
		<form action="" name="" method="post">
			<input class="logoff_submit" type="submit" value="注销"/>
		</form>
	</div>
	
	<div class="feedback">
		<span class="fbmessage"><c:out value="${success }"/></span>
	</div>
	
	<div class="article">
		<form action="<%=path %>/servlet/ArticleServlet" name="userForm" method="post">
			<table border="2">
				<tr>
					<td>题目</td>
					<td><input type="text" class="title" name="title" placeholder="请输入题目"/></td>
				</tr>
				<tr>
					<td>标签</td>
					<td><input type="text" class="tag" name="tag" placeholder="请输入标签"/></td>
				</tr>
				<tr>
					<td>内容</td>
					<td><input type="text" class="content" name="content" placeholder="请输入内容"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center" width="100px"><input class="submit" type="submit" name="submit" value="添加"/></td>
				</tr>
			</table>
		</form>
		
	</div>
	
	</div>
</body>
</html>