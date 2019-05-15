package mainPack;

import java.io.IOException;
import java.util.ArrayList;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.GameFrame;
import Graphics.GraphicsPanel;
import Graphics.StartGamePanel;
import Graphics.Elements.AllBufferedImages;
import Movement.Bloons.Bloon;

public class GameBeats {

	private static GraphicsPanel graphicsPanel;
	private static StartGamePanel startGamePanel;
	private static Game game;
	private static GameFrame frame;
	private static boolean isPaused;
	private static int FPS = 60;
	private static int ITERATION_MILLIS = 1000 / FPS;
	public static boolean isRunning;

	public GameBeats() throws IOException {
		AllBufferedImages.readAllImages();
		isPaused = true;
		frame = new GameFrame();
		frame.setCursor(AllBufferedImages.curser1);
		frame.setIconImage(AllBufferedImages.appIcon);
		game = new Game();
		startGamePanel = new StartGamePanel(frame);
		graphicsPanel = new GraphicsPanel(frame);
		graphicsPanel.addToDrawList(game.getBloons());
		frame.add(startGamePanel);
		frame.setVisible(true);
		isRunning = true;
	}

	public static void pause() {
		isPaused = true;
	}
	
	public static void resume() {
		isPaused = false;
	}
	
	public void gameLoop() throws InterruptedException {
		while (isRunning) {
			long startTime = System.currentTimeMillis();
			if (!isPaused) {				
				if (!game.getBloons().isEmpty()) {
					for (Bloon bloon : new ArrayList<Bloon>(game.getBloons())) {
						bloon.getPath().checkTurn();
					}
					if (!game.getBloons().isEmpty()) {
						Bloon lastBloon = game.getBloons().get(0);
						game.update();
						if (lastBloon.wentThroughMap()) {
							EventHandler.getInstance().notifyBloonDisappearanceListeners(new BloonDisappearanceEvent(lastBloon, false));
						}
					}
				}
			}
			graphicsPanel.repaint();
			long endTime = System.currentTimeMillis();
			long gameCalculationTime = endTime - startTime;
			long timeToSleep = ITERATION_MILLIS - gameCalculationTime;
			if (timeToSleep > 0) {
				Thread.sleep(timeToSleep);
			}
		}
	}
	
	public static boolean isPaused() {
		return isPaused;
	}

	public static void setPaused(boolean isPaused) {
		GameBeats.isPaused = isPaused;
	}

	public static GraphicsPanel getPanel() {
		return graphicsPanel;
	}

	public static Game getGame() {
		return game;
	}

	public static void setGame(Game newGame) {
		game = newGame;
	}

	public static GameFrame getFrame() {
		return frame;
	}

	public static void setGraphicsPanel(GraphicsPanel graphicsPanel) {
		GameBeats.graphicsPanel = graphicsPanel;
	}
}
