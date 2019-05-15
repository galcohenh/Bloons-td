package Movement;

import java.util.ArrayList;

/**
 * 
 * @author PC11
 *	we can't place monkey on for bidden area
 */
public class ForbiddenAreas {
	private static ArrayList<Area> forbiddenAreas;
	
	public ForbiddenAreas() {
		forbiddenAreas = new ArrayList<Area>();
		forbiddenAreas.add(new Area(299, 115, 78, 310));
		forbiddenAreas.add(new Area(268, 196, 105, 270));
		forbiddenAreas.add(new Area(407, 121, 125, 397));
		forbiddenAreas.add(new Area(373, 121, 40, 30));
		forbiddenAreas.add(new Area(0, 0, 946, 40));
		forbiddenAreas.add(new Area(0, 0, 35, 637));
		forbiddenAreas.add(new Area(0, 568, 946, 40));
		forbiddenAreas.add(new Area(908, 0, 40, 637));
		forbiddenAreas.add(new Area(566, 120, 83, 335));
		forbiddenAreas.add(new Area(647, 197, 33, 258));
		forbiddenAreas.add(new Area(193, 196, 80, 33));
		forbiddenAreas.add(new Area(193, 200, 33, 205));
		forbiddenAreas.add(new Area(111, 269, 34, 134));
		forbiddenAreas.add(new Area(139, 371, 55, 33));
		forbiddenAreas.add(new Area(32, 269, 80, 33));
		forbiddenAreas.add(new Area(32, 269, 33, 95));
		forbiddenAreas.add(new Area(515, 120, 95, 33));
		forbiddenAreas.add(new Area(665, 195, 87, 33));
		forbiddenAreas.add(new Area(721, 200, 33, 200));
		forbiddenAreas.add(new Area(741, 372, 97, 30));
		forbiddenAreas.add(new Area(803, 268, 35, 110));
		forbiddenAreas.add(new Area(818, 267, 90, 33));
		forbiddenAreas.add(new Area(885, 267, 33, 93));
		forbiddenAreas.add(new Area(850, 504, 63, 65));
		forbiddenAreas.add(new Area(30, 504, 65, 65));
		forbiddenAreas.add(new Area(32, 32, 67, 45));
		forbiddenAreas.add(new Area(851, 32, 67, 45));
	}
	
	public static void addForbiddenArea(Area area) {
		forbiddenAreas.add(area);
	}
	
	/**
	 * 
	 * @param x x location of the point
	 * @param y y location of the point
	 * @return is the point on the forbidden areas
	 */
	public boolean isOnForbiddenAreas(double x, double y) {
		for (Area area : forbiddenAreas) {
			if (area.isPointOnArea(x, y)) {
				return true;
			}
		}
		return false;
	}
}
