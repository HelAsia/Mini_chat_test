package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	//String query;
	
	//pubic connection (String query){
	//	this.query = query;
	//}
	public void connection (String query) throws SQLException{
		

		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_chat", "root", "");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
}
