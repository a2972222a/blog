package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String title = "";
		String content = "";
		String tag = "";
		//防止输入中文乱码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//赋值
		title = req.getParameter(title);
		content = req.getParameter(content);
		tag = req.getParameter(tag);
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
		}
		//返回添加成功的信息
		req.setAttribute("success", "发布文章成功！");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
