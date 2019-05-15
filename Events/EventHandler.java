package Events;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {

	private List<BloonDisappearanceListener> bloonDisappearanceListeners;
	private List<BloonExplodedListener> bloonExplodedListeners;

	private static EventHandler instance = null;
	
	public static EventHandler getInstance() {
		if (instance == null) {
			instance = new EventHandler();
		}
		return instance;
	}
	
	public EventHandler() {
		bloonDisappearanceListeners = new ArrayList<BloonDisappearanceListener>();
		bloonExplodedListeners = new ArrayList<BloonExplodedListener>();
	}
	
	public void addBloonDisappearanceListener(BloonDisappearanceListener listener) {
		bloonDisappearanceListeners.add(listener);
	}
	
	public void addBloonExplodedListener(BloonExplodedListener listener) {
		bloonExplodedListeners.add(listener);
	}
	
	public void notifyBloonExplodedListeners(BloonExplodedEvent event) {
		for (BloonExplodedListener explodedListener : bloonExplodedListeners) {
			explodedListener.bloonExploded(event);
		}
	}
	
	public void notifyBloonDisappearanceListeners(BloonDisappearanceEvent event) {
		for (BloonDisappearanceListener disappearanceListener : bloonDisappearanceListeners) {
			if (event.isPopEvent()) {
				disappearanceListener.bloonPopped(event);
			} else {
				disappearanceListener.bloonInvaded(event);
			}
		}
	}
}
