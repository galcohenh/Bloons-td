package Movement.Monkeys;

import java.awt.Graphics;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;

public class DartMonkey extends Monkey {
	private final static int DART_SHOOTING_SPEED = 12;
	
	public DartMonkey() {
		super(971.0, 111.0, 40, 40, DART_SHOOTING_SPEED);
		modeImages = AllBufferedImages.dartMonkeyModeImages;
		this.currentModeImage = modeImages[0];
		this.name = "Dart Monkey";
		this.cost = 50;
		this.range = 60;
		this.hasRange = true;
	}

	@Override
	void shoot() {
		if (!getIsPressed() && !isOnToolbar) {
			EventHandler.getInstance().notifyBloonDisappearanceListeners(new BloonDisappearanceEvent(firstBloonOnArea, true));
			currentModeImage = lookAt(firstBloonOnArea.getPoint());
		}
	}

	@Override
	public void drawShootingEffect(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
