package Mini_chat_test;

public class MainScreen{
	public SQLConnection sqlConn;
	
	public MainScreen (String query){
		query = "show tables";
		sqlConn.connection(query);
		
		
	}
	

}