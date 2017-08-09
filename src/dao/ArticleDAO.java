package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Article;

/**
 * @author 秦晓阳
 * 文章的增删改查接口
 */
public interface ArticleDAO {
	
	/**
	 * 添加文章
	 */
	public void add(Article a) throws SQLException;
	
	/**
	 * 查询文章
	 */
	public List<Article> query(String str) throws SQLException;
}
