package Movement.Bloons;

import java.awt.Color;
import java.awt.Graphics;

import Events.BloonExplodedEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;
import Movement.Point;

public class ZebraBloon extends Bloon implements Drawable {
	private final static int ZEBRA_WIDTH = 39;
	private final static int ZEBRA_HEIGHT = 52;
	
	public ZebraBloon(double x, double y) {
		super(x, y, ZEBRA_WIDTH, ZEBRA_HEIGHT);
		this.maxXSpeed = 5;
		this.maxYSpeed = 3;
		this.damage = 11;
		this.hp = 1;
		this.currentModeImage = AllBufferedImages.zebraBloonImage;
		this.runRight();
		this.son = new BlackBloon(x, y);
		this.numOfSons = 1;
		this.cost = 1;
	}

	@Override
	public void explosive() {
		EventHandler.getInstance().notifyBloonExplodedListeners(new BloonExplodedEvent(this));
	}

	@Override
	public void bloonDamaged(int damage) {
		hp -= damage;
		if (hp < 0) {
			explosive();
		}
	}
}