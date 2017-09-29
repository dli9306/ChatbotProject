package chatbotProject;

public class ChatbotYonathan {
	
	private String userName;
	private Topic Yonathan;
	private boolean chatting;
	
	public ChatbotYonathan() {
		Yonathan = new ChatbotDavidLi();
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
	    	if(Yonathan.isTriggered(response)) {
	    		chatting = false;
	    		Yonathan.startChatting(response);
	    	}
	    	else
	    	{
	    		ChatbotMain.print("I'm sorry, I dont understand");
	    	}
	    	
	    }
		
	}

}
