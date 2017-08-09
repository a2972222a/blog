package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 秦晓阳
 * 过滤器
 * 可以xml配置，也可以注解配置！！！
 */
public class LoginFilter implements javax.servlet.Filter {
	
	private FilterConfig filterConfig;
	
	/**
	 * init()是过滤器的初始化方法。
	 * Web容器创建过滤器实例后（服务器启动时？）将调用这个方法。
	 * 这个方法可以读取web.xml文件中的过滤器参数。
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter过滤器初始化！");
		//给自定义的filterConfig赋予配置好的初始化参数，便于执行过滤时循环遍历
		this.filterConfig = filterConfig;
	}
	
	/**
	 * doFilter()完成实际的过滤操作，是过滤器的核心方法。
	 * 当用户请求访问与过滤器关联的URL时，Web容器将先调用过滤器的doFilter()方法。
	 * FilterChain参数可以调用chain.doFilter()方法，将请求传给下一个过滤器或目标资源，
	 * 或者利用转发、重定向将请求转发到其他资源。
	 * 
	 * 过滤器链：
	 * 1、有多个过滤器时，如果他们的url-pattern不同，则不构成过滤器链，
	 * 且doFilter()执行顺序按照xml中的先后配置来，；
	 * 2、若相同，此时他们的生命周期为：
	 * init1,init2,...,startFilter1,startFilter2,...jsp...,endFilter2,endFilter1,...,destroy1,destroy2,...
	 * 
	 * 一个filter可以有多个mapping，如果用重定向会导致死跳转！
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("LoginFilter过滤开始······");
		
		/**
		 * 由于我非要用foreach出现了好多问题。。还是for循环吧
		 */
		//必须先强制转换arg0，才能调用session等
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		//必须执行过滤放行！！！否则页面空白
//		arg2.doFilter(arg0, arg1);
//		System.out.println(request.getRequestURI());//获取请求的URI（尽量不用URL）
		
		/**
		 * 由于LoginFilter用的url-pattern是 /*，
		 * 所以判断session是否合法必须加上这个判断，
		 * 才能避免login.jsp页面的死循环（一直加载login.jsp）。
		 * 但由于需要判断很多jsp或servlet页面，这里就用到了init()中的filterConfig引入web.xml里配置好的可以执行过滤的页面
		 * 这样以后只需在web.xml中配置即可，无需修改filter代码！！！
		 */
		String noLoginPaths = filterConfig.getInitParameter("noLoginPaths");
		//这里需要先对noLoginPaths是否为空做判断
		if(noLoginPaths!=null){
			String[] pages = noLoginPaths.split(";");//regex=regular expression，正则表达式。
			
			for(int i=0;i<pages.length;i++){
				if(pages[i]==null||"".equals(pages[i])){
					continue;
				}
				if(request.getRequestURI().indexOf(pages[i])!=-1){
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
			
//			for (String string : pages) {
//				//如果请求中存在配置的页面，则执行过滤放行
//				if(request.getRequestURI().indexOf(string)!=-1){
//					arg2.doFilter(arg0, arg1);
//					return;//结束过滤
//				}else{
//					//如果请求中不存在配置的页面，则结束循环。缺少这一步游客过滤就不会放行，why？
//					continue;
//				}
//			}
		}
		
		/**
		 * 禁止游客非法访问
		 */
		if(session.getAttribute("username")!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			//request.getContextPath()+目前有问题，即使输入错误网址也会被该过滤器拦截而跳转到login.jsp，而不是404界面
			response.sendRedirect("login.jsp");
		}
		System.out.println("LoginFilter过滤结束······");
	}

	/**
	 * destroy()是Web容器在销毁过滤器实例之前调用的方法，这个方法可以释放过滤器占用的资源。
	 * 当服务器停止时，会执行destroy()方法。
	 * 大多数情况下用不到！
	 */
	public void destroy() {
		System.out.println("LoginFilter过滤器销毁！");
	}
}
