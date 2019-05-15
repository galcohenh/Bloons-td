package Movement.Bloons;

import Events.BloonExplodedEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;

public class BlackBloon extends Bloon implements Drawable {
	private final static int WHITE_WIDTH = 35;
	private final static int WHITE_HEIGHT = 47;
	
	public BlackBloon(double x, double y) {
		super(x, y, WHITE_WIDTH, WHITE_HEIGHT);
		this.maxXSpeed = 2;
		this.maxYSpeed = 2;
		this.damage = 9;
		this.hp = 1;
		this.currentModeImage = AllBufferedImages.blackBloonImage;
		this.runRight();
		this.son = new PinkBloon(x, y);
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