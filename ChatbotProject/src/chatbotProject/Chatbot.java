package chatbotProject;

public class Chatbot {

	private String userName;
	private Topic david;
	private Topic yonathan;
	private Topic carson;

	private boolean chatting;

	public Chatbot() {
		david = new ChatbotDavidLi();
		yonathan = new ChatbotYonathan(); // EDIT THIS WITH YOUR ACTUAL CLASS FILES WHEN YOU MAKE THEM
		carson = new ChatbotCarson();

		userName = "unknown user";
		chatting = true;
	}
	
	

	public String getUserName() {
		return userName;
	}



	public Topic getDavid() {
		return david;
	}



	public ChatbotYonathan getYonathan() {
		return (ChatbotYonathan) yonathan;
	}



	public Topic getCarson() {
		return carson;
	}



	public void startTalking() {
		ChatbotMain.print("hello are you awake whats your name");
		userName = ChatbotMain.getInput();
		ChatbotMain.print("ok " + userName + " if you want to talk when the guards are here then your going to have to learn this code" );
		ChatbotMain.print("0 = a 1 = b 00 = c 01 = d 10 = e 11 = f 000 = g 001 = h");
		ChatbotMain.print("i think i see a guard coming if you understand the code send me the word apple");
		chatting = true;
		while(chatting){
			ChatbotMain.print("What do you want to talk about " + userName);
			String response = ChatbotMain.getInput();
			if(david.isTriggered(response)) {
				chatting = false;
				david.startChatting(response);
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
				ChatbotMain.print("I'm sorry, I dont understand");
			}

		}

	}

}
