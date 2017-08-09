package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Article;
import service.AddArticleService;
import serviceImpl.AddArticleServiceImpl;

/**
 * @author 秦晓阳
 * 发布文章
 */
public class AddArticleServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//用session保存信息，用于在jsp页面显示
		HttpSession session = req.getSession();
		String title = "";
		String content = "";
		String tag = "";
		//防止输入中文乱码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取表单参数
		title = req.getParameter("title");
		content = req.getParameter("content");
		tag = req.getParameter("tag");
		
		if(title!=null && !"".equals(title) &&
			content!=null && !"".equals(content) &&
			tag!=null && !"".equals(tag)){
			
			//传入文章对象
			Article a = new Article();
			a.setTitle(title);
			a.setContent(content);
			a.setTag(tag);
			AddArticleService aasi = new AddArticleServiceImpl();
			try {
				aasi.addArticle(a);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("添加文章失败！");
			}
			//返回添加成功的信息
			session.setAttribute("success", "文章发布成功！");
		}else{
			//返回添加失败的信息
			session.setAttribute("fail", "文章发布失败！");
		}
		resp.sendRedirect(req.getContextPath()+"/manager.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
