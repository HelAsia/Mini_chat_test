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
		System.out.println("What would you like to do?\n"
				+ "If you would like to REGISTER you have to entered: 1 \n"
				+ "If you would like to LOG IN you have to entered: 2 \n"
				+ "If you would like to EXIT you have to entered: 3");
		
		Scanner number = new Scanner(System.in);
		int userChoice = number.nextInt();
		int ONE = 1;
		int TWO = 2;
		int THREE = 3;
		
		if (userChoice == ONE){
			ms.register();
		}
		else if (userChoice == TWO){
			ms.logIn();
		}
		else if (userChoice ==THREE){
			number.close();
		}
		else{
			System.out.println("Your choice is wrong. Try again");
		}
	}
}