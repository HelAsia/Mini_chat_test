package Mini_chat_test;

import java.util.Scanner;

public class AfterLogIn{
	
	Scanner reading = new Scanner(System.in);
	int choice = reading .nextInt();
	
	public void whatDo () {
		
	System.out.println("What would you like to do?\n"
			+ "[1] If you would like to WRITE TO SOMEONE. \n"
			+ "[2] If you would like to CHECK YOUR HISTORY. \n"
			+ "[3] If you would like to REFRESH MESSAGES. \n"
			+ "[4] If you would like to LOG OUT. \n");

	boolean falseOrTrue = true;
	
	do{
		try{
			Scanner number = new Scanner(System.in);
			int userChoice = number.nextInt();

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
		
		System.out.println("Enter yours friend's login");
		String loginRecipient = reading.nextLine();
		
		System.out.println("Enter your message.");
		String message = reading.nextLine();

	}
	
	public void history(){
		
	}
	
	public void refresh(){
		
	}
	
	public void logOut(){
		
	}
}