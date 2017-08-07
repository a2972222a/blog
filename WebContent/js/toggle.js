window.onload=function(){
	//获取标签元素及定义变量
	var toggle=document.getElementById("toggle");
	var pic=document.getElementById("pic").getElementsByTagName("li");
	var list=document.getElementById("list").getElementsByTagName("li");
	var index=0;
	var timer=null;
	//定义并调用自动播放函数
	timer=setInterval(autoPlay,5000);
	//鼠标划过toggle容器停止自动播放
	toggle.onmouseover=function(){
		clearInterval(timer);
	}
	//鼠标离开rolling容器继续下一张
	toggle.onmouseout=function(){
		timer=setInterval(autoPlay,5000);
	}
	//遍历所有数字导航，实现划过切换至对应的图片
	for(var i=0;i<list.length;i++){
		list[i].onmouseover=function(){
			clearInterval(timer);
			index=this.innerText-1;
			changePic(index);
		}
	}
	//自动播放函数
	function autoPlay(){
		index++;
		if(index>=pic.length)
			index=0;
		changePic(index);
	}
	//图片切换函数
	function changePic(curIndex){
		for(var i=0;i<pic.length;++i){
			pic[i].style.display="none";
			//这里必须把已经改为on的class名字重置为空，保证轮播时同时只有一个数字有背景色
			list[i].className="";
		}
		pic[curIndex].style.display="block";
		//使鼠标所指数字的class变为on，从而添加背景色
		//数字1必须设置为on，否则刚打开页面时1没有背景色！
		list[curIndex].className="on";
	}
}