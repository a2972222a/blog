package service;

import java.sql.SQLException;
import java.util.List;

import dao.ArticleDAO;
import daoImpl.ArticleDAOImpl;
import entity.Article;

/**
 * @author ������
 * ��ѯ����ĳ�ַ������µ�ҵ��ӿ�
 */
public interface QueryArticleService {
	
	/**
	 * ��ѯ����ĳ�ַ������µ�ҵ��ӿ�
	 */
	public List<Article> queryArticle(String str) throws SQLException;
	
}
