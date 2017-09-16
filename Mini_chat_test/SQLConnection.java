package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class SQLConnection {
	
	private Connection conn;
	
	public SQLConnection (){
		try {
			connection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void connection () throws ClassNotFoundException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_chat?autoReconnect=true&useSSL=false", "root", "");//
			System.out.println("connected");
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
	
	public void queryUpdate (String query) throws SQLException{
		Statement st;
		try {
			System.out.printf("DEBUG: Query to send: \"%s\"\n", query);
			st = conn.createStatement();
			st.executeUpdate(query);
		}
		catch (MySQLIntegrityConstraintViolationException e) {
			throw e;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query (String query) throws SQLException{
		Statement st;
		System.out.printf("DEBUG: Query to send: \"%s\"\n", query);
		st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
}
