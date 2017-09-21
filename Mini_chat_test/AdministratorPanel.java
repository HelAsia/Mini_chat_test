package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdministratorPanel{
	private SQLConnection mainObjectClassSQLConnection = new SQLConnection();
	
	public void adminPanel(){
		
		Boolean goodAdminData;
		Boolean goodChoice;
			
		do {
		
			Scanner odczyt = new Scanner(System.in);
			
			System.out.println("Enter ADMIN'S login");
			String adminLogin = odczyt.nextLine();
			
			System.out.println("Enter ADMIN'S password");
			String adminPassword = odczyt.nextLine();
			
			String adminData = "admin";
			
			if (adminLogin.equals(adminData)){
				System.out.println("You are in Administrator Panel. What are You doing now?"
						+ "[1] PRINT ALL USERS"
						+ "[2] REMOVE SOME USER"
						+ "[3] EDIT SOME USER"
						+ "[4] BLOCK SOME USER");
				goodAdminData = true;
				
				do{
					try{
						Scanner number = new Scanner(System.in);
						int userChoice = number.nextInt();
	
						if (userChoice == 1){
							
							goodChoice = false;
						}
						else if (userChoice == 2){
							
								goodChoice = false;
						}
						else if (userChoice == 3){
							
							goodChoice = false;
						}
						else if (userChoice == 4){
							
							goodChoice = false;
						}
						else{
							System.out.println("Your choice is wrong. Try again");
							goodChoice = true;
						}
					}
					catch (java.util.InputMismatchException e){
						System.out.println("Your value is wrong format. Try again");
					}
				}	
					while (goodChoice = true);
			} else {
				System.out.println("Sorry, Your login or password is wrong. You can't log in as ADMIN. Try again");
				goodAdminData = false;
			}
			
		} while (goodAdminData == false);	
	}
		
public void print(){
	
}	
	
public void remove(){
	
}		
	
public void edit(){
	
}		
	
public void block(){
	
}		
	
	
	
}