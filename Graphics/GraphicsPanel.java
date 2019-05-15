package Graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Events.BloonDisappearanceEvent;
import Events.BloonDisappearanceListener;
import Events.BloonExplodedEvent;
import Events.BloonExplodedListener;
import Events.EventHandler;
import Graphics.Elements.DrawPop;
import Graphics.Elements.Drawable;
import Graphics.Elements.GraphicsElements;
import Graphics.Elements.TextLables;
import Movement.Moveable;
import Movement.Bloons.RedBloon;
import Movement.Monkeys.DartMonkey;
import Movement.Monkeys.GlueGunner;
import Movement.Monkeys.Port;
import Movement.Monkeys.Monkey;
import Movement.Monkeys.MortarMonkey;
import Movement.Monkeys.SniperMonkey;
import Movement.Monkeys.SpikeFactory;
import Movement.Monkeys.Spikes;
import Movement.Monkeys.TackShooter;
import mainPack.Game;

public class GraphicsPanel extends JPanel implements BloonDisappearanceListener, BloonExplodedListener {
	
	private MyMouseListener mouseListener;
	private static List<Drawable> objectsToDraw;
	private GraphicsElements elements;
	
	public GraphicsPanel(JFrame parent) {
		setLayout(null);
		objectsToDraw = new ArrayList<Drawable>();
		elements = new GraphicsElements(this);
		addAllFigures();
		addMouseListener(parent);
		EventHandler.getInstance().addBloonDisappearanceListener(this);
		EventHandler.getInstance().addBloonExplodedListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		elements.drawBackground(g);
		elements.drawAllButtons(g);
		TextLables.addGameDetails(g);
		for (Drawable drawable : new ArrayList<Drawable>(objectsToDraw)) {
			drawable.draw(g);
		}
		drawAllShootingEffects(g);
		elements.drawToolbar(g);
		drawToolBarMonkeys(g);
		TextLables.updateDetails();
		if (Spikes.allSpikesList != null) {
			for (Spikes spike : new ArrayList<Spikes>(Spikes.allSpikesList)) {
				spike.draw(g);
			}
		}
		if (elements.isSettingsClicked()) {
			elements.pauseGame(g);
		}
		if (Game.getHp() < 1) {
			elements.gameOver(g);
		}
//		System.out.println(objectsToDraw.size() + " to draw");
//		System.out.println(Game.getMonkeys().size() + " monkeys");
//		System.out.println(Game.bloons.size() + " bloons");
	}
	
	public void addFigure(Monkey monkey) {
		Monkey newMonkey = null;
		if (monkey instanceof DartMonkey) {
			newMonkey = new DartMonkey();
		} else if (monkey instanceof SniperMonkey) {
			newMonkey = new SniperMonkey();
		} else if (monkey instanceof TackShooter) {
			newMonkey = new TackShooter();
		} else if (monkey instanceof SpikeFactory) {
			newMonkey = new SpikeFactory();
		} else if (monkey instanceof Port) {
			newMonkey = new Port();
		} else if (monkey instanceof GlueGunner) {
			newMonkey = new GlueGunner();
		} else if (monkey instanceof MortarMonkey) {
			newMonkey = new MortarMonkey();
		}
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
	}
	
	public void addAllFigures() {
		Monkey newMonkey = new DartMonkey();
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
		newMonkey = new SniperMonkey();
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
		newMonkey = new TackShooter();
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
		newMonkey = new SpikeFactory();
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
		newMonkey = new Port();
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
		newMonkey = new GlueGunner();
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
		newMonkey = new MortarMonkey();
		Game.addMonkey(newMonkey);
		objectsToDraw.add(newMonkey);
	}
	
	private void addMouseListener(JFrame parent) {
		mouseListener = new MyMouseListener();
		parent.addMouseMotionListener(mouseListener);
		parent.addMouseListener(mouseListener);
	}
	
	public void drawToolBarMonkeys(Graphics g) {
		for (Drawable drawable : new ArrayList<Drawable>(objectsToDraw)) {
			if (drawable instanceof Monkey && !((Monkey) drawable).wentThroughMap()) {
				drawable.draw(g);
			}
		}
	}
	
	public static void removeFromDrawList(Drawable elements) {
		objectsToDraw.remove(elements);
	}
	
	public static void drawAllShootingEffects(Graphics g) {
//		for (Drawable drawable : new ArrayList<Drawable>(objectsToDraw)) {
//			if (drawable instanceof Monkey) {
//				Monkey monkey = (Monkey)drawable;
//				if (monkey.firstBloonOnArea != null && !monkey.isOnToolbar()) {
//					monkey.drawShootingEffect(g);
//				}
//			}
//		}
	}
	
	public void addToDrawList(Drawable elements) {
		objectsToDraw.add(elements);
	}
	
	public void addBloonToDrawList(Drawable elements) {
		objectsToDraw.add(0, elements);
	}

	public void addToDrawList(ArrayList<? extends Moveable> movingObjects) {
		objectsToDraw.addAll(movingObjects);
	}
	
	@Override
	public void bloonPopped(BloonDisappearanceEvent event) {

	}

	@Override
	public void bloonInvaded(BloonDisappearanceEvent event) {
		removeFromDrawList(event.getBloon());
	}

	@Override
	public void bloonExploded(BloonExplodedEvent event) {
		if (event.getBloon() instanceof RedBloon) {
			DrawPop pop = new DrawPop(event.getBloon().getPoint());
			int index = objectsToDraw.indexOf(event.getBloon());
			if (index != -1) {
				objectsToDraw.add(index, pop);
			}
		}
		event.addBloonSonsToDrawList(objectsToDraw);
		removeFromDrawList(event.getBloon());
	}
}
