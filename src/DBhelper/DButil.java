package DBhelper;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DButil {
	public static String URL = "jdbc:mysql://localhost:3306/easybuy?characterEncoding=UTF-8";
	public static String USER = "root";
	public static String PWD = "12345678";
	
	//1.获取连接
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//2.关闭连接
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
