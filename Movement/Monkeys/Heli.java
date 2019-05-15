package Movement.Monkeys;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import org.omg.CORBA.FREE_MEM;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;
import Graphics.Elements.ImageTool;
import Movement.Point;
import Movement.Vector2D;
import mainPack.Calculation;
import mainPack.Game;

public class Heli extends Monkey {

	private boolean isFirstDrawing;
	private Point currrentMoveToPoint;
	private Point point1;
	private Point point2;
	private int locateX, locateY;;
	private final static int ROTATE_BLADES_SPEED = 6;
	private int rotateBladesIndex = ROTATE_BLADES_SPEED;
	private int currentBladesMode = 0;
	private final static int HELI_SHOOTING_SPEED = 12;
	private final static int HELI_MOVING_SPEED = 4;
	
	private boolean isMoveToPointMode;
	
	public Heli(Point point) {
		super(point.getX(), point.getY(), 50, 50, HELI_SHOOTING_SPEED);
		isMoveToPointMode = false;
		point1 = new Point(0, 0);
		point2 = new Point(500, 500);
		currrentMoveToPoint = point1;
		modeImages = AllBufferedImages.pilotModeImages;
		isFirstDrawing = true;
		this.currentModeImage = modeImages[0];
		this.range = 60;
		this.hasRange = true;
		this.isRotating = true;
		this.isOnToolbar = false;
	}
	
	@Override
	void shoot() {
		EventHandler.getInstance().notifyBloonDisappearanceListeners(new BloonDisappearanceEvent(firstBloonOnArea, true));
		currentModeImage = lookAt(firstBloonOnArea.getPoint());
	}
	
	@Override
	public void timePassed() {
		rotateBladesIndex--;
		if (rotateBladesIndex == 0) {
			rotateBladesIndex = ROTATE_BLADES_SPEED;
			currentBladesMode++;
		}
		Vector2D moveDir = new Vector2D(currrentMoveToPoint.getX() - getPoint().getX(), currrentMoveToPoint.getY() - getPoint().getY());
		if (moveDir.getLength() < 2) {
			moveDir = new Vector2D(0, 0);
			//currrentMoveToPoint = (currrentMoveToPoint == point1)? point2: point1;
			if (!Game.bloons.isEmpty()) {
				currrentMoveToPoint = Game.bloons.get(0).getPoint();
			}
			//System.out.println(getPoint().getX() + " " + getPoint().getY());
			//System.out.println("Close to the next point is: x:" + currrentMoveToPoint.getX() + "y:" + currrentMoveToPoint.getY());
		} else if (moveDir.getLength() < HELI_MOVING_SPEED) {
			vX = moveDir.getComponents()[0];
			vY = moveDir.getComponents()[1];
		} else {
			//System.out.println(getPoint().getX() + " " + getPoint().getY());
			//System.out.println("next point is: x:" + currrentMoveToPoint.getX() + "y:" + currrentMoveToPoint.getY());
			moveDir.normalize();
			updateVelocity(moveDir, HELI_MOVING_SPEED, HELI_MOVING_SPEED);
		}
		super.timePassed();
	}
	
	@Override
	public void drawShootingEffect(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BufferedImage lookAt(Point point) {
		double rotationRequired = Calculation.getAngleBetweenTwoPoints(new Point(this.point.getX() + width / 2, this.point.getY() + height / 2), point);
		return ImageTool.rotate(currentModeImage, rotationRequired + Math.PI / 2);
	}
	
	@Override
	public BufferedImage lookAt() {
		return lookAt(new Point(this.point.getX() + width / 2, this.point.getY() - 1));
	}
	
	public void updateCurrentModeImage() {
		if (currentBladesMode % 3 == 0) {
			currentBladesMode = 0;
			locateX = (int)point.getX() - 30;
			locateY = (int)point.getY() - 10;
			currentModeImage = modeImages[0];
		} else if (currentBladesMode % 3 == 1) {
			locateX = (int)point.getX() - 42;
			locateY = (int)point.getY() - 15;
			currentModeImage = modeImages[1];
		} else {
			locateX = (int)point.getX() - 35;
			locateY = (int)point.getY() - 10;
			currentModeImage = modeImages[2];
			currentBladesMode = 0;
		}
		if (firstBloonOnArea == null && isFirstDrawing) {
			currentModeImage = lookAtDirection();
		} else {
			if (this.lookAtPoint != null) {
				isFirstDrawing = false;
				if (firstBloonOnArea != null) {
					Point lookAtPoint = new Point(this.lookAtPoint.getX() + firstBloonOnArea.getWidth() / 2, this.lookAtPoint.getY() + firstBloonOnArea.getHeight() / 2);
				} else {
					Point lookAtPoint = currrentMoveToPoint;
				}
				currentModeImage = lookAt(lookAtPoint);
			}
		}
		System.gc();
	}
	
	
	private Image lookAtDirection() {
		return lookAt(currrentMoveToPoint);
	}
	
	@Override
	public void draw(Graphics g) {
		updateCurrentModeImage();
		g.drawImage(currentModeImage, locateX, locateY, currentModeImage.getWidth(null), currentModeImage.getHeight(null), null);
	}

}
