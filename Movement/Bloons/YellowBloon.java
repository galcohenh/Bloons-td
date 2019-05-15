package Movement.Bloons;

import Events.BloonExplodedEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;

public class YellowBloon extends Bloon implements Drawable {
	private final static int YELLOW_WIDTH = 35;
	private final static int YELLOW_HEIGHT = 47;
	
	public YellowBloon(double x, double y) {
		super(x, y, YELLOW_WIDTH, YELLOW_HEIGHT);
		this.maxXSpeed = 4;
		this.maxYSpeed = 4;
		this.damage = 5;
		this.hp = 1;
		this.currentModeImage = AllBufferedImages.yellowBloonImage;
		this.runRight();
		this.son = new GreenBloon(x, y);
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