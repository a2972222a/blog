package service;

import java.sql.SQLException;

import entity.Article;

/**
 * @author 秦晓阳
 * 添加文章的业务接口
 */
public interface AddArticleService {
	
	public void addArticle(Article a) throws SQLException;
	
}
