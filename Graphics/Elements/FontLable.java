package Graphics.Elements;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Movement.Point;

public class FontLable {
	private String lableName;
	private Point location;
	private String text;
	private Graphics g;
	private final int CHAR_WIDTH = 21;
	private final int CHAR_HEIGHT = 25;
	
	public FontLable(String lableName, Point location, String text, Graphics g) {
		this.lableName = lableName;
		this.location = location;
		this.g = g;
		updateText(text);
	}
	
	public void updateText(String text) {
		this.text = text;
		draw();
	}

	public void draw() {
		BufferedImage nextCharToDraw;
		for (int i = 0; i < text.length(); i++) {
			//zero
			nextCharToDraw = AllBufferedImages.zero;
			if (text.charAt(i) == '1') {
				nextCharToDraw = AllBufferedImages.one;
			} else if (text.charAt(i) == '2') {
				nextCharToDraw = AllBufferedImages.two;
			} else if (text.charAt(i) == '3') {
				nextCharToDraw = AllBufferedImages.three;
			} else if (text.charAt(i) == '4') {
				nextCharToDraw = AllBufferedImages.four;
			} else if (text.charAt(i) == '5') {
				nextCharToDraw = AllBufferedImages.five;
			} else if (text.charAt(i) == '6') {
				nextCharToDraw = AllBufferedImages.six;
			} else if (text.charAt(i) == '7') {
				nextCharToDraw = AllBufferedImages.seven;
			} else if (text.charAt(i) == '8') {
				nextCharToDraw = AllBufferedImages.eight;
			} else if (text.charAt(i) == '9') {
				nextCharToDraw = AllBufferedImages.nine;
			}
			g.drawImage(nextCharToDraw, (int)location.getX() + CHAR_WIDTH * i, (int)location.getY(), CHAR_WIDTH, CHAR_HEIGHT, null);
		}
	}
	
}
