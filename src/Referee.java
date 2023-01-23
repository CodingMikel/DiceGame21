public class Referee {
	private Player[] playerList;
	public static final int MAX_PLAYER = 4;
	public static final int WIN_SCORE = 21;

	public Referee(Player[] newPlayerList) {
		this.playerList = newPlayerList;
	}
	
	public void letStart() {
		ratioDice[] dice = new ratioDice[MAX_PLAYER];
		dice[0] = new ratioDice("0:20:16:16:16:16:16");
		dice[1] = new ratioDice("0:16:20:16:16:16:16");
		dice[2] = new ratioDice("0:16:16:20:16:16:16");
		dice[3] = new ratioDice("0:16:16:16:20:16:16");
		do {
			for (int index = 0; index < playerList.length; index++) {
				playerList[index].setScore(playerList[index].getScore() + dice[index].rateRoll());
				System.out.printf("%s: %d\n", playerList[index].getName(), playerList[index].getScore());
				if (playerList[index].getScore() > 21) {
					playerList[index].setScore(0);
				}
				else if (playerList[index].getScore() == 21) {
					System.out.printf("Player %s win the game!\n", playerList[index].getName());
					for(int i = 0; i < playerList.length; i++) {
						if (playerList[i].getIsBot() == true && i != index) {
							System.out.println(playerList[i].getName() + ": " + playerList[i].getEmotes());
						}
					}
					return;
				}
			}			
		} while (true);
	}
	
}
