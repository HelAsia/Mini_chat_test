package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MainScreen{
	
	private String currentlyLogin;
	private SQLConnection workingObjectSQLConnection = new SQLConnection();
	
	/*public MainScreen(){
		try {
			workingObjectSQLConnection.connection();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	*/
	public void register() {
		
		Scanner reading = new Scanner(System.in);
	
		System.out.println("Enter your login");
		String login = reading.nextLine();
		
		System.out.println("Enter your password");
		String password = reading.nextLine();
		
		System.out.println("Enter your mail");
		String mail = reading.nextLine();

		Pattern pattern = Pattern.compile("\\w*@+\\w*\\.+\\w+");
		Matcher matcher = pattern.matcher(mail);
		matcher.matches(); //zwraca true lub false
		
		if (matcher.matches() == true) {
			System.out.printf("Your login is: %s and password is: %s and mail is: %s\n", login, password, mail);
		
			String query = String.format("INSERT INTO user (login, password, mail) VALUES ('%s','%s','%s')",login, password, mail);
			
			try {
				workingObjectSQLConnection.queryUpdate(query);
				
			} catch (MySQLIntegrityConstraintViolationException e) {
				System.out.println("This login exist in database. You have to enter new login");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else{
			System.out.println("Your mail is wrong. You have to try again.");
		}
	}
	
	public boolean logIn(){
		
		if (this.currentlyLogin != null && !this.currentlyLogin .isEmpty()){
			return true;
		}
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Enter your login");
		String login = odczyt.nextLine();
		
		System.out.println("Enter your password");
		String password = odczyt.nextLine();
		
		String query = String.format("SELECT login, password FROM user WHERE login = '%s' and password = '%s'",login, password);
		
		try {
			ResultSet rs = workingObjectSQLConnection.query(query);
			int count = 0;
			while (rs.next()) {
				++count;
			}
			if (count == 0) {
				System.out.println("Your login or password is wrong. You have to check it and try again.");
			}
			else{
				this.currentlyLogin = login;
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public String getCurrentlyLogin() {
		return this.currentlyLogin;
	}
	
}