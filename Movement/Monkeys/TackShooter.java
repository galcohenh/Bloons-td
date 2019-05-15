package Movement.Monkeys;

import java.awt.Graphics;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;

public class TackShooter extends Monkey {
	private final int SHOOT1_WIDTH = 88;
	private final int SHOOT1_HEIGHT = 87;
	private final int SHOOT2_WIDTH = 113;
	private final int SHOOT2_HEIGHT = 105;
	private int shootModeIndex = 0;
	public TackShooter() {
		super(1063.0, 105.0, 49, 48, 12);
		modeImages = AllBufferedImages.tackModeImages;
		this.currentModeImage = modeImages[0];
		this.name = "Sniper Monkey";
		this.cost = 40;
		this.range = 40;
		this.hasRange = true;
		shootModeIndex = 0;
	}

	@Override
	void shoot() {
		if (!getIsPressed() && !isOnToolbar) {
			EventHandler.getInstance().notifyBloonDisappearanceListeners(new BloonDisappearanceEvent(firstBloonOnArea, true));
			currentModeImage = lookAt(firstBloonOnArea.getPoint());
			shootModeIndex++;
		}
	}

	@Override
	public void drawShootingEffect(Graphics g) {
		if (isOnToolbar || firstBloonOnArea == null) {
			return;
		}
		if (shootModeIndex % 2 == 0) {
			g.drawImage(AllBufferedImages.tackShooterShoot1, (int)getPoint().getX() - SHOOT1_WIDTH / 4, (int)getPoint().getY() - SHOOT1_HEIGHT / 4, SHOOT1_WIDTH, SHOOT1_HEIGHT, null);
		} else {
			g.drawImage(AllBufferedImages.tackShooterShoot2, (int)getPoint().getX() - SHOOT2_WIDTH / 4, (int)getPoint().getY() - SHOOT2_HEIGHT / 4, SHOOT2_WIDTH, SHOOT2_HEIGHT, null);
		}
		
	}
}
