package Movement.Monkeys;

import java.awt.Graphics;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;

public class SniperMonkey extends Monkey {
	
	private int shootIndex = 0;

	public SniperMonkey() {
		super(971.0, 265.0, 40, 71, 60);
		modeImages = AllBufferedImages.sniperModeImages;
		this.currentModeImage = modeImages[0];
		this.name = "Sniper Monkey";
		this.cost = 40;
		this.range = 40;
		this.hasRange = false;
	}
	
	@Override
	void shoot() {
		if (!getIsPressed()) {
			EventHandler.getInstance().notifyBloonDisappearanceListeners(new BloonDisappearanceEvent(firstBloonOnArea, true));
			shootIndex++;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		if (!hasEnoughMoney() && isOnToolbar) {
			currentModeImage = modeImages[2];
		}
		else if (isOnForbiddenArea()) {
			currentModeImage = modeImages[1];
		}
		else {
			currentModeImage = modeImages[0];
		}
		g.drawImage(currentModeImage, (int)point.getX(), (int)point.getY() + shootIndex % 3, width, height, null);
	}

	@Override
	public void drawShootingEffect(Graphics g) {
		g.drawImage(AllBufferedImages.targetImage, (int)firstBloonOnArea.getPoint().getX(), (int)firstBloonOnArea.getPoint().getY(), 20, 20, null);
	}
}
