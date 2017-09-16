package Mini_chat_test;

import java.sql.SQLException;

public class Main {
	public static void main(String args[]){

		ChoiceWindow cw = null;
		
		try{
			cw = new ChoiceWindow();
			cw.window();
		}
		catch(IllegalStateException e){
			System.out.println("Database is offline");
		}
		
	}
}
