package chatbotProject;

public class Chatbot {
	
	private String userName;
	private Topic david;
	private Topic yonathan;
	private Topic carson;
	
	private boolean chatting;
	
	public Chatbot() {
		david = new ChatbotDavidLi();
	  yonathan = new ChatbotYonathan(); // EDIT THIS WITH YOUR ACTUAL CLASS FILES WHEN YOU MAKE THEM
		carson = new ChatbotCarson();
		
		userName = "unknown user";
		chatting = true;
	}

	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! what is your name?");
		userName = ChatbotMain.getInput();
		chatting = true;
	    while(chatting){
	    	ChatbotMain.print("What do you want to talk about");
	    	String response = ChatbotMain.getInput();
	    	if(david.isTriggered(response)) {
	    		chatting = false;
	    		david.startChatting(response);
	    	}
	    else if(yonathan.isTriggered(response)) {
	    		chatting = false;
	    		yonathan.startChatting(response);
	    		
	    	}
	    	else if(carson.isTriggered(response)) {
	    		chatting = false;
	    		yonathan.startChatting(response);
	    	}
	    	else
	    	{
	    		ChatbotMain.print("I'm sorry, I dont understand");
	    	}
	    	
	    }
		
	}

}
