package chatbotProject;

public class ChatbotDavidLi implements Topic {
	
	private String[] keywords;
	private String goodbyeWords;
	private String secretWord;
	private boolean chatting;

	public ChatbotDavidLi() {
		String[] temp = {"food","interenet","video games"};
		keywords = temp;
		String temp2 = "bye";
		goodbyeWords = temp2;
		
		secretWord = "pug";
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i =0;i<keywords.length;i++)
		{
			if(ChatbotMain.findKeyWord(response, keywords[i],0) > 0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("Hey it sounds like you and I have common interest! Lets talk some more!");
		chatting = true;
		while(chatting) {
			 response = ChatbotMain.getInput();
			  if(ChatbotMain.findKeyWord(response, goodbyeWords, 0) >= 0) {
				  chatting = false;
				  ChatbotMain.chatbot.startTalking();
			  }else if(ChatbotMain.findKeyWord(response, secretWord, 0) >= 0) {
				  ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever We are friends now!");
				  
			  }
			  else {
				  ChatbotMain.print("HUH, I don't really get you. Tell me something else?");
			  }
		}
	}

}
