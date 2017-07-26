package Mini_chat_test;

public class Main {
	public static void main(String args[]){
		AfterLogIn test = new AfterLogIn();
		test.connection("jdbc:mysql://localhost:3306/mini_chat","root","");
	}
}
