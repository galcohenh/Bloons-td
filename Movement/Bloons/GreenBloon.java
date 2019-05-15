package Movement.Bloons;

import Events.BloonExplodedEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;

public class GreenBloon extends Bloon implements Drawable {
	private final static int GREEN_WIDTH = 35;
	private final static int GREEN_HEIGHT = 47;
	
	public GreenBloon(double x, double y) {
		super(x, y, GREEN_WIDTH, GREEN_HEIGHT);
		this.maxXSpeed = 3;
		this.maxYSpeed = 3;
		this.damage = 3;
		this.hp = 1;
		this.currentModeImage = AllBufferedImages.greenBloonImage;
		this.runRight();
		this.son = new BlueBloon(x, y);
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