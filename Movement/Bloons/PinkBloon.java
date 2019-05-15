package Movement.Bloons;

import Events.BloonExplodedEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;

public class PinkBloon extends Bloon implements Drawable {
	private final static int PINK_WIDTH = 35;
	private final static int PINK_HEIGHT = 47;
	
	public PinkBloon(double x, double y) {
		super(x, y, PINK_WIDTH, PINK_HEIGHT);
		this.maxXSpeed = 4;
		this.maxYSpeed = 4;
		this.damage = 7;
		this.hp = 1;
		this.currentModeImage = AllBufferedImages.pinkBloonImage;
		this.runRight();
		this.son = new YellowBloon(x, y);
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