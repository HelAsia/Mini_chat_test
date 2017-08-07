package Mini_chat_test;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class MainScreen{
	public MainScreen(){
		try {
			sc.connection();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private SQLConnection sc = new SQLConnection();		
	
	public void register() {
		
		Scanner odczyt = new Scanner(System.in);
	
		System.out.println("Enter your login");
		String login = odczyt.nextLine();
		
		System.out.println("Enter your password");
		String password = odczyt.nextLine();
		
		System.out.println("Enter your mail");
		String mail = odczyt.nextLine();
		
		System.out.printf("Your login is: %s and password is: %s and mail is: %s\n", login, password, mail);
	
		String query = String.format("INSERT INTO user (login, password, mail) VALUES ('%s','%s','%s')",login, password, mail);
		
		try {
			sc.query(query);
			
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("This login exist in database. You have to enter new login");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void logIn(){
		
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Enter your login");
		String login = odczyt.nextLine();
		
		System.out.println("Enter your password");
		String password = odczyt.nextLine();
		
		System.out.println("Enter your mail");
		String mail = odczyt.nextLine();
		
		String query = String.format("INSERT INTO user (login, password, mail) VALUES ('%s','%s','%s')",login, password, mail);
		
		try {
			sc.query(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}