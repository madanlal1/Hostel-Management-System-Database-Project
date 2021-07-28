package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection con = null;
	public static Connection getConnection() {
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:/hostel_MSDB","root","");
		}
		}catch(SQLException e) {
			System.out.println("SQLEXCEPTTION in Class");
		}catch(ClassNotFoundException e) {
			System.out.println("Class not Found in LoginBean Class");
			
		}
		return con;
	}

}