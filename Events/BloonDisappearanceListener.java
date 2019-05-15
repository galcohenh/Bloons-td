package Events;

public interface BloonDisappearanceListener {
	void bloonPopped(BloonDisappearanceEvent event);
	void bloonInvaded(BloonDisappearanceEvent event);
	//void bloonDisappeared(BloonDisappearanceEvent event);
}
