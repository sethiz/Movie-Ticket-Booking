package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
	private static Connection con = null;

	private DataConnection() {
	}

	public static Connection getConnection() {
		try {
			if (con == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "admin");
			}
			return con;
		} catch (Exception ex) {
			System.out.println(ex);
			throw null;
		}
	}

	public static void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
			con = null;
		} catch (SQLException ex) {
		}
	}
}