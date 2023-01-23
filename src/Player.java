import java.util.Random;

public class Player {
	private String name;
	private int score;
	private String[] emotes = {"Disappoint", "Sad", "Angry", "Mad", "Accepted"};
	private boolean isBot;
	
	public Player(String name) {
		super();
		this.name = name;
		this.isBot = false;
	}
	public Player(int numPlayer) {
		this.name = "Bot " + (numPlayer + 1);
		this.isBot = true;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public boolean getIsBot() {
		return isBot;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setIsBot(boolean isBot) {
		this.isBot = isBot;
	}
	
	public String getEmotes() {
		Random rand = new Random();
		int randEmoteIndex = rand.nextInt(emotes.length);
		return emotes[randEmoteIndex];
	}
	
}
