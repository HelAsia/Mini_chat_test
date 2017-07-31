package Mini_chat_test;

import java.util.Scanner;

public class MainScreen {
	
		SQLConnection sqlConn= new SQLConnection(); 	
	
	public void register() throws ClassNotFoundException{
		
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Enter your login");
		String login = odczyt.nextLine();
		
		System.out.println("Enter your password");
		String password = odczyt.nextLine();
		
		System.out.println("Enter your mail");
		String mail = odczyt.nextLine();
		
		System.out.printf("Your login is: %s and password is: %s and mail is: %s ", login, password, mail);
		
		sqlConn.queries("INSERT INTO user (login, password, mail) VALUES (" + login + "," + password + "," + mail + ")");
	
		
	}
}