package in.coder.ai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.coder.util.JDBCUtil;

public class UpdateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null;
		Statement statement = null;
        
		
		try {
         
			connection = JDBCUtil.getJdbcConnection();

			if (connection != null) {
				statement = connection.createStatement();
			}

			if (statement != null) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the student id where you want to change:: ");
				int sid = scanner.nextInt();

				System.out.println("What do you want to change for Name(1), Age(2), Address(3)");
				int choice = scanner.nextInt();

				String sqlUpdateQuery = null;
				switch (choice) {
				case 1:
					System.out.println("Enter new name :: ");
					String sname = scanner.next();
					sqlUpdateQuery = String.format("Update students set sname='%s' where sid=%d", sname, sid);
					break;
				case 2:
					System.out.println("Enter new age :: ");
					int sage = scanner.nextInt();
					sqlUpdateQuery = String.format("Update students set sage=%d where sid=%d", sage, sid);
					break;
				case 3:
					System.out.println("Enter new address :: ");
					String saddress = scanner.next();
					sqlUpdateQuery = String.format("Update students set saddress='%s' where sid=%d", saddress, sid);
					break;
				default:
					System.out.println("Wrong Choice! ");
				}
				scanner.close();
				if (sqlUpdateQuery != null) {
					int rowsAffected = statement.executeUpdate(sqlUpdateQuery);
					System.out.println("Number of rows Affected:: " + rowsAffected);

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
				JDBCUtil.cleaning(connection, statement, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
