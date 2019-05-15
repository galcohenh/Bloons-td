package mainPack;

import java.util.ArrayList;

import javax.swing.JPanel;

import Events.BloonDisappearanceEvent;
import Events.BloonDisappearanceListener;
import Events.BloonExplodedEvent;
import Events.BloonExplodedListener;
import Events.EventHandler;
import Graphics.GraphicsPanel;
import Movement.Moveable;
import Movement.Bloons.Bloon;
import Movement.Monkeys.Monkey;
import Movement.Monkeys.Spikes;

public class Game implements BloonDisappearanceListener, BloonExplodedListener{
	
	public static ArrayList<Bloon> bloons;
	public static ArrayList<Monkey> monkeys;

	private static final double INITIAL_X = 0;
	public static final double INITIAL_Y = 400;
	private static int hp;
	private static int coins;
	private static int points;
	private static Level level;
	
	public Game() {
		level = new Level();
		hp = 100;
		coins = 100;
		points = 0;
		bloons = (ArrayList<Bloon>) level.getCurrentBloons();
		monkeys = new ArrayList<Monkey>();
		EventHandler.getInstance().addBloonDisappearanceListener(this);
		EventHandler.getInstance().addBloonExplodedListener(this);
	}
	
	public static void resetAll() {
		GameBeats.setGame(new Game());
		final JPanel graphicsPanel = GameBeats.getPanel();
		GameBeats.getFrame().remove(graphicsPanel);
		GameBeats.getFrame().invalidate();
		GameBeats.setGraphicsPanel(new GraphicsPanel(GameBeats.getFrame()));
		GameBeats.getFrame().add(GameBeats.getPanel());
		GameBeats.getFrame().validate();
		GameBeats.getFrame().setVisible(true);
		GameBeats.resume();
	}
	
	public void update() {
		for (Moveable moveable : new ArrayList<Monkey>(monkeys)) {
			moveable.timePassed();
		}
		for (Bloon bloon : new ArrayList<Bloon>(bloons)) {
			bloon.timePassed();
			if (Spikes.allSpikesList != null) {
				for (Spikes spike : new ArrayList<Spikes>(Spikes.allSpikesList)) {
					if(spike.isPointOnArea(bloon.getMiddlePos())) {
						EventHandler.getInstance().notifyBloonDisappearanceListeners(new BloonDisappearanceEvent(bloon, true));
						spike.removeSpike();
					}
				}
			}
		}
	}

	public ArrayList<Bloon> getBloons() {
		return bloons;
	}

	public static int getHp() {
		return (hp > 0)? hp: 0;
	}

	public static int getCoins() {
		return coins;
	}

	public static int getPoints() {
		return points;
	}
	
	public void bloonDamage(Bloon bloon) {
		hp -= bloon.getDamage();
		bloons.remove(bloon);
	}

	public static Level getLevel() {
		return level;
	}

	public static void setLevel(Level level) {
		Game.level = level;
	}
	
	public static void monkeyPurchased(Monkey monkey) {
		coins -= monkey.getCost();
	}
	
	public static void addMonkey(Monkey monkey) {
		monkeys.add(monkey);
	}

	@Override
	public void bloonPopped(BloonDisappearanceEvent event) {
		coins += event.getBloon().getCost();
		points += event.getBloon().getCost();
		event.getBloon().bloonDamaged(1);
	}

	@Override
	public void bloonInvaded(BloonDisappearanceEvent event) {
		hp -= event.getBloon().getDamage();
		bloons.remove(event.getBloon());
	}
	
	public static ArrayList<Monkey> getMonkeys() {
		return monkeys;
	}

	public static void setMonkeys(ArrayList<Monkey> monkeys) {
		Game.monkeys = monkeys;
	}

	@Override
	public void bloonExploded(BloonExplodedEvent event) {
		event.addBloonSons(bloons);
		bloons.remove(event.getBloon());
	}
}
