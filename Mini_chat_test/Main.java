package Mini_chat_test;

import java.sql.SQLException;

public class Main {
	public static void main(String args[]){
		
			SQLConnection sc = new SQLConnection();		
			try {
				sc.connection();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}


		ChoiceWindow cw = null;
		
		try{
			cw = new ChoiceWindow();
		}
		catch(IllegalStateException e){
			System.out.println("Database is offline");
			return;
		}
		cw.window();
	}
}
