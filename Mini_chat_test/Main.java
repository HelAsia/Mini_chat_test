package Mini_chat_test;

import java.sql.SQLException;

public class Main {
	public static void main(String args[]){

		MainScreen ms = null;
		try{
			ms = new MainScreen();
		}
		catch(IllegalStateException e){
			System.out.println("Database is offline");
			return;
		}
		
		ms.register();
	//	ms.logIn();
	}
}
