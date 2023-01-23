import java.util.Scanner;

public class gameSystem {
	public static final int MAX_PLAYER = 4;
	public static final int FALSE_NUMBEER_USER = 1;
	public static final int NOT_EDNOUGH_USER = 2;
	public static final int FULL_PLAYER = 0;
	private int numUser = 0;
	private Player[] playerList = new Player[MAX_PLAYER];
//	private String[] status = {"Victory", "Defeated"};
	
	private int checkNumUser() {
		return numUser;
	}
	
	public void addUser(String newPlayer) {
		if (checkNumUser() == FALSE_NUMBEER_USER) {
			System.out.println("There can't be more than 4 player!");
		}
		playerList[numUser] = new Player(newPlayer);
		numUser++;
	}
	
	private void addBot() {
		for (;numUser < MAX_PLAYER;) {
			playerList[numUser] = new Player(numUser);
			numUser++;
		}
	}
		
	private void menu() {
		System.out.println("Welcome to Dice game 21");
		int preGameCondition = 0;
		String inputString = null;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("1. Add Player");
			System.out.println("2. Start Game");
			System.out.println("3. Exit");
			System.out.print("Please enter option: ");
			preGameCondition = input.nextInt();
			if (preGameCondition == 1) {
				System.out.print("Enter player name: ");
				inputString = input.next();
				addUser(inputString);
			}
			else if (preGameCondition == 2) {
				System.out.println("Loading");
				if (numUser < MAX_PLAYER) {
					addBot();
				}
				break;
			}
		} while (preGameCondition != 3);
	}
	Referee referee = new Referee(playerList);
	public static void main(String[] args) {
		gameSystem gameSystem = new gameSystem();
		gameSystem.menu();
		gameSystem.referee.letStart();
	}
}
