package in.coder.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.coder.util.JDBCUtil;

public class DeleteApp {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
       
		try {
		connection = JDBCUtil.getJdbcConnection();

		if (connection != null) {
			statement = connection.createStatement();
		}

		if (statement != null) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter student id : ");
			int sid = scanner.nextInt();
			scanner.close();
			String sqlDeleteQuery = String.format("Delete from students where sid=%d", sid);

			int rowsAffected = statement.executeUpdate(sqlDeleteQuery);
			System.out.println("No of rows Affected:: " + rowsAffected);
		}
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.cleaning(connection, statement, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
