package mainPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import Movement.Point;
import Movement.Bloons.Bloon;
import Movement.Bloons.BloonFactory;
import Movement.Bloons.BlueBloon;
import Movement.Bloons.GreenBloon;
import Movement.Bloons.PinkBloon;
import Movement.Bloons.RedBloon;
import Movement.Bloons.BlackBloon;
import Movement.Bloons.YellowBloon;
import Movement.Bloons.ZebraBloon;
import Movement.Monkeys.Spikes;

public class Level implements ActionListener{
	private static int currentLevel;
	private List<Bloon> currentBloons;
	private Timer addBloonTimer;
	private Timer levelUpTimer;
	
	private int currentBloonsCounter = 0;
	private Bloon nextBloonToAdd;
	private Point nextBloonLocation;
	private int groupsAmount;
	
	
	private void setTimer(int addDifference) {
		addBloonTimer = new Timer(addDifference, this);
		addBloonTimer.start();
	}
	
	public static int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public List<Bloon> getCurrentBloons() {
		return currentBloons;
	}

	public void setCurrentBloons(List<Bloon> currentBloons) {
		this.currentBloons = currentBloons;
	}
	
	public Level() {
		this.currentBloons = new ArrayList<Bloon>() ;
		this.currentLevel = 1;
		buildLevel(1);
	}
	
