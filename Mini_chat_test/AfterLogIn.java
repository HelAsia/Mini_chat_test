package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class AfterLogIn{
	
	SQLConnection objectSQLConnectionAl;
	ChoiceWindow objectChoiceWindow = new ChoiceWindow();
	
	private MainScreen objectMainScreen;

	public AfterLogIn(MainScreen ms) {
		this.objectMainScreen = ms;
		objectSQLConnectionAl = ms.getSQLConnection();
	}

	public void whatDo () {
		System.out.println("\nWhat would you like to do?\n"
				+ "[1] WRITE TO SOMEONE \n"
				+ "[2] READ YOUR UNREAD MESSAGES \n"
				+ "[3] CHECK YOUR HISTORY \n"
				+ "[4] LOG OUT \n");
		
		Scanner reading1 = new Scanner(System.in);
		int choice = reading1 .nextInt();
		boolean didntDo = true;
		
		do{
			try{
				if (choice == 1){
					writeTo();
					returnToTheMenu();
					didntDo = false;
				}
				else if (choice == 2){
					readMessage();
					returnToTheMenu();
					didntDo = false;
				}
				else if (choice == 3){
					history();
					returnToTheMenu();
					didntDo = false;
				}
				else if (choice == 4){
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
				ResultSet rs = objectSQLConnectionAl.query(chectLoginFriend);
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
		
		String loginUser = objectMainScreen.getCurrentlyLogin();
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
	    	ResultSet rs = objectSQLConnectionAl.query(checkIdUser);
	    	rs.next();
	    	idUser = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		try {
			String addConversation = String.format("INSERT INTO conversations (ID_user, loginRecipient) VALUES (%d,\"%s\")", 
		    		idUser, loginRecipient);
			objectSQLConnectionAl.queryUpdate(addConversation);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			String checkIdConversations = String.format("Select ID_conversations FROM conversations Where ID_user = \"%s\" and loginRecipient = \"%s\" ", idUser, loginRecipient);
		    ResultSet rs1 = objectSQLConnectionAl.query(checkIdConversations);
		    rs1.next();
		    idConversations = rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			String addMessage = String.format("INSERT INTO message (text, ID_conversations, date_time, status) VALUES (\"%s\", %d, '%04d-%02d-%02d %02d:%02d:%02d', \"%s\")", 
					message, idConversations, year,month+1,day, hour, minute, second, status);
			objectSQLConnectionAl.queryUpdate(addMessage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void readMessage(){
		String loginUser = objectMainScreen.getCurrentlyLogin();
		try {
			String checkUnreadMessage = String.format("select u.login, m.text, m.date_time "
					+ "from user as u, message as m, conversations as c "
					+ "where m.ID_conversations = c.ID_conversations AND c.ID_user = u.ID_user and c.loginRecipient = \"%s\" and m.status = \"N\"", loginUser);
			
		    ResultSet rs = objectSQLConnectionAl.query(checkUnreadMessage);
		    
		    System.out.format("%-20s%-100s%-25s",
		    	    "Sender login", "You unread messages", "Date and time message");
		   
		   while (rs.next()){
			   for (int i = 1; i <= 3; i++) {
				   if (i == 1){
					   String unreadMessage = rs.getString(i);
					   System.out.println("\n");
					   System.out.format("%-20s", unreadMessage);
				   }
				   else if (i == 2){
					   String unreadMessage = rs.getString(i);
					   System.out.format("%-100s", unreadMessage);
				   }
				   else if (i == 3){
					   String unreadMessage = rs.getString(i);
					   System.out.format("%-25s", unreadMessage);
				   } 
			   } 
		   }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean wrongChoice = true;
		do{
			System.out.println("\nWhat would you like to do?\n"
					+ "[1] MARK YOUR MESSAGE AS READ \n"
					+ "[2] GO OUT AND DON'T READ MESSAGE \n");
			
			Scanner reading = new Scanner(System.in);
			int choice = reading .nextInt();
			
			if (choice == 1){
				try {
				    String checkIdUser = String.format("select m.ID_message "
				    	+ "from user as u, message as m, conversations as c "
				    	+ "where m.ID_conversations = c.ID_conversations AND c.ID_user = u.ID_user and c.loginRecipient = \"%s\" and m.status = \"N\"", loginUser);
				    ResultSet rs = objectSQLConnectionAl.query(checkIdUser);
				    
				    while (rs.next()){
					    int idUnreadMessage = rs.getInt(1);
					    String addStatusY = String.format("update message "
					    		+ "set status = \"Y\" "
					    		+ "where ID_message = %d;", idUnreadMessage);
					   objectSQLConnectionAl.queryUpdate(addStatusY);
				    }
				} catch (SQLException e) {
					e.printStackTrace();
				}
				wrongChoice = false;
			}
			else if (choice == 2){
				whatDo();
				wrongChoice = false;
			}
			else{
				System.out.println("Your choice is wrong. Try again.");
				wrongChoice = true;
			}
		}
		while (wrongChoice == true);
	}
	
	public void history(){
		String loginUser = objectMainScreen.getCurrentlyLogin();
		try {
			String checkUnreadMessage = String.format("select u.login, m.text, m.date_time, m.status "
					+ "from user as u, message as m, conversations as c "
					+ "where m.ID_conversations = c.ID_conversations AND c.ID_user = u.ID_user and c.loginRecipient = \"%s\"", loginUser);
			
		    ResultSet rs = objectSQLConnectionAl.query(checkUnreadMessage);
		    
		    System.out.format("%-20s%-100s%-25s%-30s",
		    	    "Sender login", "You unread messages", "Date and time message", "If read = \"Y\" if don't read = \"N\"");
		   while (rs.next()){
			   for (int i = 1; i <= 4; i++) {
				   if (i == 1){
					   String unreadMessage = rs.getString(i);
					   System.out.println("\n");
					   System.out.format("%-20s", unreadMessage);
				   }
				   else if (i == 2){
					   String unreadMessage = rs.getString(i);
					   System.out.format("%-100s", unreadMessage);
				   }
				   else if (i == 3){
					   String unreadMessage = rs.getString(i);
					   System.out.format("%-25s", unreadMessage);
				   } 
				   else if (i == 4){
					   String unreadMessage = rs.getString(i);
					   System.out.format("%-30s", unreadMessage);
				   } 
			   } 
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void logOut(){
		objectChoiceWindow.window();
	}
	
	public void returnToTheMenu(){
		System.out.println("\nWhat would you like to do now?\n"
				+ "[1] RETURN TO THE MENU \n"
				+ "[2] LOG OUT \n");
		
		Scanner reading = new Scanner(System.in);
		int choice = reading .nextInt();
		boolean didntDo = true;
		
		do{
			try{
				if (choice == 1){
					whatDo();
					didntDo = false;
				}
				else if (choice == 2){
					objectChoiceWindow.window();
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
}

