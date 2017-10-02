package chatbotProject;

public class ChatbotDavidLi implements Topic {
	
	private String[] keywords;
	private String[] answers= {"I am the Duke of Turing, Nice to meet you!","We are located in a prison on a remote island on the coast of Europe.","I was framed for the murder of my wife"};
	private String [] replies = {"Ah, I see!","Tell me More","How interesting!","Continue with what you were saying"};
	private String [] randQuestions;
	private String [] endWords;
	private String secretWord;
	private int questionCount = 0;
	private int replyCount = 0;
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
				 response = ChatbotMain.getInput();
				 if(questionCount <=5) {
					 replyResponse();
					 questionCount++;
				 }
				 else
				 {
					 if(replyCount <=5)
					 {
					 ChatbotMain.print("But thats enough about me, I'm going to ask you a few questions now");
					 askQuestions();
					 replyCount++;
					 }
				 }
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
		 private void replyResponse() {
			String response = ChatbotMain.getInput();
			  if(response.contains("who are you")) {
				  ChatbotMain.print(answers[0]);
			  }
			  else if(response.contains("where")) {
				  ChatbotMain.print(answers[1]);
			  } 
			  else if(response.contains("why are you here")) {
				  ChatbotMain.print(answers[2]);
			  }
			  
			 
		 }
		 private void askQuestions() {
			 String response = ChatbotMain.getInput();
			  int randResponse = (int) Math.random()*replies.length;
			 ChatbotMain.print();
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
