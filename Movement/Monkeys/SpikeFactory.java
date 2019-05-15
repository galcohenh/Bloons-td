package Movement.Monkeys;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Graphics.Colors;
import Graphics.Elements.AllBufferedImages;
import Movement.Direction;
import Movement.Path;
import Movement.Point;
import mainPack.Calculation;

public class SpikeFactory extends Monkey {
	private int shootIndex = 0;
	private int addSpikesDirection = 0;
	private static final int MARGIN = 5; 

	public SpikeFactory() {
		super(1063.0, 275.0, 50, 50, 200);
		modeImages = AllBufferedImages.spikeFactoryModeImages;
		this.currentModeImage = modeImages[0];
		this.name = "Spike Factory";
		this.cost = 100;
		this.range = 60;
		this.hasRange = true;
		this.isRotating = false;
	}

	boolean checkIsPossible() {
		int distances[] = new int[4];
		distances[0] = Colors.getDistanceFromTheWall(point, Direction.UP);
		distances[1] = Colors.getDistanceFromTheWall(point, Direction.RIGHT);
		distances[2] = Colors.getDistanceFromTheWall(point, Direction.LEFT);
		distances[3] = Colors.getDistanceFromTheWall(point, Direction.DOWN);
		for (int distance : distances) {
			if (distance < range) {
				return true;
			}
		}
		return false;
	}

	@Override
	void shoot() {
		Random rnum = new Random();
		Point locatePoint;
		if (currentDirection == null || addSpikesDirection == 0) {
			addSpikesDirection = rnum.nextInt(2);
			if (addSpikesDirection == 0) {
				addSpikesDirection--;
			}
			currentDirection = Direction.randomDir();
		}
		locatePoint = getPointForDirection(point, currentDirection);
		int distance = Colors.getDistanceFromTheWall(locatePoint, currentDirection);
		locatePoint = getPotentialSpikePoint(currentDirection, distance);
		if (Path.isInPath(locatePoint) && Calculation.getDistance(new Point(point.getX() + width / 2, point.getY() + height / 2), locatePoint) < range) {
			Spikes newSpike = new Spikes(locatePoint, 10);
			shootIndex++;
		} else {
			shootIndex = 0;
			currentDirection = null;
			addSpikesDirection = 0;
			shoot();
		}
	}

	private Point getPotentialSpikePoint(Direction dir, int distance) {
		Point locatePoint;
		if (dir == Direction.UP) {
			locatePoint = new Point(point.getX() + shootIndex * 15 * addSpikesDirection + Spikes.SPIKES_WIDTH / 2, point.getY() - distance + MARGIN / 2);
		} else if (dir == Direction.DOWN) {
			locatePoint = new Point(point.getX() + shootIndex * 15 * addSpikesDirection + Spikes.SPIKES_WIDTH / 2, point.getY() + distance + height - Spikes.SPIKES_HEIGHT);
		} else if (dir == Direction.RIGHT) {
			locatePoint = new Point(point.getX() + distance + width - Spikes.SPIKES_WIDTH, point.getY() + shootIndex * 15 * addSpikesDirection + Spikes.SPIKES_HEIGHT / 2);
		} else {
			locatePoint = new Point(point.getX() - distance + MARGIN, point.getY() + shootIndex * 15 * addSpikesDirection + Spikes.SPIKES_HEIGHT / 2);
		}
		return locatePoint;
	}

	private Point getPointForDirection(Point point, Direction currentDirection) {
		if (currentDirection == Direction.LEFT) {
			return new Point(point.getX(), point.getY() + height / 2);
		} else if (currentDirection == Direction.DOWN) {
			return new Point(point.getX() + width / 2, point.getY() + height);
		} else if (currentDirection == Direction.RIGHT) {
			return new Point(point.getX() + width, point.getY() + height / 2);
		} 
		return new Point(point.getX() + width / 2, point.getY());
	}

	@Override
	public void drawShootingEffect(Graphics g) {
		
	}
	
	public static void locateSpikes() {
		
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
			if (shootIndex % 2 == 0 && !isOnToolbar) {
				currentModeImage = AllBufferedImages.spikeFactoryShoot;
			} else {
				currentModeImage = AllBufferedImages.spikeFactoryModeImages[0];
			}
		}
		if (firstBloonOnArea == null || isPressed || this instanceof SpikeFactory) {
			currentModeImage = lookAt();
		} else {
			if (this.lookAtPoint != null) {
				Point lookAtPoint = new Point(this.lookAtPoint.getX() + firstBloonOnArea.getWidth() / 2, this.lookAtPoint.getY() + firstBloonOnArea.getHeight() / 2);
				currentModeImage = lookAt(lookAtPoint);
			}
		}
		g.drawImage(currentModeImage, (int)point.getX(), (int)point.getY(), width, height, null);
	}

	private void debugShowSpikeDirections(Graphics g) {
		if (!isOnToolbar) {
			try {
				Point pointForDirection = getPointForDirection(point, Direction.RIGHT);
				g.setColor(Color.RED);
				int distance = Colors.getDistanceFromTheWall(pointForDirection, Direction.RIGHT);
				Point newPoint = getPotentialSpikePoint(Direction.RIGHT, distance);
				g.fillRect((int)(newPoint.getX()), (int)(newPoint.getY()), 5, 5);
				g.setColor(Color.BLUE);
				distance = Colors.getDistanceFromTheWall(getPointForDirection(point, Direction.LEFT), Direction.LEFT);
				newPoint = getPotentialSpikePoint(Direction.LEFT, distance);
				g.fillRect((int)(newPoint.getX()), (int)(newPoint.getY()), 5, 5);
				g.setColor(Color.GREEN);
				distance = Colors.getDistanceFromTheWall(getPointForDirection(point, Direction.DOWN), Direction.DOWN);
				newPoint = getPotentialSpikePoint(Direction.DOWN, distance);
				g.fillRect((int)(newPoint.getX()), (int)(newPoint.getY()), 5, 5);
				g.setColor(Color.YELLOW);
				distance = Colors.getDistanceFromTheWall(getPointForDirection(point, Direction.UP), Direction.UP);
				System.out.println(distance);
				newPoint = getPotentialSpikePoint(Direction.UP, distance);
				g.fillRect((int)(newPoint.getX()), (int)(newPoint.getY()), 5, 5);
			} catch (Exception e) {
				
			}
		}
	}
}
