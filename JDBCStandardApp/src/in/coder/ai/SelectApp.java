package in.coder.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.coder.util.JDBCUtil;

public class SelectApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getJdbcConnection();

			if (connection != null)
				statement = connection.createStatement();

			if (statement != null) {
				String sqlSelectQuery = "Select sid, sname, sage, saddress from students";
				resultSet = statement.executeQuery(sqlSelectQuery);

				System.out.printf("%-2s%14s%12s%15s", "SID", "SNAME", "SAGE", "SADDRESS");
				System.out.println();
				while (resultSet.next()) {
					System.out.printf("%2d%15s%12d%15s", resultSet.getInt(1), resultSet.getString(2),
							resultSet.getInt(3), resultSet.getString(4));
					System.out.println();
				}
			}

		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.cleaning(connection, statement, resultSet);
				System.out.println("Closing the resources...");
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
