package Graphics;

import java.awt.Color;

import Graphics.Elements.AllBufferedImages;
import Movement.Direction;
import Movement.Path;
import Movement.Point;

public class Colors {
	
	public static Color getColorInPoint(Point p) {
		if (!Path.isInMap(p)) {
			return null;
		}
		int imagem = AllBufferedImages.path.getRGB((int)p.getX(), (int)p.getY());
		return new Color(imagem, false); 
	}
	
	public static double compareTwoColors(Color c1, Color c2) {
		return Math.sqrt(Math.pow(c2.getBlue()-c1.getBlue(), 2) + (Math.pow(c2.getGreen() - c1.getGreen(), 2)) + Math.pow(c2.getRed()-c1.getRed(), 2));
	}
	
	public static Color closerTo(Color color, Color c1, Color c2) {
		if (color == null) {
			return color;
		}
		return (compareTwoColors(color, c1) < compareTwoColors(color, c2))? c1: c2;
	}
	
	public static int getDistanceFromTheWall(Point p, Direction dir) {
		Color currentColor;
		Color obstacleColor = new Color(0, 0, 0);
		Color pathColor = new Color(255, 255, 255);
		int distanceX = 0;
		int distanceY = 0;
		do {
			int imagem = AllBufferedImages.path.getRGB((int)p.getX() + distanceX, (int)p.getY() + distanceY);
			currentColor = new Color(imagem, false); 
			if (dir == Direction.UP) {
				distanceY--;
			} else if (dir == Direction.DOWN) {
				distanceY++;
			} else if (dir == Direction.RIGHT) {
				distanceX++;
			} else {
				distanceX--;
			}
		} while (Colors.closerTo(currentColor, obstacleColor, pathColor) == pathColor);
		return Math.abs((distanceX != 0)? distanceX: distanceY);
	}
}
