package service;

import java.sql.SQLException;

import entity.Article;

/**
 * @author ������
 * ������µ�ҵ��ӿ�
 */
public interface AddArticleService {
	
	public void addArticle(Article a) throws SQLException;
	
}
