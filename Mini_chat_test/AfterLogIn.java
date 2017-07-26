package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AfterLogIn{
	
	public void connection (String url, String username, String password){
	//	url = "jdbc:mysql://localhost:3306/mini_chat";
	//	username = "root";
	//	password= "";
		
		try (Connection connection = DriverManager.getConnection(url, username, password)){
			
			 System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
	
		}
	}
}