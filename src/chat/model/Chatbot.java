package chat.model;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;


public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	private String chatbotResponse;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildCuteAnimals();
		buildQuestions();
		buildVerbs();
		buildShoppingList();
		buildMovieList();
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildMovieList()
	{
		movieList.add(new Movie("Sand Lot"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protien");
		shoppingList.add("fruits");
		shoppingList.add("bleach");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("pupper");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name ?";
		questions[1] = "How much woood could a wood chuck chuck if a wood chuck could chuck wood?";
		questions[2] = "How tall is mitch?";
		questions[3] = "Was poppin B?";
		questions[4] = "Is a snake a giant worm or a legless lizard?";
		questions[5] = "What is the answer to the universe?";
		questions[6] = "Whomst the flip invented top raman?";
		questions[7] = "What is your favorite pokemon?";
		questions[8] = "What is your favoirte food?";
		questions[9] = "What is two plus two?";
	}
	
	/**
	 * Describe what the method does: this method checks the length of the input 
	 * @param input processes it
	 * @return returns valid string
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
			validLength = true;
		}
		return validLength;
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said: " + "\n" + input+ "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	/**
	 * Description of this method: This builds a random response from my different arrays
	 * @return and it returns a random response using the chat-bot sentence part arrays
	 */
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * movieList.size());
		
		random = (int) (Math.random() * 2);
		
		if(random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += movieList.get(random).getTitle() + " is a great movie!";
		}
		
		return response;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	/*So this method checks to see if there are a couple of different things in the user name. If there are not these things then it returns false
	 * if there are some extra things then it also returns false
	 * 
	 */
	
	public boolean userNameChecker(String input)
	{
		if(input.equals(null)|| input.contains("@@")|| input.contains(" ")|| input.contains("@")|| input.contains(".com"))
		{
			return false;
		}
		else if(input.equals(null)|| !input.contains("@@")|| !input.contains(" ")|| !input.contains("@")|| !input.contains(".com"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	/**
	 * This checks to see if you are trying to quit. It only accepts "quit" as a valid quit command
	 * @param exitString
	 * @return returns false if the test does not pass.
	 */
	
	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		if(!exitString.contains("")|| !exitString.equals(null)|| !exitString.contains("exit")|| !exitString.contains("Quit")|| !exitString.contains("QUIT")|| !exitString.contains("Is it time to quit?"))
		{
			
		}
		return false;
	}

	//assertFalse("Blank does not mean quit", testedChatbot.quitChecker(""));
	//assertFalse("Null does not mean quit", testedChatbot.quitChecker(null));
	//assertFalse("Exit does not mean quit", testedChatbot.quitChecker("exit"));
	//assertTrue("Quit does mean quit", testedChatbot.quitChecker("Quit"));
	//assertTrue("QUIT also means quit", testedChatbot.quitChecker("QUIT"));
	//assertFalse("Quit with other words does not mean quit", testedChatbot.quitChecker("Is it time to quit?"));
	
	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
