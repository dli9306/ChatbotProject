package chatbotProject;

public class ChatbotDavidLi implements Topic {
	
	private String[] keywords;
	private String[] answers= {"I am the Duke of Turing Nice to meet you","We are located in a prison on the coast of Europe.","I was framed for the murder of my wife","Guards broken into my house and immeditaely captured me","500 days","Fine at the moment","I previously lived in France"};
	private String [] replies = {"Ah  I see","How interesting","Hmmmmmm","Ok","Oh really"};
	private String [] randQuestions = {"So how did you get here","What happened to you","How do you feel","Do you have family around","What did you do before you were sent here?","What do you think of this place so far"};
	private String [] sadWords = {"bad","terrible","awful","sad","sadly"};
	private String [] happyWords = {"good","great","fine","okay","happily","fun","aweseome"};
	private String [] sadReplies = {"Sad to hear","Sorry to hear that"};
	private String [] happyReplies = {"Good to hear","That is great"};
	private String [] insultWords = {"terrible","stupid","horrible","disgusting","bad","terrifying","awful"};
	private String [] insultReplies = {"WHAT DO YOU MEAN I WAS","WHY WOULD YOU SAY I WAS"};
	private String [] endWords;
	private String insultW; //word used by user that insulted chatbot
	private int questionCount = 0;
	private int replyCount = -1;
	private boolean chatting;
	private boolean insulted; //if chatbot was insulted
	private Topic carson = new ChatbotCarson();
    private Topic yonathan = new ChatbotYonathan();
    // 1 1010 10 means bye
    //

	public ChatbotDavidLi() {
		String[] temp = {"question","questions","ask","f"};
		keywords = temp;
		String[] temp2 = {"done","bye","goodbye","cya"};
		endWords = temp2;
		
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i =0;i<keywords.length;i++)
		{
			if(ChatbotMain.findKeyWord(response, keywords[i],0) >= 0)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("So lets get started what do you want to ask");
		String encoded = ChatbotYonathan.encoder("So lets get started what do you want to ask");
		ChatbotMain.print(encoded);
		ChatbotMain.print(ChatbotYonathan.decoder(encoded));
		chatting = true;
		 while(chatting) {
				 response = ChatbotMain.getInput();
				 if(checkBye(response)) {
				 convoResponse(response);
				 convoQuestion(response);
				 }
				/* for(int i =0;i<endWords.length;i++) 
				  {
					  if(ChatbotMain.findKeyWord(ChatbotYonathan.decoder(response), endWords[i], 0) >= 0) {
					  chatting = false;
					  ChatbotMain.print(ChatbotYonathan.encoder("Alright I will talk to you later I guess"));
					  ChatbotMain.chatbot.startTalking();
					  }   

				  
				 }
				 */
		 	}
		 }
	
	private boolean checkBye(String response) {
		  for(int i =0;i<endWords.length;i++) 
		  {
			  if(ChatbotMain.findKeyWord(ChatbotYonathan.decoder(response), endWords[i], 0) >= 0) {
			  chatting = false;
			  ChatbotMain.print(ChatbotYonathan.encoder("Alright I will talk to you later I guess"));
			  ChatbotMain.chatbot.startTalking();
			  return false;
			  }   
        
		  
		 }
		  return true;

	}
	private void convoResponse(String response)
	{
		//keep track of amount of questions asked by users
		 if(questionCount <5) {
			 questionCount++;
			 replyResponse(response);
			 System.out.println(questionCount);
		 }
		 if(questionCount == 5)
		 {
			    System.out.println(ChatbotYonathan.encoder("But thats enough about me I am going to ask you a few questions now"));
			    questionCount++;
			    replyCount++;
		  }
	}

	
	private void convoQuestion(String response)
	{
		//keeps track of questions asked by chatbot
	    if(replyCount == 0)
        {
      	   askQuestions();
             replyCount++;
             System.out.println(replyCount);
        }
      else {
 
      	  if(replyCount > 0 && replyCount <5)
      	    {
      		  replyResponse2(response);
      		  askQuestions();
      		  replyCount++;
      		  System.out.println(replyCount);
      	    }
      	  else { 
      		  	 if(replyCount == 5)
      		  	 {
      		  		ChatbotMain.print(ChatbotYonathan.encoder("Ok  seems we have talked for quite a bit now  So what do you think of me so far"));
      		  		replyCount++;
      		  	 }
      		  	 else
      		  	 {
      		  		if(replyCount >5)
      		  		{
      		  		replyResponse3(response);
      		  			changeTopic();
      		  		}
      		  	 }
          	  }	
         }
	}


