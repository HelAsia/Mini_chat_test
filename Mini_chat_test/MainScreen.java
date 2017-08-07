package Mini_chat_test;

import java.util.Scanner;

public class MainScreen{
	
	private SQLConnection sc = new SQLConnection();		
	
	public void register() throws ClassNotFoundException{
		sc.connection();
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Enter your login");
		String login = odczyt.nextLine();
		
		System.out.println("Enter your password");
		String password = odczyt.nextLine();
		
		System.out.println("Enter your mail");
		String mail = odczyt.nextLine();
		
		System.out.printf("Your login is: %s and password is: %s and mail is: %s ", login, password, mail);
		
		String query = String.format("INSERT INTO user (login, password, mail) VALUES ('%s','%s','%s')",login, password, mail);
		sc.query(query);
	
		
	}
}