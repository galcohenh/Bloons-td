package Movement.Monkeys;

import java.awt.Graphics;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;

public class GlueGunner extends Monkey {
	private final static int GLUE_SHOOTING_SPEED = 20;
	
	public GlueGunner() {
		super(1057.0, 365.0, 60, 60, GLUE_SHOOTING_SPEED);
		modeImages = AllBufferedImages.glueModeImages;
		this.currentModeImage = modeImages[0];
		this.name = "Glue Gunner";
		this.cost = 50;
		this.range = 60;
		this.hasRange = true;
	}

	@Override
	void shoot() {
		if (!getIsPressed() && !isOnToolbar) {
			firstBloonOnArea.setGlued(true);
			currentModeImage = lookAt(firstBloonOnArea.getPoint());
		}
	}

	@Override
	public void drawShootingEffect(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
