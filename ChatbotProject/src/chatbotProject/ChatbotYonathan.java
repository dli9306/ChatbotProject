package chatbotproject;

import chatbotproject.Topic;
import chatbotproject.chatbotmain;

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
			if(chatbotmain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		chatbotmain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
		chatting = true;
		while(chatting) {
			response = chatbotmain.getInput();
			if(chatbotmain.findKeyword(response, goodbyeWord, 	0) >= 0 ) {
				chatting = false;
				chatbotmain.chatbot.startTalking();
			}else if(chatbotmain.findKeyword(response, secretWord, 0) >= 0) {
				chatbotmain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now.");
			}else {
				chatbotmain.print("Huh. I don't really get you. Tell me something else?");
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
			for(int)
			output+= alphabet.charAt(index) + " ";
			i++;
		}
		return output;
	}
}