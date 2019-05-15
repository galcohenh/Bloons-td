package mainPack;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {
		GameBeats startGame = new GameBeats();
		startGame.gameLoop();
	}
}
