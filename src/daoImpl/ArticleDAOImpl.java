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
 * @author ������
 * ������ɾ�ĳɵ�ʵ��
 */
public class ArticleDAOImpl implements ArticleDAO {

	/**
	 * �������
	 * @throws SQLException 
	 */
	@Override
	public void add(Article a) throws SQLException {
		//�������ݿ�
		Connection conn = DBUtil.getConnection();
		//��Ӽ�¼��sql���
		String sql = ""+"insert article(title,content,time,tag) "+
				"values(?,?,current_date(),?); ";
		//Ԥ����sql
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, a.getTitle());
		ps.setString(2, a.getContent());
		ps.setString(3, a.getTag());
		//ִ��sql
		ps.execute();
	}
	
	/**
	 * ��ѯ����ĳ�ַ���������
	 * @throws SQLException 
	 */
	@Override
	public List<Article> query(String str) throws SQLException {
		Connection conn = DBUtil.getConnection();
		List<Article> list = new ArrayList<Article>();
		Article a = null;//���ﲻ����ǰnew����Ϊ�п����Ƕ����������Ժ���Բ�ѯ�õ��Ľ��ÿѭ��һ��newһ��
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
