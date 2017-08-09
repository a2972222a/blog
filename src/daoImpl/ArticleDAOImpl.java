package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleDAO;
import entity.Article;
import util.DBUtil;

/**
 * @author 秦晓阳
 * 文章增删改成的实现
 */
public class ArticleDAOImpl implements ArticleDAO {

	/**
	 * 添加文章
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
	
	/**
	 * 查询包含某字符串的文章
	 * @throws SQLException 
	 */
	@Override
	public List<Article> query(String str) throws SQLException {
		Connection conn = DBUtil.getConnection();
		List<Article> list = new ArrayList<Article>();
		Article a = null;//这里不能提前new，因为有可能是多个结果，所以后面对查询得到的结果每循环一次new一次
		String sql = ""+"select * from article "+
				"where title like ? or "+
				"content like ? or "+
				"tag like ? ";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, str);
		pst.setString(2, str);
		pst.setString(3, str);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			a=new Article();
			a.setTitle(rs.getString("title"));
			a.setContent(rs.getString("content"));
			a.setTag(rs.getString("tag"));
			list.add(a);
		}
		return list;
	}

}
