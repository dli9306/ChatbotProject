package chatbotProject;

public class ChatbotCarson implements Topic{
	
	private String[] keywords;
	private String[] answers = {"When the guard comes by your cell grab the keys off his belt, wait 2 minutes then unlock yourself.", "I need to leave because I am innocent", "After that unlock me from my cell.", "Walk down the hallway and take the second right", "There will be a dead end. Remove the bottom four stones from the wall. From there we will take the tunnel to outside of the walls.", "Then we will steal one of the prison guard's boats and row ourselves to freedom."};
	private String [] rndQuestions = {"a?", "b?", "c?", "d?"};
	private String [] endWords;
	private String secretWord;
	private int questionCount = 0;
	private int replyCount = 0;
	private boolean chatting;
	
	public ChatbotCarson() {
		String[] temp = {"food","entertainment","Internet","video games"};
		keywords = temp;
		String[] temp2 = {"done","bye","goodbye"};
		endWords = temp2;
		secretWord = "escape";
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
					ChatbotMain.print("You guessed my favorite thing. We are friends now.");
					replyResponse();
				}else {
					ChatbotMain.print("HUH, I don't really know how to answer that, can you rephrase?");
				}
			}
		}
	}
	
	private void stopRepetitions(String str1, String str2) {
		int numReps = 0;
		String lastResponse = "";
		String response = ChatbotMain.getInput();
		
		if(response == lastResponse) {
			numReps++;
			if(numReps == 1) {
				ChatbotMain.print(str1);
			}else if(numReps > 1) {
				ChatbotMain.print(str2);
			}
		}else {
			numReps = 0;
		}
		lastResponse = response;
	}

	private void askQuestions() {
		stopRepetitions("Sorry I think you just said that.", "Please stop repeating yourself, you are making this conversation very boring.");
		String response = ChatbotMain.getInput();
		int randResponse = (int) Math.random()*rndQuestions.length;
		ChatbotMain.print(rndQuestions[randResponse]);
	}

	private void replyResponse() {
		ChatbotMain.print("Any questions about the escape plan?");
		String response = ChatbotMain.getInput();
		if(response.toLowerCase().contains("how") && response.toLowerCase().contains("escape")) {
			stopRepetitions("Are your nerves getting to you?", "Do I really need to repeat myself?");
			ChatbotMain.print(answers[0]);
		}else if(response.toLowerCase().contains("why") && response.toLowerCase().contains("escape")) {
			stopRepetitions();
			ChatbotMain.print(answers[1]);
		}else if(response.toLowerCase().contains("last") && response.toLowerCase().contains("escape")) {
			stopRepetitions();
			ChatbotMain.print(answers[4]);
		}
	}
}
