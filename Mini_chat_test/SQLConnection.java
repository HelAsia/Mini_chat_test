package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	
	public void connection () throws ClassNotFoundException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_chat?autoReconnect=true&useSSL=false", "root", "");
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
	
	public void queries (String query){
		Statement st = conn.createStatement();
		st.executeUpdate(query);
	}
}
