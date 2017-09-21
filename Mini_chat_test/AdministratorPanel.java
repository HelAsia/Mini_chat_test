package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdministratorPanel{
	private SQLConnection mainObjectClassSQLConnection = new SQLConnection();
	
	public void adminPanel(){
		
		Boolean goodAdminData;
		Boolean wrongChoice;
			
		do {
		
			Scanner odczyt = new Scanner(System.in);
			
			System.out.println("Enter ADMIN'S login");
			String adminLogin = odczyt.nextLine();
			
			System.out.println("Enter ADMIN'S password");
			String adminPassword = odczyt.nextLine();
			
			String adminData = "admin";
			
			if (adminLogin.equals(adminData)){
				System.out.println("You are in Administrator Panel. What are You doing now? \n"
						+ "[1] PRINT ALL USERS \n"
						+ "[2] REMOVE SOME USER \n"
						+ "[3] EDIT SOME USER \n"
						+ "[4] BLOCK SOME USER \n");
				goodAdminData = true;
				
				do{
					try{
						Scanner number = new Scanner(System.in);
						int userChoice = number.nextInt();
	
						if (userChoice == 1){
							print();
							wrongChoice = false;
						}
						else if (userChoice == 2){
							remove();
							wrongChoice = false;
						}
						else if (userChoice == 3){
							edit();
							wrongChoice = false;
						}
						else if (userChoice == 4){
							block();
							wrongChoice = false;
						}
						else{
							System.out.println("Your choice is wrong. Try again");
							wrongChoice = true;
						}
					}
					catch (java.util.InputMismatchException e){
						System.out.println("Your value is wrong format. Try again");
					}
				}	
					while (wrongChoice = true);
			} else {
				System.out.println("Sorry, Your login or password is wrong. You can't log in as ADMIN. Try again");
				goodAdminData = false;
			}
			
		} while (goodAdminData == false);	
	}
		
public void print(){
	String columnName = "Logins users: \n";
	try {
		ResultSet rs = mainObjectClassSQLConnection.query("Select login from user;");
		System.out.println(columnName);
		while (rs.next()){
			String allUser = rs.getString(1);
			System.out.println(allUser);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}	
	
public void remove(){
	
}		
	
public void edit(){
	
}		
	
public void block(){
	
}		
	
	
	
}