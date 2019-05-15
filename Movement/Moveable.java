package Movement;

import java.awt.Graphics;
import java.awt.Image;

import Graphics.Elements.Drawable;


public abstract class Moveable extends Area implements  Drawable {

	protected Image [] modeImages;
	protected double vX;
	protected double vY;
	protected double maxXSpeed;
	protected Direction currentDirection;
	protected double maxYSpeed;
	protected Image currentModeImage;
	
	public double getMaxXSpeed() {
		return maxXSpeed;
	}

	public void setMaxXSpeed(double maxXSpeed) {
		this.maxXSpeed = maxXSpeed;
	}

	public double getMaxYSpeed() {
		return maxYSpeed;
	}

	public void setMaxYSpeed(double maxYSpeed) {
		this.maxYSpeed = maxYSpeed;
	}

	public double getvX() {
		return vX;
	}

	public void setvX(double vX) {
		this.vX = vX;
	}

	public double getvY() {
		return vY;
	}

	public void setvY(double vY) {
		this.vY = vY;
	}
	
	protected void updateVelocity(Vector2D moveDir, double xSpeed, double ySpeed) {
		vX = xSpeed * moveDir.getComponents()[0];
		vY = ySpeed * moveDir.getComponents()[1];
	}
	
	public Moveable(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.point = new Point(x, y);
		vX = 0;
		vY = 0;
		this.height = height;
		this.width = width;
	}
	
	public void timePassed() {
		handleSpeed();
	}

	protected void handleSpeed() {
		point.setX(point.getX() + vX);
		point.setY(point.getY() + vY);
	}	
	
	public void runRight() {
		currentDirection = Direction.RIGHT;
		vX = maxXSpeed;
	}
	
	public void runLeft() {
		currentDirection = Direction.LEFT;
		vX = -maxXSpeed;
	}
	
	public void runUp() {
		currentDirection = Direction.UP;
		vY = -maxYSpeed;
	}
	
	public void stop() {
		vX = 0;
		vY = 0;
	}
	
	public void runDown() {
		currentDirection = Direction.DOWN;	
		vY = maxYSpeed;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point p) {
		this.point = p;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(currentModeImage, (int)point.getX(), (int)point.getY(), width, height, null);
	}
	
	abstract public boolean wentThroughMap();
	
}
