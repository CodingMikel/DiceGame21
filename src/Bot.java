import java.util.Random;

public class Bot {
	private String name;
	private int score;
	private String[] emotes = {"Disappoint", "Sad", "Angry", "Mad", "Accepted"};
	private boolean isBot;
	
	public Bot(int numPlayer) {
		this.name = "Bot " + (numPlayer + 1);
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getEmotes() {
		Random rand = new Random();
		int randEmoteIndex = rand.nextInt(emotes.length);
		return emotes[randEmoteIndex];
	}
	
	public boolean isBot() {
		return isBot;
	}

}
