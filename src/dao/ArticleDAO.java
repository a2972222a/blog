package dao;

import java.sql.SQLException;

import entity.Article;

/**
 * @author ������
 * ���µ���ɾ�Ĳ�ӿ�
 */
public interface ArticleDAO {
	
	/**
	 * ��������
	 */
	public void add(Article a) throws SQLException;
	
}
