package Movement.Monkeys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import Graphics.Elements.Drawable;
import Movement.ForbiddenAreas;
import Movement.Moveable;
import Movement.Point;
import Movement.Bloons.Bloon;
import mainPack.Calculation;
import mainPack.Game;
import mainPack.GameBeats;

public abstract class Monkey extends Moveable implements Drawable {
	
	protected Boolean isPressed;
	protected String name;
	protected int cost;
	protected boolean isOnToolbar;
	protected boolean isRotating;
	protected int range;
	public Bloon firstBloonOnArea;
	protected Point lookAtPoint;
	protected int shootingSpeed;
	protected int shootingSpeedIndex;
	protected boolean hasRange;
	protected Timer shootingTimer;
	private DetailsBoard detailsBoard;
	protected boolean isMultiRange;
	
	public Monkey(double x, double y, int width, int height, int shootingSpeed) {
		super(x, y, width, height);
		this.isOnToolbar = true;
		this.isPressed = false;
		this.isRotating = true;
		this.shootingSpeed = shootingSpeed;
		shootingSpeedIndex = shootingSpeed;
		isMultiRange = false;
	}
	
	@Override
	public void timePassed() {
		super.timePassed();
		if (GameBeats.isPaused()) {
			return;
		}
		shootingSpeedIndex--;
		if (shootingSpeedIndex == 0) {
			findBloonOnRange();
			shootingSpeedIndex = shootingSpeed;
		}
		
	}
	
	public boolean isOnToolbar() {
		return isOnToolbar;
	}

	public void setIsOnToolbar(boolean isOnToolbar) {
		this.isOnToolbar = isOnToolbar;
	}
	
	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
	
	public Boolean getIsPressed() {
		return isPressed;
	}

	public void setIsPressed(Boolean isPressed) {
		this.isPressed = isPressed;
	}
	
	@Override
	public boolean wentThroughMap()
	{
		if (this.getPoint().getX() > 906) {
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public boolean hasEnoughMoney() {
		return Game.getCoins() >= cost;
	}
	
	public boolean isOnForbiddenArea() {
		ForbiddenAreas forbiddenAreas = new ForbiddenAreas();
		return forbiddenAreas.isOnForbiddenAreas(point.getX() + width / 2, point.getY() + height / 2);
	}
	
	@Override
	public void draw(Graphics g) {
		if (this.detailsBoard != null && this.detailsBoard.isOn() && !isOnToolbar) {
			drawRange(g);
		}
		if (!hasEnoughMoney() && isOnToolbar) {
			currentModeImage = modeImages[2];
		}
		else if (isOnForbiddenArea()) {
			currentModeImage = modeImages[1];
		}
		else {
			currentModeImage = modeImages[0];
		}
		if (firstBloonOnArea == null || isPressed || !isRotating) {
			currentModeImage = lookAt();
		} else {
			if (this.lookAtPoint != null) {
				Point lookAtPoint = new Point(this.lookAtPoint.getX() + firstBloonOnArea.getWidth() / 2, this.lookAtPoint.getY() + firstBloonOnArea.getHeight() / 2);
				currentModeImage = lookAt(lookAtPoint);
			}
		}
		g.drawImage(currentModeImage, (int)point.getX(), (int)point.getY(), width, height, null);
		if (this.detailsBoard != null && this.detailsBoard.isOn() && !isOnToolbar) {
			detailsBoard.draw(g);
		}
		drawShootingEffect(g);
	}
	
	public BufferedImage lookAt(Point point) {
		double rotationRequired = Calculation.getAngleBetweenTwoPoints(new Point(this.point.getX() + width / 2, this.point.getY() + height / 2), point);
		rotationRequired += Math.PI / 2;
		double locationX = getWidth() / 2;
		double locationY = getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op.filter((BufferedImage) currentModeImage, new BufferedImage(currentModeImage.getWidth(null), currentModeImage.getHeight(null), ((BufferedImage)currentModeImage).getType() ));
	}
	
	public BufferedImage lookAt() {
		return lookAt(new Point(this.point.getX() + width / 2, this.point.getY() - 1));
	}
	
	public boolean isPointInRange(Point point) {
		return (Calculation.getDistance(point, getPoint()) < range);
	}
	
	public void findBloonOnRange() {
		if (this instanceof SpikeFactory && !isOnToolbar) {
			shoot();
			return;
		}
		for(int i = 0; i < GameBeats.getGame().getBloons().size(); i++) {
			Bloon bloon = GameBeats.getGame().getBloons().get(i);
			//if it finds bloon is the range, it will be the first bloon
			if ((isPointInRange(bloon.getPoint()) || !hasRange) && !isOnToolbar) {
				firstBloonOnArea = bloon;
				lookAtPoint = firstBloonOnArea.getPoint();
				shoot();
				return;
			}
		}
		//if its not finding the bloon it will be removed
		if (firstBloonOnArea != null) {
			lookAtPoint = new Point(firstBloonOnArea.getPoint().getX(), firstBloonOnArea.getPoint().getY());
		}
		firstBloonOnArea = null;
	}
	
	abstract void shoot();
	
	public void drawRange(Graphics g) {
		if (!isOnToolbar()) {
			double xPos = getPoint().getX() + getWidth() / 2;
			double yPos = getPoint().getY() + getHeight() / 2;
			int range = getRange();
			g.setColor(new Color(0.1f, 0.1f, 0.1f, 0.4f));
			g.fillOval((int)xPos - range, (int)yPos - range, range * 2, range * 2);
		}
	}
	
	 public DetailsBoard getDetailsBoard() {
		return detailsBoard;
	}

	public void setDetailsBoard(DetailsBoard detailsBoard) {
		this.detailsBoard = detailsBoard;
	}

	
	abstract public void drawShootingEffect(Graphics g);
}
