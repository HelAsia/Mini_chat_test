package Mini_chat_test;

import java.util.Scanner;

public class ChoiceWindow {
	
	public enum Choices {
		ONE,
		TWO,
		THREE;
	}
	
	private MainScreen ms = new MainScreen();	
	
	public void window (){

		
		boolean trueOrFalse = true;
		
		System.out.println("What would you like to do?\n"
				+ "[1] If you would like to REGISTER. \n"
				+ "[2] If you would like to LOG IN. \n"
				+ "[3] If you would like to EXIT. \n");
		
		do{
			try{
				Scanner number = new Scanner(System.in);
				int userChoice = number.nextInt();
				int ONE = 1;
				int TWO = 2;
				int THREE = 3;
				
				if (userChoice == ONE){
					ms.register();
					trueOrFalse = false;
				}
				else if (userChoice == TWO){
					ms.logIn();
					trueOrFalse = false;
				}
				else if (userChoice ==THREE){
					System.out.println("Your window will be close");
					trueOrFalse = false;
				}
				else{
					System.out.println("Your choice is wrong. Try again");
					trueOrFalse = true;
				}
			}
			catch (java.util.InputMismatchException e){
				System.out.println("Your value is wrong format. Try again");
			}
		}	
			while (trueOrFalse = true);
	}
}