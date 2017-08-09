package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Article;

/**
 * @author ������
 * ���µ���ɾ�Ĳ�ӿ�
 */
public interface ArticleDAO {
	
	/**
	 * �������
	 */
	public void add(Article a) throws SQLException;
	
	/**
	 * ��ѯ����
	 */
	public List<Article> query(String str) throws SQLException;
}
