package Events;

import Movement.Bloons.Bloon;

public class BloonDisappearanceEvent {
	private Bloon bloon;
	private boolean isPopEvent;
	
	public BloonDisappearanceEvent(Bloon bloon, boolean isPopEvent) {
		this.setBloon(bloon);
		this.setPopEvent(isPopEvent);
	}

	public Bloon getBloon() {
		return bloon;
	}

	public void setBloon(Bloon bloon) {
		this.bloon = bloon;
	}

	public boolean isPopEvent() {
		return isPopEvent;
	}

	public void setPopEvent(boolean isPopEvent) {
		this.isPopEvent = isPopEvent;
	}
}
