package Mini_chat_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdministratorPanel{
	private SQLConnection mainObjectClassSQLConnection = new SQLConnection();
	
	public void adminPanel(){
		
		boolean goodAdminData;
		boolean wrongChoice;
			
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
						+ "[4] BLOCK SOME USER \n"
						+ "[5] UNBLOCK SOME USER \n"
						+ "[6] PRINT LIST BLOCKED \n");
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
						else if (userChoice == 5){
							unblock();
							wrongChoice = false;
						}
						else if (userChoice == 6){
							listblocked();
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
		System.out.println("Who would you like to remove? \n");
		print();
		
		Scanner odczyt = new Scanner(System.in);
		String loginToRemove = odczyt.nextLine();
		
		String query = String.format("delete from user where login = \"%s\"", loginToRemove);
		try {
			mainObjectClassSQLConnection.queryUpdate(query);
			System.out.printf("This login: %s has been deleted. \n", loginToRemove);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}		
		
	public void edit(){
		boolean goodLogin = false;
		do{
			System.out.println("Who would you like to edit? \n");
			print();
			System.out.println("\nWrite login. \n");
			Scanner odczyt = new Scanner(System.in);
			String howUser = odczyt.nextLine();
			
			String queryCheck = String.format("Select login from user WHERE login = \"%s\";", howUser);
			try {
				ResultSet rs = mainObjectClassSQLConnection.query(queryCheck);
				int count = 0;
				while (rs.next()) {
					++count;
				}
				if (count == 0) {
					System.out.println("This login doesn't exist. You have to check it and try again.");
					goodLogin = false;
				}
				else{
					goodLogin = true;
					boolean goodChoiceEdit;
					do {
						System.out.println("What would you like to edit? \n"
								+ "[1] LOGIN \n"
								+ "[2] PASSWORD \n");
						Scanner odczyt1 = new Scanner(System.in);
						int whatEdit = odczyt1.nextInt();
						if (whatEdit == 1){
							System.out.println("What is a new login for this user? \n");
							//odczyt.next();
							Scanner odczyt3 = new Scanner(System.in);
							String newLogin = odczyt3.nextLine();
							String editLogin = String.format("Update user set login = \"%s\" where login = \"%s\";", newLogin, howUser );
							mainObjectClassSQLConnection.queryUpdate(editLogin);
							System.out.println("Login has been changed");
							goodChoiceEdit = true;
							
						}else if (whatEdit == 2){
							System.out.println("What is a new password for this user? \n");
							String newPassword = odczyt.nextLine();
							String editPassword = String.format("Update user set password = \"%s\" where login = \"%s\";", newPassword, howUser);
							mainObjectClassSQLConnection.queryUpdate(editPassword);
							System.out.println("Password has been changed");
							goodChoiceEdit = true;
						}
						else {
							System.out.println("Your choice is wrong. You have to check it and try again.");
							goodChoiceEdit = false;
						}
					}while(goodChoiceEdit == false);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}	
			
		} while (goodLogin == false);
	}		
		
	public void block(){
		System.out.println("What login would you like to block? \n");
		print();
		Scanner odczyt = new Scanner(System.in);
		String blockLogin = odczyt.nextLine();
		String queryBlock = String.format("Update user set ifBlocked = 1 where login = \"%s\";", blockLogin);
		try {
			mainObjectClassSQLConnection.queryUpdate(queryBlock);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("This login is blocked now");
	}		
		
	public void unblock(){	
		System.out.println("What login would you like to unblock? \n");
		print();
		Scanner odczyt = new Scanner(System.in);
		String unblockLogin = odczyt.nextLine();
		String queryUnblock = String.format("Update user set ifBlocked = 0 where login = \"%s\";", unblockLogin);
		try {
			mainObjectClassSQLConnection.queryUpdate(queryUnblock);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("This login is unblocked now");
	}
	
	public void listblocked(){	
		String columnName = "Blocked Logins users: \n";
		try {
			ResultSet rs = mainObjectClassSQLConnection.query("Select login from user where ifBlocked = 1;");
			System.out.println(columnName);
			while (rs.next()){
				String allBlockedUser = rs.getString(1);
				System.out.println(allBlockedUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}