package Mini_chat_test;

import java.sql.SQLException;

public class Main {
	public static void main(String args[]) throws SQLException{
	SQLConnection conn = new SQLConnection ();
	conn.connection("jdbc:mysql://localhost:3306/mini_chat", "root", "");
	}
}
