package chatbotProject;

public class ChatbotCarson implements Topic{
	
	private String[] keywords;
	private String[] answers= {"When the guard comes by your cell grab the keys off his belt, wait 2 minutes then unlock yourself", "I need to leave because I am innocent", "After that unlock me from my cell.", "Walk down the hallway and take the second right", "There will be a dead end Remove the bottom four stones from the wall From there we will take the tunnel to outside of the walls.", "Then we will steal one of the prison guard's boats and row ourselves to freedom"};
	private String [] replies = {"a", "b", "c", "d"};
	private String [] endWords;
	private String secretWord;
	private int questionCount = 0;
	private int replyCount = 0;
	private boolean chatting;
	
	public ChatbotCarson() {
		String[] temp = {"food","internet","games"};
		keywords = temp;
		String[] temp2 = {"done","bye","goodbye"};
		endWords = temp2;
		secretWord = "pug";
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyWord(response, keywords[i],0) > 0) {
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("So lets get started, what do you wish to know?");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(questionCount <= 5) {
				replyResponse();
				questionCount++;
			}else {
				if(replyCount <= 5) {
					ChatbotMain.print("Enough about me, I'm going to ask you a few questions now");
					askQuestions();
					replyCount++;
				}
			}
			for(int i = 0; i < endWords.length; i++) {
				if(ChatbotMain.findKeyWord(response, endWords[i], 0) >= 0) {
					chatting = false;
					ChatbotMain.chatbot.startTalking();
				}else if(ChatbotMain.findKeyWord(response, secretWord, 0) >= 0) {
					ChatbotMain.print("You guessed my favorite thing ever We are friends now!");	  
				}else {
					ChatbotMain.print("HUH, I don't really know how to answer that, can you rephrase?");
				}
			}
		}
	}

	private void askQuestions() {
		String response = ChatbotMain.getInput();
		int randResponse = (int) Math.random()*replies.length;
		ChatbotMain.print(replies[randResponse]);
	}

	private void replyResponse() {
		String response = ChatbotMain.getInput();
		  if(response.contains("how") && response.contains("escape")) {
			  ChatbotMain.print(answers[0]);
		  }else if(response.contains("why") && response.contains("escape")) {
			  ChatbotMain.print(answers[1]);
		  }else if(response.contains("")) {
			  ChatbotMain.print(answers[2]);
		  }
	}
}
