package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ������
 * ���ݿ�blog����
 */
public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/blog";
	private static final String USER = "root";
	private static final String PASSWORD = "21henearkrxnrn!@#$";
	
	private static Connection conn = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ManagerDriver��ʲô������
			//getConnection�ܲ��ܱ���������Ҫ��Ӷ�����������������������������������
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
}
