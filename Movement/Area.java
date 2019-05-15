package Movement;

import Movement.Monkeys.Spikes;

public class Area{
	protected Point point;
	protected int width;
	protected int height;
	
	public Area(Point point, int width, int height) {
		this.point = point;
		this.width = width;
		this.height = height;
	}

	public Area(double x, double y , int width, int height) {
		this(new Point(x, y), width, height);
	}	
	
	public boolean isPointOnArea(double x, double y) {
		return (x <= point.getX() + this.width && x >= point.getX() && y <= point.getY() + this.height && y >= point.getY());
	}
	
	public boolean isPointOnArea(Point p) {
		return isPointOnArea(p.getX(), p.getY());
	}
	
	public boolean isAreaOnArea(double x, double y, double width, double height) {
		return isPointOnArea(x, y) && isPointOnArea(x + width, y)
				&& isPointOnArea(x, y + height) && isPointOnArea(x + width, y  + height);
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point p) {
		this.point = p;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Point getMiddlePos() {
		return new Point(point.getX() + width / 2, point.getY() + height / 2);
	}

}
