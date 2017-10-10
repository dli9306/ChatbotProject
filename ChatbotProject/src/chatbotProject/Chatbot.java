package chatbotProject;

public class Chatbot {

	private static String userName;
	private Topic david;
	private Topic yonathan;
	private Topic carson;

	private boolean chatting;

	public Chatbot() {
		david = new ChatbotDavidLi();
		yonathan = new ChatbotYonathan(); // EDI T THIS WITH YOUR ACTUAL CLASS FILES WHEN YOU MAKE THEM
		carson = new ChatbotCarson();

		userName = "unknown user";
		chatting = true;
	}
	
	

	public static String getUserName() {
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
		
		
		chatting = true;
		while(chatting){
			ChatbotMain.print("ok " + userName + " if you want to talk say yes");
			String response = ChatbotMain.getInput().toLowerCase();
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
