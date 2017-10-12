package chatbotProject;

import chatbotProject.Topic;
import chatbotProject.ChatbotMain;

public class ChatbotYonathan implements Topic {

	private String[] keywords = {"yes","yup","sure","y"};
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	public static final String[] alphabetsoup ={"0","1","00","01","10","11","000","001","010","011","100","101","110","111","0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011"," "};
	public static String alphabet ="abcdefghijklmnopqrstuvwxyz ";
	
	private Topic carson = new ChatbotCarson();
    private Topic david = new ChatbotDavidLi();
	public ChatbotYonathan() {
	
		
		goodbyeWord = "bye";
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyWord(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		
		ChatbotMain.print("prisoners are not allowed to talk so if you want to talk then you need to learn this code");
		ChatbotMain.print("a=0 b=1 c=00 d=01 e=10 f=11 g = 000 h= 001");
		ChatbotMain.print("i think i see a guard coming if you understand the code then send the word apple");
		//ChatbotMain.print(encoder("apple"));
		//ChatbotMain.print(decoder(encoder("apple")));
		//ChatbotMain.print(decoder("0 4 101 10 "));
		chatting = true;
		while(chatting) {
			//if(chatting) { ChatbotMain.print("true");}else {ChatbotMain.print("false");}
			response = decoder(ChatbotMain.getInput());
			if(response.equals("apple")) {
				ChatbotMain.print("there wasnt a guard but great job here is the entire code");
				ChatbotMain.print("a=0 b=1 c=00 d=01 e=10 f=11 g=000 h=001 i=010 j=011 k=100 l=101 m=110 n=111 o=0000 p=0001 q=0010 r=0011 s=0100 t=0101 u=0110 v=0111 w=1000 x=1001 y=1010 z=1011");
				ChatbotMain.print("from here on out we should only talk in code for saftey");
				ChatbotMain.print(encoder("do you want to talk about escape or do you have questions"));
				chatting = false;
			}else {
				if(!response.substring(0,1).equals("a")) {
					ChatbotMain.print("there wasnt a guard but you should learn the entire code send me apple again");
				}else {
					if(!response.substring(1,2).equals("p")) {
						ChatbotMain.print("there wasnt a guard but you should learn the entire code send me apple again p is 0001");
					}else {
						if(!response.substring(3,4).equals("l")) {
							ChatbotMain.print("there wasnt a guard but you should learn the entire code send me apple again l is 101");
						}
					}	
				}
			}
			
	    	//if(chatting) { ChatbotMain.print("true");}else {ChatbotMain.print("false");}
		}
		changeTopic();
	}
	public static String encoder(String in){
		int i = 0;
		String output ="";
		String input = in;
		input = input.toLowerCase();
		while(input.length()>i) {
			int index = alphabet.indexOf(input.charAt(i));
			if(index>=0) {
			output+= alphabetsoup[index] + " ";
			}else {
				System.err.println(input.charAt(i));
				output+= "?";
			}
			i++;
		}
		return output;
	}
	
	
	public static String decoder(String s){
		String word = ""; 
		int psn = 0;
		 int leftside = 0;
		while(psn<s.length()) {
			 
			  // makes a substring that is  checked against every item in alhabetsoup
			  
			  
				  if(s.substring(psn,psn+1).equals(" ")) {
						word += " ";
						psn++;
						leftside = psn;
						
					}else {
			  	if(psn == s.length()-1)
			  	{
			  		word+=converter(s.substring(leftside,psn+1));
			  		psn+=2;
			  		leftside = psn;
				  
			  	}
			  	else {
			  		if(s.substring(psn+1,psn+2).equals("0")||s.substring(psn+1,psn+2).equals("1"))
			  	{
			  		psn++;
				  
			  	}else {
			  		if(s.substring(psn+1,psn+2).equals(" "))
			  		{
			  			word+=converter(s.substring(leftside,psn+1));
				  		psn+=2;
				  		leftside = psn;
			  		}
			  	}
				}
			  }
		  
	       
	}  return word;
	}
	public static String converter(String letter) {
		String output = "";
		for(int o = 0;o<27;o++) {
			if(letter.equals(alphabetsoup[o])) {
				output+= alphabet.substring(o,o+1);
			}
		} return output; 
	}
	 private void changeTopic()
	 {
		 String response = ChatbotMain.getInput();
		 //ChatbotMain.print(ChatbotYonathan.decoder(response));
	    	if(isTriggered(decoder(response))) {
	    		
	    		ChatbotMain.print("Ok lets talk some more Ask me some questions");
	    	}
	    	else if(carson.isTriggered(decoder(response))) {
	    		chatting = false;
	    		carson.startChatting(decoder(response));
	    	}else if(david.isTriggered(decoder(response))) {
	    		chatting = false;
	    		david.startChatting(decoder(response));
	    	}
	    	else
	    	{
	    		ChatbotMain.print(ChatbotYonathan.encoder("I am sorry I dont understand maybe you could rephrase"));
	    	/*	String encoded = ChatbotYonathan.encoder("I am sorry I dont under stand maybe you could rephrase");
	    		ChatbotMain.print(encoded);
	    		ChatbotMain.print(ChatbotYonathan.decoder(encoded));
	    		*/
	    	}}
}