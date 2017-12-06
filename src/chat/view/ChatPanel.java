package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import chat.view.images;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import java.awt.event.KeyEvent;
public class ChatPanel extends JPanel 
{
	private JTextArea chatArea;
	private JTextField inputField;
	private JButton chatButton;
	private JButton checkerButton;
	private SpringLayout appLayout;
	private ChatbotController appController;
	private JLabel label;
	private ImageIcon image;
	private JScrollPane chatScrollPane;
	public ChatPanel(ChatbotController appController) 
	{
		super();
		this.appController = appController;

		// Initialize GUI data members
		chatButton = new JButton("Send It Boi");
		checkerButton = new JButton("Check this ish");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(25);
		appLayout = new SpringLayout();
		
		chatScrollPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 20, SpringLayout.SOUTH, chatScrollPane);
		label = new JLabel("");
		
		label.setIcon(new ImageIcon(getClass().getResource("images/Chicken4U.png")));
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 10, SpringLayout.NORTH, this);

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void setupPanel() 
	{
		this.setBackground(new Color(45, 185, 255));
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		this.add(label);
		this.setSize(450, 350);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}

	private void setupLayout() 
	{
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -11, SpringLayout.WEST, label);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, label);
		appLayout.putConstraint(SpringLayout.WEST, label, 340, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, label, 28, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, label, -157, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 340, SpringLayout.WEST, this);
	}

	private void setupListeners() 
	{
		chatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click) 
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		inputField.addActionListener(new ActionListener() 
		{
		
			public void jTextField1KeyPressed(java.awt.event.KeyEvent evt) 
			{
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					// Enter was pressed. Your code goes here.
					String userText = inputField.getText();
					String displayText = appController.interactWithChatbot(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			} 
		});
	}
}
