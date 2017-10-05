package chatbotProject;

import chatbotProject.Topic;
import chatbotProject.ChatbotMain;

public class ChatbotYonathan implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	public static final String[] alphabetsoup ={"0","1","00","01","10","11","000","001","010","011","100","101","110","111","0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011"," "};
	public static String alphabet ="abcdefghijklmnopqrstuvwxyz ";
	
	public ChatbotYonathan() {
		String[] temp = {"food","entertainment","Internet","video games"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "pug";
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
		ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyWord(response, goodbyeWord, 	0) >= 0 ) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else if(ChatbotMain.findKeyWord(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now.");
			}else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
			}
		}
	}
	public static String encoder(String input){
		int i = 0;
		String output ="";
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
}