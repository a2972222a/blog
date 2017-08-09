<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+
						request.getServerPort()+path+"/";
	String showArticle = path+"/servlet/ShowArticleServlet";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>QinsCraft博客</title>
	<base <%= basePath %>/><!-- 必须放在head中！ -->
	<link rel="stylesheet" type="text/css" href="css/header.css"/>
	<link rel="stylesheet" type="text/css" href="css/toggle.css"/>
	<link rel="stylesheet" type="text/css" href="css/homebody.css"/>
	<script language="javascript" src="js/toggle.js"></script>
	<script language="javascript" src="js/showArticle.js"></script>
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
				<a id="frontEnd" onclick="show_front()">前端</a>
				<ul class="secmenu">
					<li class="css">
						<a id="css" onclick="show_css()">css</a>
					</li>
				</ul>
			</li>
			<li class="blog-backEnd">
				<a id="back" onclick="show_back()">后端</a>
				<ul class="secmenu">
					<li class="mysql">
						<a id="mysql" onclick="show_mysql()">mysql</a>
					</li>
					<li class="java">
						<a id="java" onclick="show_java()">java</a>
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
	
	<div class="searchbar">
		<form action="building.jsp" method="post">
			<input name="search" type="text" placeholder="请输入关键词" size="20"/>		
			<input class="submit" name="submit" type="submit" value="搜索"/>		
		</form>
	</div>
	
	<div class="login">
		<input class="login_button" type="button" value="登陆" onclick="javascript:window.location.href='<%=path %>/login.jsp'"/>
	</div>
</div>

<div class="toggle" id="toggle">
	<ul id="pic">
		<li><img alt="saber" src="image/toggle/saber.jpeg" width="100%" height="450px"></li>
		<li><img alt="akl" src="image/toggle/akl.jpg" width="100%" height="450px"></li>
		<li><img alt="pillar" src="image/toggle/pillar.jpg" width="100%" height="450px"></li>
	</ul>
	<ol id="list">
		<li class="on">1</li>
		<li>2</li>
		<li>3</li>
	</ol>
</div>

<div class="homebody">
	<div class="homebody-left">
		<div class="time-articles">
			<div class="recent">最近博客</div>
			
			<div class="time-article">
				<a href="building.jsp">我是最近一篇博客！</a>
			</div>
			
		</div>
	</div>

	<div class="homebody-right">	
		<div class="timeprint" align="center">
			<%
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd号");
				String s=sdf.format(new Date());
			%>
			今天是<%=s %><hr>
		</div>
		
		<div class="ads">
			广告位
		</div><hr>
		<div class="ads-text" style="text-align:center">
			这里是广告位
		</div>
		
		
	</div>
</div>

</body>

</html>