package Graphics.Elements;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Movement.Area;
import Movement.Point;
import mainPack.GameBeats;

public class DrawPop extends Area implements ActionListener, Drawable{
	private Timer t;
	
	public DrawPop(Point p) {
		super(p, 52, 51);
		setTimer();
	}

	private void setTimer() {
		t = new Timer(100, this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		GameBeats.getPanel().removeFromDrawList(this);
		t.stop();
		t = null;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(AllBufferedImages.popImage, (int) point.getX(), (int) point.getY(), width, height, null);
		
	}
	
}
