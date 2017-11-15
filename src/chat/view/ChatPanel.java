package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ChatPanel extends JPanel
{
	private JTextArea chatArea;
	private JTextField inputField;
	private JButton chatButton;
	private SpringLayout appLayout;
	private ChatbotController appController;
	private ImageIcon icon;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		chatButton = new JButton("Send It Boi");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(25);
		appLayout = new SpringLayout();
		icon = new ImageIcon(getClass().getResource("images/Chicken4U.png"));
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, 36, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -2, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 330, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 10, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 10, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(new Color(45, 185, 255));
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
