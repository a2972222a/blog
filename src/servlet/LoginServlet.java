package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ������
 * ��½����
 */
public class LoginServlet extends HttpServlet{
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username ="";
		String password ="";
		req.setCharacterEncoding("utf-8");//��ֹ������������
		resp.setCharacterEncoding("utf-8");
		
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		if("a2972222a".equals(username)&&"qxy2972222".equals(password)){
			//У��ɹ�
			HttpSession session = req.getSession();
			//������������룡����
			session.setAttribute("username", username);//jspҳ�澡��ʹ��el���ʽ������
			//��ת���ɹ�ҳ��
			//����ʹ��ת��һֱʧ�ܣ�ԭ��δ֪������������������������������
//			req.getRequestDispatcher(req.getContextPath()+"/login_success.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath()+"/login_success.jsp");
		}else{
			//У��ʧ�ܣ���ת��ʧ��ҳ�棬ע����ӻ�ȡ������·��������
			resp.sendRedirect(req.getContextPath()+"/login_fail.jsp");
		}
	}
	
}
