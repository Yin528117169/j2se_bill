package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static String ip = "127.0.0.1";
	static int port = 3306;
	static String database = "hutubill";
	static String encoding = "UTF-8";
	static String loginName = "root";
	static String password = "root";
	static {
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		String url = String.format("jdbc:mysql://%s:%d/%s?useUnicode=true&characterEncoding=%s&useSSL=true", ip,port,database,encoding);
		return DriverManager.getConnection(url, loginName, password);
	}

}
