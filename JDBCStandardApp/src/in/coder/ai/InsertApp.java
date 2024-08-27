package in.coder.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.coder.util.JDBCUtil;

public class InsertApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		Scanner scanner = new Scanner(System.in);

		try {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null)
				statement = connection.createStatement();

			if (statement != null) {
				System.out.println("Enter the name:: ");
				String sname = scanner.next();

				System.out.println("Enter the age:: ");
				int sage = scanner.nextInt();

				System.out.println("Enter the address:: ");
				String saddress = scanner.next();
				String sqlInsertQuery = String.format(
						"insert into students(`sname`,`sage`,`saddress`) values('%s',%d,'%s')", sname, sage, saddress);

				int rowsAffected = statement.executeUpdate(sqlInsertQuery);

				System.out.println("Number of rowsAffected:: " + rowsAffected);

			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.cleaning(connection, statement, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				scanner.close();
			}
		}

	}

}
