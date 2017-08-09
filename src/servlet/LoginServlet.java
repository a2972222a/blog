package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 秦晓阳
 * 登陆服务
 */
public class LoginServlet extends HttpServlet{
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username ="";
		String password ="";
		req.setCharacterEncoding("utf-8");//防止输入中文乱码
		resp.setCharacterEncoding("utf-8");
		
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		if("a2972222a".equals(username)&&"qxy2972222".equals(password)){
			//校验成功
			HttpSession session = req.getSession();
			//不建议放入密码！！！
			session.setAttribute("username", username);//jsp页面尽量使用el表达式！！！
			//跳转到成功页面
			//这里使用转发一直失败，原因未知。。。。。。。。。。。。。。。
			//重定向/表示当前路径，也即servlet；而转发/表示项目的根目录
//			req.getRequestDispatcher(req.getContextPath()+"/login_success.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath()+"/login_success.jsp");
			//也可以这样（..表示从servlet子目录回到blog）
//			request.getRequestDispatcher("../login_success.jsp").forward(req,resp);
			
		}else{
			//校验失败，跳转到失败页面，注意添加获取上下文路径！！！
			resp.sendRedirect(req.getContextPath()+"/login_fail.jsp");
		}
	}
	
}
