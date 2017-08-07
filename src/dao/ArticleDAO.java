package dao;

import java.sql.SQLException;

import entity.Article;

/**
 * @author 秦晓阳
 * 文章的增删改查接口
 */
public interface ArticleDAO {
	
	/**
	 * 发布文章
	 */
	public void add(Article a) throws SQLException;
	
}
