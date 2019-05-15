package Movement.Bloons;

import Events.BloonExplodedEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;

public class RedBloon extends Bloon implements Drawable {
	private final static int RED_WIDTH = 35; //40
	private final static int RED_HEIGHT = 47; //54
	
	public RedBloon(double x, double y) {
		super(x, y, RED_WIDTH, RED_HEIGHT);
		this.maxXSpeed = 2;
		this.maxYSpeed = 2;
		this.damage = 1;
		this.hp = 1;
		this.currentModeImage = AllBufferedImages.redBloonImage;
		this.runRight();
		this.son = null;
		this.numOfSons = 0;
		this.cost = 1;
	}
	
	public RedBloon(double x, double y, int distanceFromNext) {
		this(x, y);
		this.setDistanceFromNext(distanceFromNext);
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
