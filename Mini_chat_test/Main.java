package Mini_chat_test;

import java.sql.SQLException;

public class Main {
	public static void main(String args[]){

		ChoiceWindow cw = null;
		
		try{
			cw = new ChoiceWindow();
		}
		catch(IllegalStateException e){
			System.out.println("Database is offline");
			return;
		}
		cw.window();
		
		/*	
AfterLogIn ali = null;
		
		try{
			ali = new AfterLogIn();
		}
		catch(IllegalStateException e){
			System.out.println("Database is offline");
			return;
		}
		ali.whatDo();
		*/
	}
}

