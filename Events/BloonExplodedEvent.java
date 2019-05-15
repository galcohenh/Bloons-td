package Events;

import java.util.ArrayList;
import java.util.List;

import Graphics.Elements.Drawable;
import Movement.Path;
import Movement.Point;
import Movement.Bloons.Bloon;

public class BloonExplodedEvent {
	private Bloon bloon;
	
	public BloonExplodedEvent(Bloon bloon) {
		this.setBloon(bloon);
	}

	public Bloon getBloon() {
		return bloon;
	}

	public void setBloon(Bloon bloon) {
		this.bloon = bloon;
	}
	
	public Point getSonLoc(int i) {
		return bloon.getPoint();
	}

	public void addBloonSons(ArrayList<Bloon> bloons) {
		int addingPos = bloons.indexOf(bloon);
		if (addingPos < 0) {
			return;
		}
		Bloon bloonToAdd;
		for (int i = 1; i <= bloon.getNumOfSons(); i++) {
			bloonToAdd = bloon.getSon();
			Path newPath = bloonToAdd.getPath();
			newPath.setState((bloon.getPath().getState()) % 4);
			newPath.turn();
			newPath.setState((bloon.getPath().getState()));
			bloonToAdd.setPoint(getSonLoc(i));
			bloons.add(addingPos, bloonToAdd);
		}
	}
	
	public void addBloonSonsToDrawList(List<Drawable> objectsToDraw) {
		int addingPos = objectsToDraw.indexOf(bloon);
		if (addingPos < 0) {
			return;
		}
		Bloon bloonToAdd;
		for (int i = 1; i <= bloon.getNumOfSons(); i++) {
			bloonToAdd = bloon.getSon();
			objectsToDraw.add(addingPos, bloonToAdd);
		}
	}
}
