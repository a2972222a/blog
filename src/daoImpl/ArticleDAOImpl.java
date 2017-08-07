package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ArticleDAO;
import entity.Article;
import util.DBUtil;

/**
 * @author 秦晓阳
 * 文章增删改成的实现
 */
public class ArticleDAOImpl implements ArticleDAO {

	/**
	 * 发布文章
	 * @throws SQLException 
	 */
	@Override
	public void add(Article a) throws SQLException {
		//连接数据库
		Connection conn = DBUtil.getConnection();
		//添加记录的sql语句
		String sql = ""+"insert article(title,content,time,tag) "+
				"values(?,?,current_date(),?); ";
		//预编译sql
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, a.getTitle());
		ps.setString(2, a.getContent());
		ps.setString(3, a.getTag());
		//执行sql
		ps.execute();
	}

}
