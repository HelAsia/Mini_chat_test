package Mini_chat_test;

import java.util.Scanner;

public class MainScreen {
	
	public SQLConnection sqlConn;
	//public MainScreen (String query){
	//	query = "show tables";
	//}
	public void register(){
		
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Enter your login");
		String login = odczyt.nextLine();
		
		System.out.println("Enter your password");
		String password = odczyt.nextLine();
		
		System.out.println("Enter your mail");
		String mail = odczyt.nextLine();
		
		System.out.printf("Your login is: %s and password is: %s and mail is: %s ", login,password,mail);
		
		sqlConn.connection("INSERT INTO user VALUES (NULL" + login + "," + password + "," + mail + ")");
	}
}