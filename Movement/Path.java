package Movement;

import java.awt.Color;
import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;

import Graphics.Colors;
import Graphics.Elements.AllBufferedImages;
import Movement.Bloons.Bloon;
import mainPack.Calculation;

public class Path {
	private int state;
	private Bloon bloon;
	public static final double PATH_WIDTH = 32.324;

	public Path(Bloon bloon) {
		state = 0;
		this.bloon = bloon;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void checkTurn() {
		if (isTurnPoint()) {
			state++;
			if (state == 4) {
				state = 0;
			}
			turn();
		} 
	}
	
	public boolean isTurnPoint() {
		if (!isInMap(bloon.getPoint())) {
			return false;
		}
		Point p = new Point(bloon.getPoint().getX() + bloon.getWidth() / 2, bloon.getPoint().getY() + bloon.getHeight() / 2);
		Point checkPoint = new Point((int)(p.getX() + bloon.getvX() + (PATH_WIDTH / 2 * getDirection(bloon.getvX()))), (int)(p.getY() + bloon.getvY() + (PATH_WIDTH / 2 * getDirection(bloon.getvY()))));
		int imagem = AllBufferedImages.path.getRGB((int)checkPoint.getX(), (int)checkPoint.getY());
		Color nextColor = new Color(imagem, false);
		Color wallColor = new Color(0, 0, 0);
		Color pathColor = new Color(255, 255, 255);
		return Colors.closerTo(nextColor, wallColor, pathColor) == wallColor;
	}

	private int getDirection(double speed) {
		if (speed > 0) {
			return 1;
		} else if (speed < 0) {
			return -1;
		}
		return 0;
	}

	public Direction castStateToDirection(int state) {
		if (state == 0 || state == 2) {
			return Direction.RIGHT;
		} else if (state == 1) {
			return Direction.UP;
		} else {
			return Direction.DOWN;
		}
	}
	
	public static boolean isInPath(Point p) {
		Color currentColor = Colors.getColorInPoint(p);
		Color obstacleColor = new Color(0, 0, 0);
		Color pathColor = new Color(255, 255, 255);
		return (Colors.closerTo(currentColor, obstacleColor, pathColor) == pathColor);
	}
	
	public static boolean isInMap(Point p) {
		if (p.getX() > 946 || p.getX() < 0 || p.getY() < 0 || p.getY() > 637) {
			return false;
		}
		return true;
	}
	
	public void turn() {
		bloon.stop();
		if (state == 0 || state == 2) {
			bloon.runRight();
		} else if (state == 1) {
			bloon.runUp();
		} else if (state == 3) {
			bloon.runDown();
		}
	}
}
