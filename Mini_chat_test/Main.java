package Mini_chat_test;

import java.sql.SQLException;
import java.util.Vector;

public class Main {
	public static void main(String args[]){

		try{
			ChoiceWindow cw = new ChoiceWindow();
			cw.window();
		}
		catch(IllegalStateException e){
			System.out.println("Database is offline");
		}
		
	}
}
