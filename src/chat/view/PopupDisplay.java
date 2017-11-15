package chat.view;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class PopupDisplay 
{
	private ImageIcon icon;
	private String windowTitle;
	
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/Chicken4U.png"));
		windowTitle = "Supreme Ogre Lard Jathanual the Chatbot exclaims: ";	
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public String collectResponse(String question)
	{
		String answer = "He is sleepy now so no meme will be granted.";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null,"");

		return answer;
	}
}
