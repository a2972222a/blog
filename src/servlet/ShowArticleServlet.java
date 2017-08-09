package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Article;
import service.QueryArticleService;
import serviceImpl.QueryArticleServiceImpl;

/**
 * @author ������
 * ����˵���ʾ����
 */
public class ShowArticleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��session������Ϣ��������jspҳ����ʾ
		HttpSession session = req.getSession();
		QueryArticleService qas = new QueryArticleServiceImpl();
		List<Article> list = new ArrayList<Article>();
		String str = "";
		String front = req.getParameter("front");
		String css = req.getParameter("css");
		String back = req.getParameter("back");
		String mysql = req.getParameter("mysql");
		String java = req.getParameter("java");
		
		//ǰ��
		if(front!=null && !"".equals(front)){
			str = front;
			try {
				list = qas.queryArticle(str);
			} catch (SQLException e) {
				System.out.println("something wrong!");
				e.printStackTrace();
			}
		}
		//css
		if(css!=null && !"".equals(css)){
			str = css;
			try {
				list = qas.queryArticle(str);
			} catch (SQLException e) {
				System.out.println("something wrong!");
				e.printStackTrace();
			}
		}
		//���
		if(back!=null && !"".equals(back)){
			str = back;
			try {
				list = qas.queryArticle(str);
			} catch (SQLException e) {
				System.out.println("something wrong!");
				e.printStackTrace();
			}
		}
		//mysql
		if(mysql!=null && !"".equals(mysql)){
			str = mysql;
			try {
				list = qas.queryArticle(str);
			} catch (SQLException e) {
				System.out.println("something wrong!");
				e.printStackTrace();
			}
		}
		//java
		if(java!=null && !"".equals(java)){
			str = java;
			try {
				list = qas.queryArticle(str);
			} catch (SQLException e) {
				System.out.println("something wrong!");
				e.printStackTrace();
			}
		}
		for (Article article : list) {
			session.setAttribute("title", article.getTitle());
			session.setAttribute("tag", article.getTag());
			session.setAttribute("content", article.getContent());
		}
		
//		session.setAttribute("list", list);
		resp.sendRedirect(req.getContextPath()+"/showArticle.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		
	}
	
}
