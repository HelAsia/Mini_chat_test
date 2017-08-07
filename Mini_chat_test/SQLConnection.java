package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	
	private Connection conn;
	
	public void connection () throws ClassNotFoundException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_chat?autoReconnect=true&useSSL=false", "root", "");//
			System.out.println("connected");
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
	
	public void query (String query){
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
