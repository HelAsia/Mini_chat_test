package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;

public class AfterLogIn{
	
	public void test1 (String databaseDriver, String databaseUrl, String username, String password){
		
	try
	   {
		databaseDriver = "com.mysql.jdbc.Driver";
		databaseUrl = "jdbc:mysql://localhost:3306/mini_chat";
		username = "root";
		password= "";
		
	    Class.forName(databaseDriver);
	    Connection connection = DriverManager.getConnection(databaseUrl);
	    String query = "Select * from TEST";
	    Object resultSet = statement.executeQuery(query); 
	    }catch(Exception ex){
	   System.out.println("Connection Error");
	  }
	}
}