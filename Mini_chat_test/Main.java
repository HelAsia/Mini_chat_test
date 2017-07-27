package Mini_chat_test;

import java.sql.SQLException;

public class Main {
	public static void main(String args[]) throws SQLException{
	SQLConnection test = new SQLConnection ();
	test.connection("desc table user;");
	
	}
}
