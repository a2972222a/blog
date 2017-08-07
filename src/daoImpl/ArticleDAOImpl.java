package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ArticleDAO;
import entity.Article;
import util.DBUtil;

/**
 * @author ������
 * ������ɾ�ĳɵ�ʵ��
 */
public class ArticleDAOImpl implements ArticleDAO {

	/**
	 * ��������
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

}
