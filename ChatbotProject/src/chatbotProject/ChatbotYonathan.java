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
			output+= alphabetsoup[index] + " ";
			i++;
		}
		return output;
	}
	public static String decoder(String input) {
		int i = 0;
		String output ="";
		while(input.length()>i) {
			// find which index is equal to the first word of the code which will be marked by a space
			for(int o = 0;o<27;o++) {
				if() {
					
				}
			}
			output+= alphabet.charAt(index) + " ";
			i++;
		}
		return output;
	}// convert key word is isolated to method that finds words isolated by spaces or edges
	public static boolean wordIsIsolated(int psn, String keyword, String s){
		  boolean cLeft = false;
		  boolean cRight = false;
		  if(psn == 0)
		  {
			  cLeft = true;
		  }
		  else
		  {
			  if(s.substring(psn-1,psn).compareTo("a")<0)
			  {
				 cLeft = true;
			  }
		  }
		  if(psn+ keyword.length() == s.length())
		  {
			  cRight = true;
		  }
		  else if(s.substring(psn+keyword.length(),psn+keyword.length()+1).compareTo("a")<0)
		  {
			  cRight = true;
		  }
	         return cRight && cLeft;
	}
}