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
 * @author ������
 * ������
 * ����xml���ã�Ҳ����ע�����ã�����
 */
public class LoginFilter implements javax.servlet.Filter {
	
	private FilterConfig filterConfig;
	
	/**
	 * init()�ǹ������ĳ�ʼ��������
	 * Web��������������ʵ���󣨷���������ʱ�������������������
	 * ����������Զ�ȡweb.xml�ļ��еĹ�����������
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter��������ʼ����");
		//���Զ����filterConfig�������úõĳ�ʼ������������ִ�й���ʱѭ������
		this.filterConfig = filterConfig;
	}
	
	/**
	 * doFilter()���ʵ�ʵĹ��˲������ǹ������ĺ��ķ�����
	 * ���û���������������������URLʱ��Web�������ȵ��ù�������doFilter()������
	 * FilterChain�������Ե���chain.doFilter()�����������󴫸���һ����������Ŀ����Դ��
	 * ��������ת�����ض�������ת����������Դ��
	 * 
	 * ����������
	 * 1���ж��������ʱ��������ǵ�url-pattern��ͬ���򲻹��ɹ���������
	 * ��doFilter()ִ��˳����xml�е��Ⱥ�����������
	 * 2������ͬ����ʱ���ǵ���������Ϊ��
	 * init1,init2,...,startFilter1,startFilter2,...jsp...,endFilter2,endFilter1,...,destroy1,destroy2,...
	 * 
	 * һ��filter�����ж��mapping��������ض���ᵼ������ת��
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("LoginFilter���˿�ʼ������������");
		
		/**
		 * �����ҷ�Ҫ��foreach�����˺ö����⡣������forѭ����
		 */
		//������ǿ��ת��arg0�����ܵ���session��
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		//����ִ�й��˷��У���������ҳ��հ�
//		arg2.doFilter(arg0, arg1);
//		System.out.println(request.getRequestURI());//��ȡ�����URI����������URL��
		
		/**
		 * ����LoginFilter�õ�url-pattern�� /*��
		 * �����ж�session�Ƿ�Ϸ������������жϣ�
		 * ���ܱ���login.jspҳ�����ѭ����һֱ����login.jsp����
		 * ��������Ҫ�жϺܶ�jsp��servletҳ�棬������õ���init()�е�filterConfig����web.xml�����úõĿ���ִ�й��˵�ҳ��
		 * �����Ժ�ֻ����web.xml�����ü��ɣ������޸�filter���룡����
		 */
		String noLoginPaths = filterConfig.getInitParameter("noLoginPaths");
		//������Ҫ�ȶ�noLoginPaths�Ƿ�Ϊ�����ж�
		if(noLoginPaths!=null){
			String[] pages = noLoginPaths.split(";");//regex=regular expression��������ʽ��
			
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
//				//��������д������õ�ҳ�棬��ִ�й��˷���
//				if(request.getRequestURI().indexOf(string)!=-1){
//					arg2.doFilter(arg0, arg1);
//					return;//��������
//				}else{
//					//��������в��������õ�ҳ�棬�����ѭ����ȱ����һ���ο͹��˾Ͳ�����У�why��
//					continue;
//				}
//			}
		}
		
		/**
		 * ��ֹ�οͷǷ�����
		 */
		if(session.getAttribute("username")!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			//request.getContextPath()+Ŀǰ�����⣬��ʹ���������ַҲ�ᱻ�ù��������ض���ת��login.jsp��������404����
			response.sendRedirect("login.jsp");
		}
		System.out.println("LoginFilter���˽���������������");
	}

	/**
	 * destroy()��Web���������ٹ�����ʵ��֮ǰ���õķ�����������������ͷŹ�����ռ�õ���Դ��
	 * ��������ֹͣʱ����ִ��destroy()������
	 * �����������ò�����
	 */
	public void destroy() {
		System.out.println("LoginFilter���������٣�");
	}
}
