package Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.TextLables;
import Movement.ForbiddenAreas;
import Movement.Point;
import Movement.Monkeys.DartMonkey;
import Movement.Monkeys.DetailsBoard;
import Movement.Monkeys.GlueGunner;
import Movement.Monkeys.Heli;
import Movement.Monkeys.Port;
import Movement.Monkeys.Monkey;
import Movement.Monkeys.MortarMonkey;
import Movement.Monkeys.SniperMonkey;
import Movement.Monkeys.SpikeFactory;
import Movement.Monkeys.TackShooter;
import mainPack.Game;
import mainPack.GameBeats;

public class MyMouseListener implements MouseMotionListener, MouseListener {
	private Monkey lastClickedMonkey;
			
	public Monkey getlastClickedMonkey() {
		return lastClickedMonkey;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GameBeats.getFrame().setCursor(AllBufferedImages.curser1);
		if (lastClickedMonkey == null) {
			return;
		}
		if (lastClickedMonkey.wentThroughMap() && !lastClickedMonkey.isOnForbiddenArea()
				&& lastClickedMonkey.getIsPressed()) {
			if (lastClickedMonkey instanceof Port) {
				Heli heli = new Heli(lastClickedMonkey.getPoint().getCopy());
				((Port)lastClickedMonkey).setHeli(heli);
			}
			lastClickedMonkey.setIsOnToolbar(false);
			ForbiddenAreas.addForbiddenArea(lastClickedMonkey);
			GameBeats.getPanel().addFigure(lastClickedMonkey);
			Game.monkeyPurchased(lastClickedMonkey);
			lastClickedMonkey.setDetailsBoard(new DetailsBoard(lastClickedMonkey));
			
		}
		else {
			if (lastClickedMonkey.getIsPressed()) {
				if (lastClickedMonkey instanceof DartMonkey) {
					lastClickedMonkey.setPoint(new Point(971.0, 111.0));
				} else if (lastClickedMonkey instanceof TackShooter) {
					lastClickedMonkey.setPoint(new Point(1063.0, 105.0));
				} else if (lastClickedMonkey instanceof SniperMonkey) {
					lastClickedMonkey.setPoint(new Point(971.0, 265.0));
				} else if (lastClickedMonkey instanceof SpikeFactory) {
					lastClickedMonkey.setPoint(new Point(1063.0, 275.0));
				} else if (lastClickedMonkey instanceof Port) {
					lastClickedMonkey.setPoint(new Point(971.0, 365.0));
				} else if (lastClickedMonkey instanceof GlueGunner) {
					lastClickedMonkey.setPoint(new Point(1057.0, 365.0));
				} else if (lastClickedMonkey instanceof MortarMonkey) {
					lastClickedMonkey.setPoint(new Point(964.0, 187.0));
				}
			}
		}
		lastClickedMonkey.setIsPressed(false);
	}
			
	@Override
	public void mousePressed(MouseEvent e) {
		GameBeats.getFrame().setCursor(AllBufferedImages.curser2);
		if(GameBeats.isPaused() || Game.getHp() < 1) {
			return;
		}
		boolean monkeyPressed = false;
		for (Monkey monkey : Game.monkeys) {
			if (monkey.isPointOnArea(e.getX(), e.getY())) {
//					|| (monkey.getDetailsBoard() != null &&
//					monkey.getDetailsBoard().isPointOnArea(e.getX(), e.getY())
//							&& !monkey.isOnToolbar())) 
				if (monkey.isOnToolbar()) {
					monkey.setIsPressed(true);
				}
				if (monkey.getDetailsBoard() != null) {
					monkey.getDetailsBoard().setOn(false);
				}
				lastClickedMonkey = monkey;
				if (lastClickedMonkey.getDetailsBoard() != null) {
					lastClickedMonkey.getDetailsBoard().setOn(true);
				}
				TextLables.showMonkeyDetails(lastClickedMonkey);
				monkeyPressed = true;
			}
		}
		if (!monkeyPressed) {
			if (lastClickedMonkey != null && lastClickedMonkey.getDetailsBoard() != null) {
					lastClickedMonkey.getDetailsBoard().setOn(false);
			}
			lastClickedMonkey = null;
		}
	}
			
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}
			
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if (lastClickedMonkey == null) {
			return;
		}
		if (lastClickedMonkey.getIsPressed() && lastClickedMonkey.hasEnoughMoney()) {
			lastClickedMonkey.getPoint().setX(arg0.getX() - lastClickedMonkey.getWidth() / 2);
			lastClickedMonkey.getPoint().setY(arg0.getY() - lastClickedMonkey.getHeight() / 2);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}