		private void replyResponse(String response) {
			//response to User's questions
			  if(response.toLowerCase().contains("who")) {
				  ChatbotMain.print(answers[0]);
			  }
			  else if(ChatbotYonathan.decoder(response).contains("where")) {
				  ChatbotMain.print(answers[1]);
			  } else if(response.toLowerCase().contains("why") && response.toLowerCase().contains("here")) {
				  ChatbotMain.print(answers[2]);
			  }else if(response.toLowerCase().contains("how") && response.toLowerCase().contains("caught") || response.toLowerCase().contains("what") && response.toLowerCase().contains("happened"))
			  {	  ChatbotMain.print(answers[3]);
			  }else if(response.toLowerCase().contains("how") && response.toLowerCase().contains("long")){
			    ChatbotMain.print(answers[4]);
			  }else if(response.toLowerCase().contains("feel")){
			    ChatbotMain.print(answers[5]);
			  }else if(response.toLowerCase().contains("where") && response.toLowerCase().contains("live") ) {
	            ChatbotMain.print(answers[6]);
			  }else {
				ChatbotMain.print(ChatbotYonathan.encoder("I am afraid I cannot answer that nor can I understand it You can ask another question if you would like"));
			  }
			  
			 
		 }
		 private void replyResponse2(String response) {
			 //chatbot's response to user's questions
			 int randReplies =  (int) (Math.random() * replies.length + 0);
			 int randNumber = (int) (Math.random()*2 +0);
			 boolean notSad = true;
			 boolean notHappy = true;
			 for(int i =0;i<sadWords.length;i++)
			 {
				 if(ChatbotMain.findKeyWord(response.toLowerCase(), sadWords[i], 0) >= 0) {
					 ChatbotMain.print(sadReplies[randNumber]);
					 notSad = false;
				 }
				 if(ChatbotMain.findKeyWord(response.toLowerCase(), happyWords[i], 0) >= 0) {
					 ChatbotMain.print(happyReplies[randNumber]);
					 notHappy = false;
				 }
			 }
			 if(notSad && notHappy) {
			 ChatbotMain.print(replies[randReplies]);
			 }
		
	       }
		 private void replyResponse3(String response) {
			 //chatbot's response to what user thinks of him
			 insulted = false;
			 int randReplies =  (int) (Math.random() * insultReplies.length + 0);
			 int randNumber2 = (int)(Math.random()*2+0);
			 for(int i =0;i<insultWords.length;i++)
			 {
				 if(ChatbotMain.findKeyWord(response.toLowerCase(), insultWords[i], 0) >= 0) {
					 ChatbotMain.print(insultReplies[randReplies] + " " +insultWords[i].toUpperCase() + " You do realize that I am the only one you can talk to RIGHT");
					 insultW = insultWords[i];
					 insulted = true; //chatbot is insulted
				 }
				 else {
				 if(ChatbotMain.findKeyWord(response.toLowerCase(), happyWords[i], 0) >= 0) {
					 ChatbotMain.print(happyReplies[randNumber2]);
					 
				 }
				 }
			 }
			 
			 
		 }
		
		 private void askQuestions(){
			 //random generator for questions for chatbot to ask
			 String[] randQ = randQuestions;
			 int randQues =  (int) (Math.random() * randQuestions.length + 0);
			  while(randQuestions[randQues] == " ")
			  {
				 randQues =  (int) (Math.random() * randQuestions.length + 0);
			  }
			 ChatbotMain.print(randQ[randQues]);
			 randQ[randQues] = " ";

		 }

		 private void changeTopic()
		 {
			/* Topic david = ChatbotMain.chatbot.getDavid();
			 if(david.isTriggered(response)) {
					chatting = false;
					david.startChatting(response);
				}
         */ // how to access another person's code
			 //changes topic at the end of the conversation
			 if(insulted) {
				 ChatbotMain.print("Whatever who cares if you think I'm " + insultW + ", you are a nobody Does your little brain want to redo the code lesson or do you want to escape already? Not that I care");
			 }
			 else
			 {
			    ChatbotMain.print("Do you want to be reminded on the code or do you want to escape this hole we're in? OR you just like me so much that you want to talk more for a bit?");
			 }
			 String response = ChatbotMain.getInput();
		    	if(isTriggered(response)) {
		    		questionCount = 0;
		    		replyCount = -2;
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
