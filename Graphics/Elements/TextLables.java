package Graphics.Elements;

import java.awt.Graphics;
import Movement.Point;
import Movement.Monkeys.Monkey;
import mainPack.Game;

public class TextLables {
	private static Game game;
	
	private static FontLable hpLabel;
	private static FontLable coinsLabel;
	private static FontLable pointsLabel;
	private static FontLable roundLabel;
	private static FontLable towerLabel;
	private static FontLable costLabel;

	public static void addGameDetails(Graphics g) {
		hpLabel = new FontLable("hpLabel", new Point(45.0, 12.0), "", g); 
		coinsLabel = new FontLable("coinsLabel", new Point(145.0, 12.0), "", g); 
		pointsLabel = new FontLable("pointsLabel", new Point(958.0, 550.0), "", g); 		
		roundLabel = new FontLable("roundLabel", new Point(850.0, 23.0), "", g); 
		towerLabel = new FontLable("towerLable", new Point(980.0, 0.0), "", g); 
		costLabel = new FontLable("costLabel", new Point(1000.0, 20.0), "", g); 
	}
	
	public static String getZeroStr(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += "0";
		}
		return str;
	}
	
	public static void updateDetails() {
		hpLabel.updateText(Game.getHp() + "");
		coinsLabel.updateText(Game.getCoins() + "");
		roundLabel.updateText(Game.getLevel().getCurrentLevel() + "");
		hpLabel.updateText(Game.getHp() + "");
		int pointsLength = (game.getPoints() == 0)? 1: (int)(Math.log10(game.getPoints()) + 1);
		pointsLabel.updateText(getZeroStr(8 - pointsLength) + game.getPoints());
		towerLabel.draw();
		costLabel.draw();
	}
	
	public static void showMonkeyDetails(Monkey monkey) {
		towerLabel.updateText(monkey.getName());
		costLabel.updateText("$" + monkey.getCost());
	}
}
