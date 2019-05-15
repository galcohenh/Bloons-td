package Movement.Bloons;

import Movement.Point;

public class BloonFactory {
	public static Bloon createNewClone(Bloon bloonToCreate, Point location) {
		double x = location.getX();
		double y = location.getY();
		if (bloonToCreate instanceof BlueBloon) {
			return new BlueBloon(x, y);
		} else if (bloonToCreate instanceof GreenBloon) {
			return new GreenBloon(x, y);
		} else if (bloonToCreate instanceof YellowBloon) {
			return new YellowBloon(x, y);
		} else if (bloonToCreate instanceof PinkBloon) {
			return new PinkBloon(x, y);
		} else if (bloonToCreate instanceof BlackBloon) {
			return new BlackBloon(x, y);
		} else if (bloonToCreate instanceof ZebraBloon) {
			return new ZebraBloon(x, y);
		}
		return new RedBloon(x, y);
	}
}
