
package chatbotProject;

public class ChatbotCarson {
	
	private String userName;
	private Topic Carson;
	private boolean chatting;
	
	public ChatbotCarson() {
		Carson = new ChatbotDavidLi();
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
	    	if(Carson.isTriggered(response)) {
	    		chatting = false;
	    		Carson.startChatting(response);
	    	}
	    	else
	    	{
	    		ChatbotMain.print("I'm sorry, I dont understand");
	    	}
	    	
	    }
		
	}

}
