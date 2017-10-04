package chatbotProject;

public class ChatbotDavidLi implements Topic {
	
	private String[] keywords;
	private String[] answers= {"I am the Duke of Turing, Nice to meet you!","We are located in a prison on the coast of Europe.","I was framed for the murder of my wife","Guards broken into my house and immeditaely captured me","500 days","Fine at the moment","I previously livedi in France"};
	private String [] replies = {"Ah, I see!","How interesting!","Hmmmmmm...","Ok","Oh really?"};
	private String [] randQuestions = {"So how did you get here?","What happened to you?","How do you feel?","Do you have family around?","What did you do before you were sent here?","What do you think of this place so far?"};
	private String [] sadWords = {"bad","terrible","awful","sad"};
	private String [] happyWords = {"good","great","fine","okay"};
	private String [] sadReplies = {"Sad to hear","Sorry to hear that"};
	private String [] happyReplies = {"Good to here","Good for you!"};
	private String [] endWords;
	private int questionCount = 0;
	private int replyCount = -1;
	private boolean chatting;
	private Topic carson = new ChatbotCarson();
    private Topic yonathan = new ChatbotYonathan();
    public static final String[] alphabetsoup ={"0","1","00","01","10","11","000","001","010","011","100","101","110","111","0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011"," "};
	public static String alphabet ="abcdefghijklmnopqrstuvwxyz ";
    

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
		chatting = true;
		 while(chatting) {
				 response = ChatbotMain.getInput();
				 if(questionCount <5) {
					 questionCount++;
					 replyResponse(response);
					 System.out.println(questionCount);
				 }
				 if(questionCount == 5)
				 {
					    System.out.println("But thats enough about me, I'm going to ask you a few questions now");
					    questionCount++;
					    replyCount++;
				  }
                  if(replyCount == 0)
                  {
                	   askQuestions();
                       replyCount++;
                       System.out.println(replyCount);
                  }
                  else {
           
                	  if(replyCount > 0 && replyCount <5) {
                		  replyResponse2(response);
                		  askQuestions();
                		  replyCount++;
                		  System.out.println(replyCount);
                	   }
                	  else { 
                		  	 if(replyCount == 5)
                		  	 {
                		  		ChatbotMain.print("Ok, seems we have talked for quite a bit");
                		  		changeTopic();
                		  		replyCount++;
                		  	 }
                    		}	
                   }

				  for(int i =0;i<endWords.length;i++) 
				  {
					  if(ChatbotMain.findKeyWord(response.toLowerCase(), endWords[i], 0) >= 0) {
					  chatting = false;
					  ChatbotMain.print("Alright,I'll talk to you later I guess");
					  ChatbotMain.chatbot.startTalking();
					  }   

				  
				 }
		 	}
		 }

	
	

		 private void replyResponse2(String response) {
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

		private void replyResponse(String response) {
			  if(response.toLowerCase().contains("who")) {
				  ChatbotMain.print(answers[0]);
			  }
			  else if(response.toLowerCase().contains("where")) {
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
				ChatbotMain.print("I'm afraid I can't answer that nor can I understand it,You can ask another question if you'd like");
			  }
			  
			 
		 }
		
		 private void askQuestions(){
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
			 ChatbotMain.print("Do you want to be reminded on the code or do you want to escape this hole we're in? OR you just like me so much that you want to talk more for a bit?");
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
			public static String encoder(String input){
				int i = 0;
				String output ="";
				while(input.length()>i) {
					int index = alphabet.indexOf(input.toLowerCase().charAt(i));
					output+= alphabetsoup[index] + " ";
					i++;
				}
				return output;
			}

}