	/**
	 * calling the building levels functions
	 * @param level level number to build
	 */
	public void buildLevel(int level) {
		if (level == 1) {
			groupsAmount = 1;
			nextBloonToAdd = new RedBloon(-100.0, 250.0);
			currentBloonsCounter = 20;
			setTimer(500);
		} else if (level == 2) {
			groupsAmount = 1;
			nextBloonToAdd = new RedBloon(-100.0, 330.0);
			currentBloonsCounter = 30;
			setTimer(400);
		} else if (level == 3) {
			if (groupsAmount == 0) {
				groupsAmount = 2;
				nextBloonToAdd = new RedBloon(-100.0, 330.0);
				currentBloonsCounter = 20;
				setTimer(350);
			} else {
				nextBloonToAdd = new BlueBloon(-100.0, 330.0);
				currentBloonsCounter = 5;
				setTimer(350);
			}
		} else if (level == 4) {
			if (groupsAmount == 0) {
				groupsAmount = 2;
				nextBloonToAdd = new RedBloon(-100.0, 330.0);
				currentBloonsCounter = 30;
				setTimer(350);
			} else {
				nextBloonToAdd = new BlueBloon(-100.0, 330.0);
				currentBloonsCounter = 15;
				setTimer(350);
			}
		} else if (level == 5) {
			if (groupsAmount == 0) {
				groupsAmount = 2;
				nextBloonToAdd = new RedBloon(-100.0, 330.0);
				currentBloonsCounter = 5;
				setTimer(350);
			} else {
				nextBloonToAdd = new BlueBloon(-100.0, 330.0);
				currentBloonsCounter = 25;
				setTimer(350);
			}
		} else if (level == 6) {
			if (groupsAmount == 0) {
				groupsAmount = 3;
				nextBloonToAdd = new RedBloon(-100.0, 330.0);
				currentBloonsCounter = 15;
				setTimer(200);
			} else if (groupsAmount == 1) {
				nextBloonToAdd = new GreenBloon(-100.0, 330.0);
				currentBloonsCounter = 4;
				setTimer(300);
			} else {
				nextBloonToAdd = new BlueBloon(-100.0, 330.0);
				currentBloonsCounter = 15;
				setTimer(300);
			}
		} else if (level == 7) {
				if (groupsAmount == 0) {
					groupsAmount = 3;
					nextBloonToAdd = new RedBloon(-100.0, 330.0);
					currentBloonsCounter = 20;
					setTimer(250);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 5;
					setTimer(300);
				} else {
					nextBloonToAdd = new BlueBloon(-100.0, 330.0);
					currentBloonsCounter = 25;
					setTimer(300);
				}
			} else if (level == 8) {
				if (groupsAmount == 0) {
					groupsAmount = 3;
					nextBloonToAdd = new RedBloon(-100.0, 330.0);
					currentBloonsCounter = 10;
					setTimer(200);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 14;
					setTimer(300);
				} else {
					nextBloonToAdd = new BlueBloon(-100.0, 330.0);
					currentBloonsCounter = 20;
					setTimer(300);
				}
			} else if (level == 9) {
				groupsAmount = 1;
				nextBloonToAdd = new GreenBloon(-100.0, 250.0);
				currentBloonsCounter = 30;
				setTimer(350);
			} else if (level == 10) {
				groupsAmount = 1;
				nextBloonToAdd = new BlueBloon(-100.0, 250.0);
				currentBloonsCounter = 104;
				setTimer(350);
			} else if (level == 11) {
				if (groupsAmount == 0) {
					groupsAmount = 4;
					nextBloonToAdd = new RedBloon(-100.0, 330.0);
					currentBloonsCounter = 10;
					setTimer(250);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 2;
					setTimer(350);
				} else if (groupsAmount == 2) {
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 12;
					setTimer(350);
				} else {
					nextBloonToAdd = new BlueBloon(-100.0, 330.0);
					currentBloonsCounter = 10;
					setTimer(350);
				}
			} else if (level == 12) {
				if (groupsAmount == 0) {
					groupsAmount = 3;
					nextBloonToAdd = new BlueBloon(-100.0, 330.0);
					currentBloonsCounter = 15;
					setTimer(250);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 5;
					setTimer(350);
				} else {
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 10;
					setTimer(350);
				}
			} else if (level == 13) {
				if (groupsAmount == 0) {
					groupsAmount = 3;
					nextBloonToAdd = new RedBloon(-100.0, 330.0);
					currentBloonsCounter = 100;
					setTimer(200);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 5;
					setTimer(350);
				} else {
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 10;
					setTimer(350);
				}
			} else if (level == 14) {
				if (groupsAmount == 0) {
					groupsAmount = 4;
					nextBloonToAdd = new RedBloon(-100.0, 330.0);
					currentBloonsCounter = 49;
					setTimer(250);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 9;
					setTimer(350);
				} else if (groupsAmount == 2) {
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 10;
					setTimer(350);
				} else {
					nextBloonToAdd = new BlueBloon(-100.0, 330.0);
					currentBloonsCounter = 15;
					setTimer(350);
				}
			} else if (level == 15) {
				if (groupsAmount == 0) {
					groupsAmount = 4;
					nextBloonToAdd = new RedBloon(-100.0, 330.0);
					currentBloonsCounter = 20;
					setTimer(250);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new PinkBloon(-100.0, 330.0);
					currentBloonsCounter = 3;
					setTimer(350);
				} else if (groupsAmount == 2) {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 5;
					setTimer(350);
				} else {
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 12;
					setTimer(350);
				}
			} else if (level == 16) {
				if (groupsAmount == 0) {
					groupsAmount = 3;
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 20;
					setTimer(250);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new PinkBloon(-100.0, 330.0);
					currentBloonsCounter = 4;
					setTimer(350);
				} else {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 8;
					setTimer(350);
				}
			} else if (level == 17) {
				groupsAmount = 1;
				nextBloonToAdd = new YellowBloon(-100.0, 330.0);
				currentBloonsCounter = 8;
				setTimer(400);
			} else if (level == 18) {
				groupsAmount = 1;
				nextBloonToAdd = new GreenBloon(-100.0, 330.0);
				currentBloonsCounter = 80;
				setTimer(350);
			} else if (level == 19) {
				if (groupsAmount == 0) {
					groupsAmount = 3;
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 10;
					setTimer(250);
				} else if (groupsAmount == 1) {
					nextBloonToAdd = new PinkBloon(-100.0, 330.0);
					currentBloonsCounter = 7;
					setTimer(350);
				} else {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 9;
					setTimer(350);
				}
			} else if (level == 20) {
				groupsAmount = 1;
				nextBloonToAdd = new BlackBloon(-100.0, 330.0);
				currentBloonsCounter = 6;
				setTimer(350);
			} else if (level == 21) {
				groupsAmount = 1;
				nextBloonToAdd = new PinkBloon(-100.0, 330.0);
				currentBloonsCounter = 14;
				setTimer(350);
			} else if (level == 22) {
				groupsAmount = 1;
				nextBloonToAdd = new BlackBloon(-100.0, 330.0);
				currentBloonsCounter = 10;
				setTimer(350);
			} else if (level == 23) {
				if (groupsAmount == 0) {
					groupsAmount = 2;
					nextBloonToAdd = new BlackBloon(-100.0, 330.0);
					currentBloonsCounter = 5;
					setTimer(400);
				} else {
					nextBloonToAdd = new BlackBloon(-100.0, 330.0);
					currentBloonsCounter = 5;
					setTimer(200);
				}
			} else if (level == 24) {
				if (groupsAmount == 0) {
					groupsAmount = 2;
					nextBloonToAdd = new BlueBloon(-100.0, 330.0);
					currentBloonsCounter = 100;
					setTimer(100);
				} else {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 19;
					setTimer(200);
				}
			} else if (level == 25) {
				if (groupsAmount == 0) {
					groupsAmount = 2;
					nextBloonToAdd = new GreenBloon(-100.0, 330.0);
					currentBloonsCounter = 50;
					setTimer(100);
				} else {
					nextBloonToAdd = new YellowBloon(-100.0, 330.0);
					currentBloonsCounter = 25;
					setTimer(200);
				}
			} else if (level == 26) {
				if (groupsAmount == 0) {
					groupsAmount = 2;
					nextBloonToAdd = new PinkBloon(-100.0, 330.0);
					currentBloonsCounter = 23;
					setTimer(100);
				} else {
					nextBloonToAdd = new ZebraBloon(-100.0, 330.0);
					currentBloonsCounter = 4;
					setTimer(200);
				}
			}
		nextBloonLocation = new Point(-nextBloonToAdd.getMaxYSpeed() * 30 , 330.0);
	}
	
	/**
	 * building the next level!
	 */
	public void levelUp() {
		Spikes.allSpikesList = null;
		currentLevel++;
		buildLevel(currentLevel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (GameBeats.isPaused()) {
			return;
		}
		Bloon bloon = BloonFactory.createNewClone(nextBloonToAdd, nextBloonLocation);
		currentBloons.add(bloon);
		GameBeats.getPanel().addBloonToDrawList(bloon);
		currentBloonsCounter--;
		if (currentBloonsCounter == 0) {
			addBloonTimer.stop();
			groupsAmount--;
			if (groupsAmount == 0) {
				ActionListener act = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (Game.bloons.isEmpty()) {
							levelUp();
							levelUpTimer.stop();
						}
					}
				};
				levelUpTimer = new Timer(500, act);
				levelUpTimer.start();
			} else {
				buildLevel(currentLevel);
			}
		}
	}
}
