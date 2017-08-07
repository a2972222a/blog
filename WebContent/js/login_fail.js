window.onload=function(){
	//声明变量
	var i=2;//由于一进入页面就会执行一次，所以i初始化要比页面最初显示小一次！！！
	var intervalid;
	//每隔一秒执行一次timeCheck()函数，直到i变为0跳转
	intervalid = setInterval(timeCheck,1000);//这里之前写的timeCheck()不对，要么加上引号，要么像这样直接写函数名！
	function timeCheck(){
		if(i==0){
			window.location.href="login.jsp";
			clearInterval(intervalid);
		}
		//i--;放在这里会使浏览器出现-1
		document.getElementById("num").innerHTML=i;
		i--;
	}
}