package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame 
{
	private ChatbotController appController;
//	private ChatPanel appPanel;
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
// 		appPanel = newChatPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(500,500);
		this.setTitle("Chatbot 2017");
//		this.setContentPane(appPlanel);
		this.setResizable(false);
		this.setVisible(true);
	}
}
