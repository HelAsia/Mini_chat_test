package Mini_chat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	/*String query;
	
	public SQLConnection (String query){
		this.query = query;
	}
	*/
	
	public ResultSet connection (String query) {

		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_chat?autoReconnect=true&useSSL=false", "root", "");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
}
