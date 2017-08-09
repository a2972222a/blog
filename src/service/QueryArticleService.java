package service;

import java.sql.SQLException;
import java.util.List;

import dao.ArticleDAO;
import daoImpl.ArticleDAOImpl;
import entity.Article;

/**
 * @author 秦晓阳
 * 查询包含某字符串文章的业务接口
 */
public interface QueryArticleService {
	
	/**
	 * 查询包含某字符串文章的业务接口
	 */
	public List<Article> queryArticle(String str) throws SQLException;
	
}
