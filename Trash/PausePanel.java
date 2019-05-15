package Trash;
//package Graphics;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import Graphics.Elements.AllBufferedImages;
//import Graphics.Elements.InvisibleButton;
//import mainPack.GameBeats;
//
//public class PausePanel extends JPanel {
//	private boolean isRButtonOn = false;
//
//	private JFrame parent;
//	
//	public PausePanel(JFrame parent) {
//		parent.setSize(1229, 665);
//		setLayout(null);
//		//setStartGameButton();
//		this.parent = parent;
//	}
//
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		setBackground(Color.BLACK);
//		g.setColor(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//		g.fillRect(0, 0, 1139, 637);
//	}
//	
//	public void drawAllButtons(Graphics g) {
////		if (isStartGameButtonOn) {
////			g.fillRect(505, 565, 180, 45);
////			g.drawImage(AllBufferedImages.startGameBTN, 485, 545, 222, 87, null);
////		}
//	}
//	
//	public void setResumeButton() {
//		InvisibleButton startGame = new InvisibleButton("");
//		startGame.setBounds(485, 545, 222, 87);
//		startGame.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				isStartGameButtonClicked = true;
//				GameBeats.resume();
//				parent.add(GameBeats.getPanel());
//				parent.setSize(1139, 637);
//				setVisible(false);
//			}
//		});
//		startGame.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseEntered(MouseEvent evt) {
//				isStartGameButtonOn = true;
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				super.mouseExited(e);
//				isStartGameButtonOn = false;
//			}
//			
//		});
//		if (GameBeats.getPanel() != null) {
//			GameBeats.getPanel().add(startGame);
//		}
//		add(startGame);
//	}
//	
//	public void setHomeButton() {
//		InvisibleButton startGame = new InvisibleButton("");
//		startGame.setBounds(485, 545, 222, 87);
//		startGame.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				isStartGameButtonClicked = true;
//				GameBeats.resume();
//				parent.add(GameBeats.getPanel());
//				parent.setSize(1139, 637);
//				setVisible(false);
//			}
//		});
//		startGame.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseEntered(MouseEvent evt) {
//				isStartGameButtonOn = true;
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				super.mouseExited(e);
//				isStartGameButtonOn = false;
//			}
//			
//		});
//		if (GameBeats.getPanel() != null) {
//			GameBeats.getPanel().add(startGame);
//		}
//		add(startGame);
//	}
//	
//	public void setRestartButton() {
//		InvisibleButton restartButton = new InvisibleButton("");
//		restartButton.setBounds(485, 545, 222, 87);
//		restartButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				isStartGameButtonClicked = true;
//				parent.add(GameBeats.getPanel());
//				setVisible(false);
//			}
//		});
//		restartButton.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseEntered(MouseEvent evt) {
//				isStartGameButtonOn = true;
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				super.mouseExited(e);
//				isStartGameButtonOn = false;
//			}
//			
//		});
//		if (GameBeats.getPanel() != null) {
//			GameBeats.getPanel().add(restartButton);
//		}
//		add(restartButton);
//	}
//	
//}