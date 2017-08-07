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
 * @author ������
 * ��������
 */
public class AddArticleServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = "";
		String content = "";
		String tag = "";
		//��ֹ������������
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//��ֵ
		title = req.getParameter(title);
		content = req.getParameter(content);
		tag = req.getParameter(tag);
		//�������¶���
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
		//������ӳɹ�����Ϣ
		req.setAttribute("success", "�������³ɹ���");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
