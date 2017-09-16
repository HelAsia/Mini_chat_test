package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AfterLogIn{
	
	SQLConnection mainObjectSQLConnection = new SQLConnection();
	ChoiceWindow objectChoiceWindow = new ChoiceWindow();
	
	private MainScreen workingObjectMainScreen;
	
	public AfterLogIn(MainScreen ms) {
		this.workingObjectMainScreen = ms;
	}

	public void setMainScreenObject(MainScreen ms) {
		this.workingObjectMainScreen = ms;
	}
	
	public void whatDo () {
				
	System.out.println("What would you like to do?\n"
			+ "[1] If you would like to WRITE TO SOMEONE. \n"
			+ "[2] If you would like to READ YOUR MESSAGES. \n"
			+ "[3] If you would like to CHECK YOUR HISTORY. \n"
			+ "[4] If you would like to REFRESH MESSAGES. \n"
			+ "[5] If you would like to LOG OUT. \n");
	
	Scanner reading = new Scanner(System.in);
	int choice = reading .nextInt();
	boolean didntDo = true;
	
	do{
		try{
			if (choice == 1){
				writeTo();
				didntDo = false;
			}
			else if (choice == 2){
				readMessage();
				didntDo = false;
			}
			else if (choice == 3){
				history();
				didntDo = false;
			}
			else if (choice == 4){
				refresh();
				didntDo = false;
			}
			else if (choice == 5){
				logOut();
				didntDo = false;
			}
			else{
				System.out.println("Your choice is wrong. Try again");
				didntDo = true;
			}
		}
		catch (java.util.InputMismatchException e){
			System.out.println("Your value is wrong format. Try again");
			didntDo = true;
		}
	}	
		while (didntDo == true);
	}
	
	public void writeTo (){
		Scanner reading = new Scanner(System.in);
		boolean wrongFriendLogin = false;
		String loginRecipient;
		
		do{
			System.out.println("Enter yours friend's login. \n");
			loginRecipient = reading.nextLine();
			
			String chectLoginFriend= String.format("SELECT login FROM user WHERE login = '%s'", loginRecipient);
			
			try {
				ResultSet rs = mainObjectSQLConnection.query(chectLoginFriend);
				int count = 0;
				while (rs.next()) {
					++count;
					wrongFriendLogin = false;
				}
				if (count == 0) {
					System.out.println("Your friend login is wrong. You have to check it and try again. \n");
					wrongFriendLogin = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		} while (wrongFriendLogin == true);
		
		
		System.out.println("Enter your message. \n");
		String message = reading.nextLine();
		
		String loginUser = workingObjectMainScreen.getCurrentlyLogin();
		String status = "N";
		
		Calendar cal = Calendar.getInstance();

	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);      
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    int minute = cal.get(Calendar.MINUTE);
	    int second = cal.get(Calendar.SECOND);
	    int idUser = 0;
	    int idConversations = 0;
	    
	    try {
	    	String checkIdUser = String.format("Select ID_user FROM user Where login = \"%s\"", loginUser);
	    	ResultSet rs = mainObjectSQLConnection.query(checkIdUser);
	    	rs.next();
	    	idUser = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		try {
			String addConversation = String.format("INSERT INTO conversations (ID_user, loginRecipient) VALUES (%d,\"%s\")", 
		    		idUser, loginRecipient);
			mainObjectSQLConnection.queryUpdate(addConversation);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			String checkIdConversations = String.format("Select ID_conversations FROM conversations Where ID_user = \"%s\" and loginRecipient = \"%s\" ", idUser, loginRecipient);
		    ResultSet rs1 = mainObjectSQLConnection.query(checkIdConversations);
		    rs1.next();
		    idConversations = rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			String addMessage = String.format("INSERT INTO message (text, ID_conversations, date_time, status) VALUES (\"%s\", %d, '%04d-%02d-%02d %02d:%02d:%02d', \"%s\")", 
					message, idConversations, year,month+1,day, hour, minute, second, status);
			mainObjectSQLConnection.queryUpdate(addMessage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void readMessage(){
		
	}
	
	public void history(){
		
	}
	
	public void refresh(){
		
	}
	
	public void logOut(){
		objectChoiceWindow.window();
		
	}
}