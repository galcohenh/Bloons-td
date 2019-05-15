package Movement.Monkeys;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import Events.BloonDisappearanceEvent;
import Events.EventHandler;
import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.ImageTool;
import Movement.Point;
import Movement.Vector2D;
import mainPack.Calculation;
import mainPack.Game;

public class Port extends Monkey {
	
	private Heli heli;
	
	public Port() {
		super(971.0, 365.0, 50, 50, 0);
		modeImages = AllBufferedImages.portModeImages;
		this.currentModeImage = modeImages[0];
		this.name = "Heli Pilot";
		this.cost = 100;
		this.range = 60;
		this.hasRange = true;
		this.isRotating = false;
	}
	
	@Override
	void shoot() {

	}

	@Override
	public void timePassed() {
		if (heli != null) {
			heli.timePassed();
		}
	}
	
	@Override
	public void drawShootingEffect(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BufferedImage lookAt(Point point) {
		double rotationRequired = Calculation.getAngleBetweenTwoPoints(new Point(this.point.getX() + width / 2, this.point.getY() + height / 2), point);
		return ImageTool.rotate(currentModeImage, rotationRequired + Math.PI / 2);
	}
	
	@Override
	public BufferedImage lookAt() {
		return lookAt(new Point(this.point.getX() + width / 2, this.point.getY() - 1));
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if(heli != null) {
			heli.draw(g);
		}
	}

	public Heli getHeli() {
		return heli;
	}

	public void setHeli(Heli heli) {
		this.heli = heli;
	}
}
