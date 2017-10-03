package chatbotProject;

public class ChatbotDavidLi implements Topic {
	
	private String[] keywords;
	private String[] answers= {"I am the Duke of Turing, Nice to meet you!","We are located in a prison on a remote island on the coast of Europe.","I was framed for the murder of my wife","Guards broken into my house and immeditaely captured me","500 days","Fine at the moment"};
	private String [] replies = {"Ah, I see!","Tell me more","How interesting!","Continue with what you were saying"};
	private String [] randQuestions = {"So how did you get here?","What happened to you?","How do you feel?","Do you have family around?","What did you do before you were sent here?","What do you think of this place so far?"};
	private String [] endWords;
	private String secretWord;
	private int questionCount = 0;
	private boolean chatting;
	private Topic carson = new ChatbotCarson();
    private Topic yonathan = new ChatbotYonathan();
    

	public ChatbotDavidLi() {
		String[] temp = {"question","questions"};
		keywords = temp;
		String[] temp2 = {"done","bye","goodbye","cya"};
		endWords = temp2;
		
		secretWord = "pineapplez";
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
				 if(questionCount <5) {
					 questionCount++;
					 replyResponse(response);
					 System.out.println(questionCount);
				 }
				 else
				 {
					if(questionCount == 5) {
					    System.out.println("But thats enough about me, I'm going to ask you a few questions now");
					    questionCount++;
					 }
					else {
					 if(questionCount >5 && questionCount < 10)
					 {
					 askQuestions();
					  questionCount++;
					 }
					}
				 }
				 if(questionCount == 10)
				 {
					 ChatbotMain.print("Ok, seems we have talked enough for today, unless you want to know more about me but lets get on to another topic!");
					 changeTopic();
				 }
				  for(int i =0;i<endWords.length;i++) {
					  if(ChatbotMain.findKeyWord(response, endWords[i], 0) >= 0) {
					  chatting = false;
					  ChatbotMain.print("Alright,I'll talk to you later I guess");
					  ChatbotMain.chatbot.startTalking();
				  }   
				   if(ChatbotMain.findKeyWord(response, secretWord, 0) >= 0) 
				   {
					  ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever We are friends now!");
					  
				    }

				  }

	}
	}
		 private void replyResponse(String response) {
			  if(response.toLowerCase().contains("who")) {
				  ChatbotMain.print(answers[0]);
			  }
			  else if(response.toLowerCase().contains("where")) {
				  ChatbotMain.print(answers[1]);
			  } 
			  else if(response.toLowerCase().contains("why") && response.toLowerCase().contains("here")) {
				  ChatbotMain.print(answers[2]);
			  }
			  else if(response.toLowerCase().contains("how") && response.toLowerCase().contains("caught"))
			  {
				  ChatbotMain.print(answers[3]);
			  }
			  else if(response.toLowerCase().contains("how") && response.toLowerCase().contains("long"))
			  {
				  ChatbotMain.print(answers[4]);
			  }
			  else if(response.toLowerCase().contains("feel"))
			  {
				  ChatbotMain.print(answers[5]);
			  }
			  else
			  {
				  ChatbotMain.print("I'm afraid I can't answer that nor can I understand it,You can ask another question if you'd like");
			  }
			  
			 
		 }
		 private void askQuestions() {
			 String response = ChatbotMain.getInput();
			  int randQues =  (int) (Math.random() * randQuestions.length + 0);
			 ChatbotMain.print(randQuestions[randQues]);

		 }
		 private void randReplies()
		 {
			 int randReplies =  (int) (Math.random() * replies.length + 0);
			 ChatbotMain.print(replies[randReplies]);
		 }
		 private void changeTopic()
		 {
			 ChatbotMain.print("So do you want to learn/talk more in code, or do you want to escape this hole we're in? OR you just like me so much that you want to talk more for a bit?");
			 String response = ChatbotMain.getInput();
		    	if(isTriggered(response)) {
		    		questionCount = 0;
		    		ChatbotMain.print("Ok lets talk some more");
		    	}
		    	else if(yonathan.isTriggered(response)) {
		    		chatting = false;
		    		yonathan.startChatting(response);
		    		
		    	} 
		    	else if(carson.isTriggered(response)) {
		    		chatting = false;
		    		carson.startChatting(response);
		    	}
		    	else
		    	{
		    		ChatbotMain.print("I'm sorry, I dont understand ,maybe you could rephrase?");
		    	}
		    	
		 }

}
