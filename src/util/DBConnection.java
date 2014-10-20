package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con=null;
	public Connection getConnection(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			return con=DriverManager.getConnection("jdbc:mysql://localhost/managementDB","root","999");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
