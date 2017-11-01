package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.*;

public class ChatbotController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Ya Boi Gingy");
		display = new PopupDisplay();
	}
	public void start()
	{
		String response = display.collectResponse("what do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}
	
	public String interactWithChatbot(String input)
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays +=  chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
}

