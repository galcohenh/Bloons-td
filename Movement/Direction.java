package Movement;

import java.util.Random;

/**
 * 
 * @author PC11
 * Direction is the moving direction of the figures
 */
public enum Direction {
	UP, LEFT, DOWN, RIGHT;
	
	/**
	 * 
	 * @return random direction
	 */
	public static Direction randomDir() {
		Random rnum = new Random();
		int num = rnum.nextInt(4);
		return (num == 0)? UP: (num == 1)? RIGHT: (num == 2)? LEFT: DOWN;
	}
	
	/**
	 * 
	 * @return random up or down direction
	 */
	public static Direction randomUpAndDown() {
		Random rnum = new Random();
		int num = rnum.nextInt(2);
		return (num == 0)? UP:  DOWN;
	}
	
	/**
	 * 
	 * @return random left or right direction
	 */
	public static Direction randomLeftAndRight() {
		Random rnum = new Random();
		int num = rnum.nextInt(2);
		return (num == 0)? RIGHT:  LEFT;
	}
}
