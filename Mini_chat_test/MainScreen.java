package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class MainScreen{
	
	public void connection (String url, String username, String password){

		try (Connection connection = DriverManager.getConnection(url, username, password)){
			 System.out.println("Database connected!");
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}