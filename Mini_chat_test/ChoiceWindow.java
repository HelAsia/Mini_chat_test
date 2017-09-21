package Mini_chat_test;

import java.util.Scanner;

public class ChoiceWindow {
	

	private MainScreen mainObjectClassMainScreen = new MainScreen(); // ma polaczenie	
	private AdministratorPanel mainObjectAdministratorPanel = new AdministratorPanel ();
	
	public void window (){

		boolean loopEnd = true;
		
		System.out.println("\nWhat would you like to do?\n"
				+ "[1] REGISTER \n"
				+ "[2] LOG IN \n"
				+ "[3] ADMIN \n"
				+ "[4] EXIT \n");
		
		AfterLogIn ali = new AfterLogIn(mainObjectClassMainScreen) ;
		
		do{
			try{
				Scanner number = new Scanner(System.in);
				int userChoice = number.nextInt();

				if (userChoice == 1){
					mainObjectClassMainScreen.register();
					ali.whatDo();
					loopEnd = false;
				}
				else if (userChoice == 2){
					if (mainObjectClassMainScreen.logIn()){
				
						String a = mainObjectClassMainScreen.getCurrentlyLogin();
						String b = "";
						Boolean c = a.equals(b);
						if (c == false ){
							ali.whatDo();
						}
						loopEnd = false;
					}
				}
				else if (userChoice == 3){
					mainObjectAdministratorPanel.adminPanel();
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