package com.isamm.tp1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connecteur {


	private static final String URL = "jdbc:mysql://localhost/";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "";
	private static final String DBNAME = "banque";

	public static Connection getConenction(){

		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c = DriverManager.getConnection(URL+DBNAME, LOGIN, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

}
