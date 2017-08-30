package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AfterLogIn{
	
	SQLConnection mainObjectSQLConnection = new SQLConnection();
	
	private MainScreen workingObjectMainScreen;
	
	//MainScreen ms = new MainScreen (mainObjectSQLConnection);
	
	public AfterLogIn(MainScreen ms) {
		this.workingObjectMainScreen = ms;
	}

	public void setMainScreenObject(MainScreen ms) {
		this.workingObjectMainScreen = ms;
	}
	
	public void whatDo () {
				
	System.out.println("What would you like to do?\n"
			+ "[1] If you would like to WRITE TO SOMEONE. \n"
			+ "[2] If you would like to CHECK YOUR HISTORY. \n"
			+ "[3] If you would like to REFRESH MESSAGES. \n"
			+ "[4] If you would like to LOG OUT. \n");
	
	Scanner reading = new Scanner(System.in);
	int choice = reading .nextInt();
	boolean falseOrTrue = true;
	
	do{
		try{
			if (choice == 1){
				writeTo();
				falseOrTrue = false;
			}
			else if (choice == 2){
				history();
				falseOrTrue = false;
			}
			else if (choice == 3){
				refresh();
				falseOrTrue = false;
			}
			else if (choice == 4){
				logOut();
				falseOrTrue = false;
			}
			else{
				System.out.println("Your choice is wrong. Try again");
				falseOrTrue = true;
			}
		}
		catch (java.util.InputMismatchException e){
			System.out.println("Your value is wrong format. Try again");
		}
	}	
		while (falseOrTrue = true);
	}
	
	public void writeTo (){
		
		Scanner reading = new Scanner(System.in);
		
		System.out.println("Enter yours friend's login. \n");
		String loginRecipient = reading.nextLine();
		
		System.out.println("Enter your message. \n");
		String message = reading.nextLine();
		String loginUser = workingObjectMainScreen.getCurrentlyLogin();
		String status = "S";
		
		String query = String.format("INSERT INTO conversations (loginUser, message, status, loginRecipient) VALUES ('%s','%s','%s', '%s')", loginUser, message, status, loginRecipient);
		try {
			mainObjectSQLConnection.queryUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void history(){
		
	}
	
	public void refresh(){
		
	}
	
	public void logOut(){
		
	}
}