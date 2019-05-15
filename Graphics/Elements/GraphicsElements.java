package Graphics.Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import Graphics.GraphicsPanel;
import mainPack.Game;
import mainPack.GameBeats;

public class GraphicsElements {
	private final static int GAME_OVER_WIDTH = 388;
	private final static int GAME_OVER_HEIGHT = 314;
	
	private final static int SETTINGS_MODE_HOME_X = 455;
	private final static int SETTINGS_MODE_BTN_Y = 250;
	private final static int SETTINGS_MODE_SELECTED_BTN_Y = 245;
	private final static int GAME_OVER_MODE_HOME_X = 405;
	private final static int GAME_OVER_MODE_BTN_Y = 450;
	private final static int GAME_OVER_MODE_SELECTED_BTN_Y = 445;
	
	private GraphicsPanel mainPanel;
	private boolean isSettingsButtonOn = false;
	private boolean isSettingsClicked = false;
	private boolean isResumeButtonOn = false;
	private boolean isHomeButtonOn = false;
	private boolean isResartButtonOn = false;
	
	public GraphicsElements(GraphicsPanel mainPanel) {
		this.mainPanel = mainPanel;
		setSettingsButton();
		setResumeButton();
		setHomeButton();
		setRestartButton();
		setGameOverHomeButton();
		setGameOverRestartButton();
	}
	
	public void drawBackground(Graphics g) {
		Dimension d = mainPanel.getSize();
		g.drawImage(AllBufferedImages.backgroundImage, 0, 0, d.width, d.height, null);
	}
	
	public void drawAllButtons(Graphics g) {
		if (isSettingsButtonOn) {
			g.drawImage(AllBufferedImages.settingsBTN, 885, 2, 58, 58, null);
		}
	}
	
	public void drawSettingPanel(Graphics g) {
		g.drawImage(AllBufferedImages.settingsTitle, 406, 151, 222, 87, null);
		if (isResumeButtonOn) {
			g.drawImage(AllBufferedImages.selectedRunBTN, 325, SETTINGS_MODE_SELECTED_BTN_Y, 94, 92, null);
		} else {
			g.drawImage(AllBufferedImages.runBTN, 325, SETTINGS_MODE_BTN_Y, 80, 78, null);
		}
		if (isHomeButtonOn) {
			g.drawImage(AllBufferedImages.selectedHomeBTN, SETTINGS_MODE_HOME_X, SETTINGS_MODE_SELECTED_BTN_Y, 94, 94, null);
		} else {
			g.drawImage(AllBufferedImages.homeBTN, SETTINGS_MODE_HOME_X, SETTINGS_MODE_BTN_Y, 80, 80, null);
		}
		if (isResartButtonOn) {
			g.drawImage(AllBufferedImages.selectedRestartBTN, 585, SETTINGS_MODE_SELECTED_BTN_Y, 89, 87, null);
		} else {
			g.drawImage(AllBufferedImages.restartBTN, 585, SETTINGS_MODE_BTN_Y, 75, 73, null);
		}
	}
	
	public void drawgGameOverPanel(Graphics g) {
		g.drawImage(AllBufferedImages.gameOver, 350, 100, GAME_OVER_WIDTH, GAME_OVER_HEIGHT, null);
		if (isHomeButtonOn) {
			g.drawImage(AllBufferedImages.selectedHomeBTN, GAME_OVER_MODE_HOME_X, GAME_OVER_MODE_SELECTED_BTN_Y, 94, 94, null);
		} else {
			g.drawImage(AllBufferedImages.homeBTN, GAME_OVER_MODE_HOME_X, GAME_OVER_MODE_BTN_Y, 80, 80, null);
		}
		if (isResartButtonOn) {
			g.drawImage(AllBufferedImages.selectedRestartBTN, 585, GAME_OVER_MODE_SELECTED_BTN_Y, 89, 87, null);
		} else {
			g.drawImage(AllBufferedImages.restartBTN, 585, GAME_OVER_MODE_BTN_Y, 75, 73, null);
		}
	}
	
	public void pauseGame(Graphics g) {
		g.setColor(new Color(0.1f, 0.1f, 0.1f, 0.7f));
		g.fillRect(0, 0, 1139, 637);
		drawSettingPanel(g);
	}
	
	public void gameOver(Graphics g) {
		g.setColor(new Color(0.1f, 0.1f, 0.1f, 0.7f));
		g.fillRect(0, 0, 1139, 637);
		drawgGameOverPanel(g);
	}
	
