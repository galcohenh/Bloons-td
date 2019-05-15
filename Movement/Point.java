package Movement;

/**
 * 
 * @author PC11
 * Point useful for describing location
 */
public class Point {
	private double x;
	private double y;
	
	/**
	 * 
	 * @param x x position
	 * @param y y position
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param point point to create
	 */
	public Point(Point point) {
		this(point.getX(), point.getY());
	}
	
	/**
	 * 
	 * @return x position
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @param x x position
	 * setting the x position
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return y position
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * 
	 * @param y y position
	 * setting the y position
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @return copy of the point
	 */
	public Point getCopy() {
		return new Point(x, y);
	}
	
	/**
	 * 
	 * @param p point
	 * setting the point position on the current point 
	 */
	public void insertPoint(Point p) {
		setX(p.getX());
		setY(p.getY());
	}
	
	/**
	 * 
	 * @param p point
	 * @return is the points equal
	 */
	public boolean equals(Point p) {
		if ((int)p.getX() == (int)x && (int)p.getY() == (int)y) {
			return true;
		} 
		return false;
	}
	
	/**
	 * @return description of the point
	 */
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y;
	}
}
