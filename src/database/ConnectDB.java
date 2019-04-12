package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection getSQLServerConnection_SQLJDBC() //
			throws ClassNotFoundException, SQLException {

		String hostName = "\\\\ADMIN";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "QLSach";
		String userName = "tuyen";
		String password = "1234";

		return getSQLServerConnection_SQLJDBC(hostName, sqlInstanceName, database, userName, password);
	}

	private static Connection getSQLServerConnection_SQLJDBC(String hostName, //
			String sqlInstanceName, String database, String userName, String password)//
			throws ClassNotFoundException, SQLException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" //
				+ ";instance=" + sqlInstanceName + ";databaseName=" + database;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
		
	} 

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = getSQLServerConnection_SQLJDBC();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conn);
	}

}
