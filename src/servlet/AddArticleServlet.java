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
 * @author ������
 * ��������
 */
public class AddArticleServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��session������Ϣ��������jspҳ����ʾ
		HttpSession session = req.getSession();
		String title = "";
		String content = "";
		String tag = "";
		//��ֹ������������
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//��ȡ������
		title = req.getParameter("title");
		content = req.getParameter("content");
		tag = req.getParameter("tag");
		
		if(title!=null && !"".equals(title) &&
			content!=null && !"".equals(content) &&
			tag!=null && !"".equals(tag)){
			
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
				System.out.println("�������ʧ�ܣ�");
			}
			//������ӳɹ�����Ϣ
			session.setAttribute("success", "���·����ɹ���");
		}else{
			//�������ʧ�ܵ���Ϣ
			session.setAttribute("fail", "���·���ʧ�ܣ�");
		}
		resp.sendRedirect(req.getContextPath()+"/manager.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
