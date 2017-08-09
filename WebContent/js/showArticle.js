function show_front(){
	var front = document.getElementById("frontEnd").innerHTML;
	window.location.href="servlet/ShowArticleServlet?front="+front;
}

function show_css(){
	var front = document.getElementById("css").innerHTML;
	window.location.href="servlet/ShowArticleServlet?css="+css;
}

function show_back(){
	var front = document.getElementById("back").innerHTML;
	window.location.href="servlet/ShowArticleServlet?back="+back;
}

function show_mysql(){
	var front = document.getElementById("mysql").innerHTML;
	window.location.href="servlet/ShowArticleServlet?mysql="+mysql;
}

function show_java(){
	var front = document.getElementById("java").innerHTML;
	window.location.href="servlet/ShowArticleServlet?java="+java;
}
