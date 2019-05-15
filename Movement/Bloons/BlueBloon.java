package Movement.Bloons;

import Events.BloonExplodedEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;

public class BlueBloon extends Bloon implements Drawable {
	private final static int BLUE_WIDTH = 35;
	private final static int BLUE_HEIGHT = 47;
	
	public BlueBloon(double x, double y) {
		super(x, y, BLUE_WIDTH, BLUE_HEIGHT);
		this.maxXSpeed = 2;
		this.maxYSpeed = 2;
		this.damage = 2;
		this.hp = 1;
		this.currentModeImage = AllBufferedImages.blueBloonImage;
		this.runRight();
		this.son = new RedBloon(x, y);
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