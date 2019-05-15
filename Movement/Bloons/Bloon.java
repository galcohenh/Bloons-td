package Movement.Bloons;

import java.awt.Graphics;
import java.io.IOException;

import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;
import Movement.Moveable;
import Movement.Path;

public abstract class Bloon extends Moveable implements Drawable {
	private final static double PATH_WIDTH = 32.324;
	private Path path;
	private int distanceFromNext;
	protected int damage;
	protected int hp;
	protected Bloon son;
	protected int numOfSons;
	protected int cost;
	protected double startRoute;
	private boolean visitedMap = false;
	private boolean isGlued = false;
	
	public Bloon(double x, double y, int width, int height) {
		super(x, y + PATH_WIDTH / 2 - height / 2, width, height);
		this.startRoute = y + PATH_WIDTH / 2 - height / 2;
		this.width = width;
		this.height = height;
		this.path = new Path(this);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Bloon(double x, double y, int width,int height, int distanceFromNext) throws IOException {
		this(x, y, width, height);
		this.setDistanceFromNext(distanceFromNext);
	}

	public int getDistanceFromNext() {
		return distanceFromNext;
	}

	public void setDistanceFromNext(int distanceFromNext) {
		this.distanceFromNext = distanceFromNext;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public abstract void explosive();
	
	@Override
	public boolean wentThroughMap()
	{
		if (!Path.isInMap(point)) {
			if (visitedMap) {
				return true;
			}
		} else {
			visitedMap = true;
		}
		return false;
	}
	
	public Bloon getSon() {
		return son;
	}

	public void setSon(Bloon son) {
		this.son = son;
	}

	public int getNumOfSons() {
		return numOfSons;
	}

	public void setNumOfSons(int numOfSons) {
		this.numOfSons = numOfSons;
	}
	
	abstract public void bloonDamaged(int damage);

	public boolean isGlued() {
		return isGlued;
	}

	public void setGlued(boolean isGlued) {
		if (!this.isGlued) {
			this.maxXSpeed = this.maxXSpeed / 2;
			this.maxYSpeed = this.maxYSpeed / 2;
		}
		this.isGlued = isGlued;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if (isGlued) {
			g.drawImage(AllBufferedImages.glue, (int)point.getX(), (int)point.getY(), 35, 36, null);
		}
	}
}
