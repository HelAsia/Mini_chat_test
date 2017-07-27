package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	public void connection (String url, String username, String password) throws SQLException{
	//	url = "jdbc:mysql://localhost:3306/mini_chat";
	//	username = "root";
	//	password = "";
		
		try{
			Connection con = DriverManager.getConnection(url, username, password);
			
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
	
	public void queries(String query, Connection connection) throws SQLException {
		try{
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		}catch(SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
}
