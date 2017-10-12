package chatbotProject;

public class ChatbotCarson implements Topic{
	
	private String[] keywords;
	private String[] answers = {"The first step of the plan is to grab the keys off the guards belt when he walks over here", "After that unlock me from my cell", "Walk down the hallway and take the second right", "There will be a dead end Remove the bottom four stones from the wall From there we will take the tunnel I dug to the outside of the walls",  "Then we will steal one of the prison guards boats and row ourselves to freedom","I need to escape because I am innocent", "If we get caught then thats it for you and I They will likely hang us for attempting to escape"};
	private String [] rndQuestions = {"Would you like to hear the plan again", "Tell me what is the first step of the plan", "Tell me what is the second step of the plan", "Tell me, what is the third step of the plan", "Tell me so you dont forget, what is the fourth step of the plan"};
	private String [] endWords;
	private String secretWord;
	private int questionCount = 0;
	private int replyCount = 0;
	private boolean chatting;
	
	public ChatbotCarson() {
		String[] temp = {"escape","freedom","plan"};
		keywords = temp;
		String[] temp2 = {"done","bye","goodbye", "farewell"};
		endWords = temp2;
		secretWord = "apple";
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
		replyResponse();
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(questionCount <= 6) {
				replyResponse();
				questionCount++;
			}else {
				if(replyCount <= 6) {
					ChatbotMain.print("Enough about me Im going to ask you a few questions to make sure you were paying attention");
					askQuestions();
					replyCount++;
				}
			}
			for(int i = 0; i < endWords.length; i++) {
				if(ChatbotMain.findKeyWord(response.toLowerCase(), endWords[i], 0) >= 0) {
					chatting = false;
					ChatbotMain.print("Alright I will talk to you later I guess");
					ChatbotMain.chatbot.startTalking();
				}
			}
		}
	}
	
	public void stopRepetitions(String str1, String str2) {
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
			ChatbotMain.print("");
			numReps = 0;
		}
		lastResponse = response;
	}

	private void askQuestions() {
		String response = ChatbotMain.getInput();
		stopRepetitions("Sorry I think you just said that", "Please stop repeating yourself you are making a fool of yourself");
		String[] randQ = rndQuestions;
		 int questionChoice =  (int) (Math.random() * rndQuestions.length);
		  while(rndQuestions[questionChoice] == " ")
		  {
			  questionChoice = (int) (Math.random() * rndQuestions.length);
		  }
		 ChatbotMain.print(randQ[questionChoice]);
		 randQ[questionChoice] = " ";
		 
		 if(questionChoice == 0) {
			 if (response.toLowerCase().contains("yes")) {
				 ChatbotMain.print(answers[0] + " " + answers[2] + " " + answers[3] + " " + answers[4] + " " + answers[5] + " " + answers[6]);
			 }else {
				 ChatbotMain.print("Alright but if you forget we both suffer the consequences");
			 }
		 }else if(questionChoice == 1) {
			 if(response.toLowerCase().contains("keys") && response.toLowerCase().contains("guard")) {
				 ChatbotMain.print("Good Im glad you remembered");
			 }else {
				 ChatbotMain.print("Ok not that big of a deal but try to remember " + answers[0]);
			 }
		 }else if(questionChoice == 2) {
			 if(response.toLowerCase().contains("hallway") && response.toLowerCase().contains("second right")) {
				 ChatbotMain.print("Good This part is important don't forget it.");
			 }else {
				 ChatbotMain.print("If you make a wrong turn you could end up face to face with a guard");
			 }
		 }else if(questionChoice == 3) {
			 if(response.toLowerCase().contains("unlock")) {
			 	ChatbotMain.print("Good I'd have been very angry if you forgot this step");
		 	}else {
		 		ChatbotMain.print("Have you forgotten who made this plan");
		 	}
		}else if(questionChoice == 4) {
			if(response.toLowerCase().contains("boat")) {
				ChatbotMain.print("Ah yes the final step Once we step foot on that boat they will never be able to find us");
			}else {
				ChatbotMain.print("The roads near this prison are heavily infested with guards the boat is the safest way of travel");
			}
		}
	}
	
	private void nextStep() {
		String response = ChatbotMain.getInput();
		int stepCount = 0;
		if(ChatbotYonathan.decoder(response).toLowerCase().contains("next") && ChatbotYonathan.decoder(response).toLowerCase().contains("step") && stepCount < 5) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[stepCount + 1]));
			stepCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("previous") && response.toLowerCase().contains("step") && stepCount > 0) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[stepCount - 1]));
		}
		
	}
	
	private void replyResponse() {
		if(replyCount == 0) {
			ChatbotMain.print("Any questions about my escape plan");
		}else {
			ChatbotMain.print("Any other questions about our escape");
		}
		String response = ChatbotMain.getInput();
		
		if(response.toLowerCase().contains("how") && response.toLowerCase().contains("escape")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[0]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("first") || response.toLowerCase().contains("1st")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[0]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("second") || response.toLowerCase().contains("2nd")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[1]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("third") || response.toLowerCase().contains("3rd")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[2]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("fourth") || response.toLowerCase().contains("4th")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[3]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("fith") || response.toLowerCase().contains("5th")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[4]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("why") && response.toLowerCase().contains("escape")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[5]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("last") && response.toLowerCase().contains("escape")){
			ChatbotMain.print(ChatbotYonathan.encoder(answers[4]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("if") && response.toLowerCase().contains("caught")) {
			ChatbotMain.print(ChatbotYonathan.encoder(answers[6]));
			replyCount++;
		}else if(ChatbotYonathan.decoder(response).toLowerCase().contains("next") || response.toLowerCase().contains("previous")) {
			nextStep();
			replyCount++;
		}else {
			ChatbotMain.print("Sorry, im not sure I understand, try asking me about specific steps of the plan though." + "\n" + "You can also ask about previous or next steps of my plan.");
			replyResponse();
		}
		ChatbotMain.print("a" + replyCount);
	}
}