	public void setSettingsButton() {
		InvisibleButton settings = new InvisibleButton("");
		settings.setBounds(885, 3, 58, 58);
		settings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!GameBeats.isPaused() && Game.getHp() > 0) {
					GameBeats.pause();
					setSettingsClicked(true);
				}
			}
		});
		settings.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				if (!GameBeats.isPaused() && Game.getHp() > 0) {
					isSettingsButtonOn = true;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				isSettingsButtonOn = false;
			}
			
		});
		if (GameBeats.getPanel() != null) {
			GameBeats.getPanel().add(settings);
		}
		mainPanel.add(settings);
	}
	
	public void setResumeButton() {
		final InvisibleButton resume = new InvisibleButton("");
		resume.setBounds(325, 250, 80, 78);
		resume.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(resume);
				if (GameBeats.isPaused()) {
					isSettingsClicked = false;
					GameBeats.resume();
					System.out.println("resume");
				}
			}
		});
		resume.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				if (GameBeats.isPaused()) {
					isResumeButtonOn = true;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				isResumeButtonOn = false;
			}
			
		});
		if (GameBeats.getPanel() != null) {
			GameBeats.getPanel().add(resume);
		}
		mainPanel.add(resume);
	}
	
	public void setHomeButton() {
		InvisibleButton resume = new InvisibleButton("");
		resume.setBounds(SETTINGS_MODE_HOME_X, SETTINGS_MODE_BTN_Y, 80, 78);
		resume.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!GameBeats.isPaused()) {
					return;
				}
				Game.resetAll();
				System.out.println("home");
				try {
					GameBeats.getFrame().setVisible(false);
					GameBeats gameBeats = new GameBeats();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		resume.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				if (GameBeats.isPaused()) {
					isHomeButtonOn = true;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				isHomeButtonOn = false;
			}
			
		});
		if (GameBeats.getPanel() != null) {
			GameBeats.getPanel().add(resume);
		}
		mainPanel.add(resume);
	}
	
	public void setGameOverHomeButton() {
		InvisibleButton resume = new InvisibleButton("");
		resume.setBounds(GAME_OVER_MODE_HOME_X, GAME_OVER_MODE_BTN_Y, 80, 78);
		resume.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Game.getHp() > 0) {
					return;
				}
				Game.resetAll();
				System.out.println("home");
				try {
					GameBeats.getFrame().setVisible(false);
					GameBeats gameBeats = new GameBeats();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		resume.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				if (Game.getHp() > 0) {
					return;
				}
				isHomeButtonOn = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				isHomeButtonOn = false;
			}
			
		});
		if (GameBeats.getPanel() != null) {
			GameBeats.getPanel().add(resume);
		}
		mainPanel.add(resume);
	}
	
	public void setRestartButton() {
		InvisibleButton restart = new InvisibleButton("");
		restart.setBounds(585, SETTINGS_MODE_BTN_Y, 80, 78);
		restart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!GameBeats.isPaused()) {
					return;
				}
				Game.resetAll();
			}
		});
		restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent evt) {
				if (GameBeats.isPaused()) {
					isResartButtonOn = true;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				isResartButtonOn = false;
			}
			
		});
		if (GameBeats.getPanel() != null) {
			GameBeats.getPanel().add(restart);
		}
		mainPanel.add(restart);
	}
	
	public void setGameOverRestartButton() {
		final InvisibleButton restart = new InvisibleButton("");
		restart.setBounds(585, GAME_OVER_MODE_BTN_Y, 80, 78);
		restart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.remove(restart);
				System.out.println("restart");
				if (Game.getHp() > 0) {
					return;
				}
				Game.resetAll();
			}
		});
		restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent evt) {
				if (Game.getHp() > 0) {
					return;
				}
				isResartButtonOn = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				isResartButtonOn = false;
			}
			
		});
		if (GameBeats.getPanel() != null) {
			GameBeats.getPanel().add(restart);
		}
		mainPanel.add(restart);
	}
	
	public void drawToolbar(Graphics g) {
		Dimension d = mainPanel.getSize();
		g.drawImage(AllBufferedImages.toolbarImage, 946, 0, 193, d.height, null);
		g.drawImage(AllBufferedImages.hPImage, 0, 0, 50, 50, null);
		g.drawImage(AllBufferedImages.coinsImage, 108, 5, 40, 40, null);
	}

	public boolean isSettingsClicked() {
		return isSettingsClicked;
	}

	public void setSettingsClicked(boolean isSettingsClicked) {
		this.isSettingsClicked = isSettingsClicked;
	}
}
