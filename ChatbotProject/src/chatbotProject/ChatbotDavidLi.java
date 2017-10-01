package chatbotProject;

public class ChatbotDavidLi implements Topic {
	
	private String[] keywords;
	private String[] answers= {"I am the Duke of Turing, Nice to meet you!","We are located in a prison on a remote island on the coast of Europe."};
	private String [] replies = {"Ah, I see!","Tell me More","How interesting!","Continue with what you were saying","I was framed for the murder of my wife"};
	private String [] endWords;
	private String secretWord;
	private boolean chatting;

	public ChatbotDavidLi() {
		String[] temp = {"food","interenet","video games"};
		keywords = temp;
		String[] temp2 = {"done","bye","goodbye","cya"};
		endWords = temp2;
		
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
		ChatbotMain.print("So lets get started, what do you wish to know?");
		chatting = true;
		 while(chatting) {
			 while(chatting) {
				 response = ChatbotMain.getInput();
				 replyResponse();
				  for(int i =0;i<endWords.length;i++) {
					  if(ChatbotMain.findKeyWord(response, endWords[i], 0) >= 0) {
					  chatting = false;
					  ChatbotMain.chatbot.startTalking();
				  }else if(ChatbotMain.findKeyWord(response, secretWord, 0) >= 0) {
					  ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever We are friends now!");
					  
				  }
				  else {
					  ChatbotMain.print("HUH, I don't really know how to answer that, can you rephrase?");
				  }
				  }
		 }
	}
	}
		 private void replyResponse() {
			String response = ChatbotMain.getInput();
			  if(response.contains("who are")) {
				  ChatbotMain.print(answers[0]);
			  }
			  else if(response.contains("where are")) {
				  ChatbotMain.print(answers[1]);
			  } 
			  else if(response.contains("why are")) {
				  ChatbotMain.print(answers[2]);
			  }
			  
			 
		 }

/*	public void startChatting(String response) {
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
	} */

}
