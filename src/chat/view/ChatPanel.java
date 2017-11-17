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
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 111, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -170, SpringLayout.NORTH, chatArea);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -57, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 180, SpringLayout.NORTH, this);
		label = new JLabel("");
		appLayout.putConstraint(SpringLayout.WEST, label, 340, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -12, SpringLayout.WEST, label);
		appLayout.putConstraint(SpringLayout.NORTH, label, 28, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, label, -157, SpringLayout.SOUTH, this);
		label.setIcon(new ImageIcon(getClass().getResource("images/Chicken4U.png")));
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 330, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
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
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		this.add(label);
	}

	private void setupLayout() 
	{

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
	}
}
