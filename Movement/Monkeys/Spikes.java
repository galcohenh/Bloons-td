package Movement.Monkeys;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;
import Movement.Area;
import Movement.Point;

public class Spikes extends Area implements Drawable {
	public static List<Spikes> allSpikesList = null;
	private int spikesNum;
	public final static int SPIKES_WIDTH = 32;
	public final static int SPIKES_HEIGHT = 33;
	
	public Spikes(Point point, int spikesNum) {
		super(point, SPIKES_WIDTH, SPIKES_HEIGHT);
		if (allSpikesList == null) {
			allSpikesList = new ArrayList<Spikes>();
		}
		allSpikesList.add(this);
		this.spikesNum = spikesNum;
	}
	
	public void removeSpike() {
		spikesNum--;
		if (spikesNum == 0) {
			allSpikesList.remove(this);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(AllBufferedImages.spikeFactorySpikes, (int)point.getX(), (int)point.getY(), width, height, null);
	}
	
}
