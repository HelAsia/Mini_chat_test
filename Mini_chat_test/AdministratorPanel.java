package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdministratorPanel{
	private SQLConnection mainObjectClassSQLConnection = new SQLConnection();
	
public void logIn(){
		
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Enter ADMIN'S login");
		String login = odczyt.nextLine();
		
		System.out.println("Enter ADMIN'S password");
		String password = odczyt.nextLine();
		
		String adminData = "admin";
		
		if (login.equals(adminData)){
			System.out.println("You are in Administrator Panel. What are You doing now?"
					+ "[1] PRINT ALL USERS"
					+ "[2] REMOVED SOME USER"
					+ "[3] EDIT SOME USER"
					+ "[4] BLOCK SOME USER");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}