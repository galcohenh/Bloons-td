package mainPack;

import Movement.Point;

public class Calculation {
	public static int roundToDivider(int num, int devider) {
		int downResult = num, upResult = num;
		for (; downResult % devider != 0 ; downResult--);
		for (; upResult % devider != 0 ; upResult++);
		return (upResult - num > num - downResult)? downResult: upResult;
	}
	
	public static double getAngleBetweenTwoPoints(Point point1, Point point2) {
		return Math.atan2((point2.getY() - point1.getY()), (point2.getX() - point1.getX()));
	}
	
	public static double getDistance(Point point1, Point point2) {
		return (Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + 
				Math.pow(point2.getY() - point1.getY(), 2)));
	}
}
