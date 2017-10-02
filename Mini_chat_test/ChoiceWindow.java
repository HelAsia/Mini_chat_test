package Mini_chat_test;

import java.util.Scanner;

public class ChoiceWindow {
	
	public void window (){

		MainScreen objectMainScreen = new MainScreen();
		AdministratorPanel objectAdministratorPanel = new AdministratorPanel (objectMainScreen);
		
		boolean loopEnd = true;
		
		System.out.println("\nWhat would you like to do?\n"
				+ "[1] REGISTER \n"
				+ "[2] LOG IN \n"
				+ "[3] ADMIN \n"
				+ "[4] EXIT \n");
		
		AfterLogIn objectAfterLogIn = new AfterLogIn(objectMainScreen) ;
		
		do{
			try{
				Scanner number = new Scanner(System.in);
				int userChoice = number.nextInt();

				if (userChoice == 1){
					objectMainScreen.register();
					objectAfterLogIn.whatDo();
					loopEnd = false;
				}
				else if (userChoice == 2){
					if (objectMainScreen.logIn()){
				
						String a = objectMainScreen.getCurrentlyLogin();
						String b = "";
						Boolean c = a.equals(b);
						if (c == false ){
							objectAfterLogIn.whatDo();
						}
						loopEnd = false;
					}
				}
				else if (userChoice == 3){
					objectAdministratorPanel.adminPanel();
					loopEnd = false;
				}
				else if (userChoice == 4){
					System.out.println("Your window will be close");
					loopEnd = false;
				}
				else{
					System.out.println("Your choice is wrong. Try again");
					loopEnd = true;
				}
			}
			catch (java.util.InputMismatchException e){
				System.out.println("Your value is wrong format. Try again");
			}
		}	
			while (loopEnd = true);
	}
}