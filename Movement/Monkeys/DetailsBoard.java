package Movement.Monkeys;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.Drawable;
import Graphics.Elements.InvisibleButton;
import Movement.Area;
import Movement.Point;
import mainPack.GameBeats;

public class DetailsBoard extends Area implements Drawable {
	private final static int DETAILS_BOARD_WIDTH = 650;
	private final static int DETAILS_BOARD_HEIGHT = 100;
	private final static int DETAILS_BOARD_X = 148;
	private final static int DETAILS_BOARD_Y = 447;
	private boolean isOn = false;
	private Monkey monkey;
	
	public DetailsBoard(Monkey monkey) {
		super(DETAILS_BOARD_X, DETAILS_BOARD_Y, DETAILS_BOARD_WIDTH, DETAILS_BOARD_HEIGHT);
		this.monkey = monkey;
		if (monkey instanceof Port) {
			setLeftArrowButton();
			setRightArrowButton();
		}
	}

	@Override
	public void draw(Graphics g) {
		if (!isOn) {
			return;
		}
		g.fillRect((int)point.getX(), (int)point.getY(), width, height);
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g.drawRect((int)point.getX(), (int)point.getY(), width, height);
		if (monkey instanceof DartMonkey) {
			g.drawImage(AllBufferedImages.dartMonkeyIcon, 160, 460, 70, 70, null);
		} else if (monkey instanceof TackShooter) {
			g.drawImage(AllBufferedImages.tackShooterIcon, 160, 460, 65, 70, null);
		} else if (monkey instanceof SniperMonkey) {
			g.drawImage(AllBufferedImages.sniperMonkeyIcon, 160, 460, 50, 70, null);
		} else if (monkey instanceof Port) {
			g.drawImage(AllBufferedImages.leftArrowImage, 330, 470, 50, 50, null);
			g.drawImage(AllBufferedImages.boardImage, 380, 470, 200, 50, null);
			g.drawImage(AllBufferedImages.rightArrowImage, 580, 470, 50, 50, null);
		} else if (monkey instanceof MortarMonkey) {
			Point boomPoint = ((MortarMonkey) monkey).getBoomPoint();
			g.drawImage(AllBufferedImages.intention, (int)boomPoint.getX(), (int)boomPoint.getY(), 80, 80, null);
		}
	}
	

	public void setLeftArrowButton() {
		InvisibleButton leftArrow = new InvisibleButton("");
		leftArrow.setBounds(330, 470, 50, 50);
		leftArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isOn) {
					return;
				}
				System.out.println("left");
			}
		});
		GameBeats.getPanel().add(leftArrow);
	}
	
	public void setRightArrowButton() {
		InvisibleButton rightArrow = new InvisibleButton("");
		rightArrow.setBounds(580, 470, 50, 50);
		rightArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isOn) {
					return;
				}
				System.out.println("RIGHT");
			}
		});
		GameBeats.getPanel().add(rightArrow);
	}
	
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
}
