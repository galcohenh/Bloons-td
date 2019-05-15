package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphics.Elements.AllBufferedImages;
import Graphics.Elements.InvisibleButton;
import mainPack.GameBeats;

public class StartGamePanel extends JPanel {
	private boolean isStartGameButtonOn = false;
	private JFrame parent;
	
	public StartGamePanel(JFrame parent) {
		parent.setSize(1229, 665);
		setLayout(null);
		setStartGameButton();
		this.parent = parent;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		g.drawImage(AllBufferedImages.startPanel, 0, 0, 1229, 627, null);
		g.setColor(Color.WHITE);
		drawAllButtons(g);
	}
	
	public void drawAllButtons(Graphics g) {
		if (isStartGameButtonOn) {
			g.fillRect(505, 565, 180, 45);
			g.drawImage(AllBufferedImages.startGameBTN, 485, 545, 222, 87, null);
		}
	}
	
	public void setStartGameButton() {
		InvisibleButton startGame = new InvisibleButton("");
		startGame.setBounds(485, 545, 222, 87);
		final JPanel thisPanel = this;
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameBeats.resume();
				parent.add(GameBeats.getPanel());
				parent.setSize(1139, 637);
				System.out.println("new game started!");
				parent.remove(thisPanel);
				parent.validate();
				parent.setVisible(true);
			}
		});
		startGame.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				isStartGameButtonOn = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				isStartGameButtonOn = false;
			}
			
		});
		if (GameBeats.getPanel() != null) {
			GameBeats.getPanel().add(startGame);
		}
		add(startGame);
	}
	
}
