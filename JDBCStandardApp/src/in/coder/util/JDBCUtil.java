package in.coder.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	
		// TODO Auto-generated method stub
		private JDBCUtil() {};
		
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static Connection getJdbcConnection() throws SQLException, IOException {			
			FileInputStream fis = new FileInputStream("D:\\ineuron\\PracticeJDBC\\JDBCStandardApp\\application.properties");
			Properties properties = new Properties();
			properties.load(fis);
			Connection connection = DriverManager.getConnection(properties.getProperty("url"), 
					properties.getProperty("username"), properties.getProperty("password"));
			System.out.println("Connection created...");
			return connection;
		}
		
		public static void cleaning(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
			if(connection!=null)
				connection.close();
			
			if(statement!=null)
				statement.close();
			
			if(resultSet!=null) {
				resultSet.close();
			}
		}
}

	

	// TODO Auto-generated method stub
			