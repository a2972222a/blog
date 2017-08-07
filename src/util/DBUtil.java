package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 秦晓阳
 * 数据库blog连接
 */
public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/blog";
	private static final String USER = "root";
	private static final String PASSWORD = "21henearkrxnrn!@#$";
	
	private static Connection conn = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ManagerDriver是什么东西！
			//getConnection能不能别忘括号里要添加东西！！！！！！！！！！！！！！！！
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
