package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.*;

public class ChatbotController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Ya Boi Gingy");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	/*
	 * this creates the specifics for the small popup at the beginning
	 */
	public void start()
	{
		display.displayText("Welcome to Chatbot my dude!");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
	/*
	 * this creates the welcome message.
	 */
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	/*
	 * if the chatbot hears quit then it will quit.
	 */
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	/*
	 * this sends a message as the popup closes.
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays +=  chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	/*
	 * this creates the chatbot popup window.
	 */
	
}

