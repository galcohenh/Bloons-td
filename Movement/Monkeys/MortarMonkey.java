package Movement.Monkeys;

import java.awt.Graphics;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Movement.Point;
import mainPack.Calculation;
import mainPack.GameBeats;

public class MortarMonkey extends Monkey {
	private final static int MORTAR_SHOOTING_SPEED = 60;
	private Point boomPoint;
	private final static int BOOM_SPEED = 6;
	private int boomIndex = BOOM_SPEED;
	private int currentBoomImageIndex = 0;
	
	public MortarMonkey() {
		super(964.0, 187.0, 57, 61, MORTAR_SHOOTING_SPEED);
		modeImages = AllBufferedImages.mortarModeImages;
		this.currentModeImage = modeImages[0];
		this.name = "Mortar Monkey";
		this.cost = 100;
		this.range = 60;
		this.hasRange = true;
		this.isRotating = false;
		this.setBoomPoint(new Point(500, 200));
	}

	@Override
	void shoot() {
		if (!getIsPressed() && !isOnToolbar) {
			EventHandler.getInstance().notifyBloonDisappearanceListeners(new BloonDisappearanceEvent(firstBloonOnArea, true));
			currentModeImage = lookAt(firstBloonOnArea.getPoint());
		}
	}

	@Override
	public boolean isPointInRange(Point point) {
		return (Calculation.getDistance(point, boomPoint) < range);
	}
	
	@Override
	public void timePassed() {
		super.timePassed();
		boomIndex--;
		if (boomIndex == 0) {
			boomIndex = BOOM_SPEED;
			currentBoomImageIndex++;
			if (currentBoomImageIndex == 5) {
				currentBoomImageIndex = 0;
			}
		}
	}
	
	@Override
	public void drawShootingEffect(Graphics g) {
		if (isOnToolbar) {
			return;
		}
		g.drawImage(AllBufferedImages.boomSprites[currentBoomImageIndex], (int)boomPoint.getX(), (int)boomPoint.getY(), 70, 70, null);
		if (currentBoomImageIndex == 0 && !isOnToolbar) {
			g.drawImage(AllBufferedImages.shootingBoom, (int)getPoint().getX() + 26, (int)getPoint().getY() - 23, 26, 28, null);
		}
	}

	public Point getBoomPoint() {
		return boomPoint;
	}

	public void setBoomPoint(Point boomPoint) {
		this.boomPoint = boomPoint;
	}
}
