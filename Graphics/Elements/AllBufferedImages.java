package Graphics.Elements;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AllBufferedImages {
	public static BufferedImage spikeFactoryShoot;
	public static BufferedImage spikeFactorySpikes;
	public static BufferedImage [] dartMonkeyModeImages;
	public static BufferedImage [] tackModeImages;
	public static BufferedImage [] sniperModeImages;
	public static BufferedImage [] spikeFactoryModeImages;
	public static BufferedImage [] portModeImages;
	public static BufferedImage [] pilotModeImages;
	public static BufferedImage [] glueModeImages;
	public static BufferedImage [] mortarModeImages;
	public static BufferedImage[] boomSprites;
	public static BufferedImage shootingBoom;
	public static BufferedImage dartMonkeyIcon;
	public static BufferedImage tackShooterIcon;
	public static BufferedImage tackShooterShoot1;
	public static BufferedImage tackShooterShoot2;
	public static BufferedImage sniperMonkeyIcon;
	public static BufferedImage glue;
	public static BufferedImage backgroundImage = null; 
	public static BufferedImage settingsBTN = null;
	public static BufferedImage startGameBTN = null;
	public static BufferedImage startGameImage = null;
	public static BufferedImage toolbarImage = null; 
	public static BufferedImage hPImage = null; 
	public static BufferedImage coinsImage = null;
	public static BufferedImage popImage = null;
	public static BufferedImage targetImage = null;
	public static BufferedImage rightArrowImage = null;
	public static BufferedImage leftArrowImage = null;
	public static BufferedImage boardImage = null;
	public static BufferedImage intention = null;
	
	public static ImageIcon rightArrowIcon = null;
	public static ImageIcon leftArrowIcon = null;
	
	public static BufferedImage zebraBloonImage;
	public static BufferedImage blackBloonImage;
	public static BufferedImage pinkBloonImage;
	public static BufferedImage yellowBloonImage;
	public static BufferedImage greenBloonImage;
	public static BufferedImage blueBloonImage;
	public static BufferedImage redBloonImage;
	
	public static BufferedImage zero;
	public static BufferedImage one;
	public static BufferedImage two;
	public static BufferedImage three;
	public static BufferedImage four;
	public static BufferedImage five;
	public static BufferedImage six;
	public static BufferedImage seven;
	public static BufferedImage eight;
	public static BufferedImage nine;
	
	public static BufferedImage startPanel;
	
	public static BufferedImage homeBTN;
	public static BufferedImage restartBTN;
	public static BufferedImage runBTN;
	public static BufferedImage selectedHomeBTN;
	public static BufferedImage selectedRestartBTN;
	public static BufferedImage selectedRunBTN;
	public static BufferedImage settingsTitle;
	public static BufferedImage gameOver;
	public static BufferedImage path;
	
	public static Cursor curser1;
	public static Cursor curser2;
	public static Image appIcon;
	
	public static void readAllImages() throws IOException {
		startPanel = ImageIO.read(new File("images/Start_Panel.png"));
		dartMonkeyModeImages = buildModeArray("Dart_Monkey");
		dartMonkeyIcon = ImageIO.read(new File("images/Monkeys/DartMonkey/Dart_Monkey_Icon.png"));
		tackModeImages = buildModeArray("Tack_Shooter");
		tackShooterIcon = ImageIO.read(new File("images/Monkeys/TackShooter/Tack_Shooter_Icon.png"));
		sniperModeImages = buildModeArray("Sniper_Monkey");
		sniperMonkeyIcon = ImageIO.read(new File("images/Monkeys/SniperMonkey/Sniper_Monkey_Icon.png"));
		spikeFactoryModeImages = new BufferedImage[3];
		spikeFactoryModeImages[0] = ImageIO.read(new File("images/Monkeys/SpikeFactory/Spike_Factory1.png"));
		spikeFactoryModeImages[1] = ImageIO.read(new File("images/Monkeys/SpikeFactory/Forbidden_Area_Spike_Factory.png"));
		spikeFactoryModeImages[2] = ImageIO.read(new File("images/Monkeys/SpikeFactory/Unavailable_Spike_Factory.png"));
		spikeFactoryShoot = ImageIO.read(new File("images/Monkeys/SpikeFactory/Spike_Factory2.png"));
		spikeFactorySpikes = ImageIO.read(new File("images/Monkeys/SpikeFactory/Spikes.png"));
		portModeImages = new BufferedImage[3];
		portModeImages[0] = ImageIO.read(new File("images/Monkeys/Heli/Port.png"));
		portModeImages[1] = ImageIO.read(new File("images/Monkeys/Heli/Forbidden_Area_Port.png"));
		portModeImages[2] = ImageIO.read(new File("images/Monkeys/Heli/Unavailable_Port.png"));
		glueModeImages = buildModeArray("Glue_Gunner");
		glue = ImageIO.read(new File("images/Monkeys/GlueGunner/Glue.png"));
		pilotModeImages = new BufferedImage[3];
		pilotModeImages[0] = ImageIO.read(new File("images/Monkeys/Heli/Pilot1.png"));
		pilotModeImages[1] = ImageIO.read(new File("images/Monkeys/Heli/Pilot2.png"));
		pilotModeImages[2] = ImageIO.read(new File("images/Monkeys/Heli/Pilot3.png"));
		mortarModeImages = buildModeArray("Mortar_Monkey");
		backgroundImage = ImageIO.read(new File("images/background.png"));
		
		Image scaledInstance = ImageIO.read(new File("images/Path.png")).getScaledInstance(1133, 608, Image.SCALE_DEFAULT);
		path = new BufferedImage(1133, 608, BufferedImage.TYPE_INT_ARGB);
		path.getGraphics().drawImage(scaledInstance, 0, 0 , null);
		
		settingsBTN = ImageIO.read(new File("images/settings.png"));
		startGameBTN = ImageIO.read(new File("images/Start_Game_Image.png"));
		toolbarImage = ImageIO.read(new File("images/toolbar.png"));
		hPImage = ImageIO.read(new File("images/HP.png"));
		coinsImage = ImageIO.read(new File("images/coins.png"));
		popImage = ImageIO.read(new File("images/pop.png"));
		
		
		tackShooterShoot1 = ImageIO.read(new File("images/Monkeys/TackShooter/shoot1.png"));
		tackShooterShoot2 = ImageIO.read(new File("images/Monkeys/TackShooter/shoot2.png"));
		
		zebraBloonImage = ImageIO.read(new File("images/Bloons/Zebra_Bloon.png"));
		blackBloonImage = ImageIO.read(new File("images/Bloons/Black_Bloon.png"));
		pinkBloonImage = ImageIO.read(new File("images/Bloons/Pink_Bloon.png"));
		yellowBloonImage = ImageIO.read(new File("images/Bloons/Yellow_Bloon.png"));
		greenBloonImage = ImageIO.read(new File("images/Bloons/Green_Bloon.png"));
		blueBloonImage = ImageIO.read(new File("images/Bloons/Blue_Bloon.png"));
		redBloonImage = ImageIO.read(new File("images/Bloons/Red_Bloon.png"));
		
		zero = ImageIO.read(new File("images/Chars/zero.png"));
		one = ImageIO.read(new File("images/Chars/one.png"));
		two = ImageIO.read(new File("images/Chars/two.png"));
		three = ImageIO.read(new File("images/Chars/three.png"));
		four = ImageIO.read(new File("images/Chars/four.png"));
		five = ImageIO.read(new File("images/Chars/five.png"));
		six = ImageIO.read(new File("images/Chars/six.png"));
		seven = ImageIO.read(new File("images/Chars/seven.png"));
		eight = ImageIO.read(new File("images/Chars/eight.png"));
		nine = ImageIO.read(new File("images/Chars/nine.png"));
		
		homeBTN = ImageIO.read(new File("images/PausePanelImg/HomeBTN.png"));
		restartBTN = ImageIO.read(new File("images/PausePanelImg/RestartBTN.png"));
		runBTN = ImageIO.read(new File("images/PausePanelImg/RunBTN.png"));
		selectedHomeBTN = ImageIO.read(new File("images/PausePanelImg/Selected_HomeBTN.png"));
		selectedRestartBTN = ImageIO.read(new File("images/PausePanelImg/Selected_RestartBTN.png"));
		selectedRunBTN = ImageIO.read(new File("images/PausePanelImg/Selected_RunBTN.png"));
		settingsTitle = ImageIO.read(new File("images/PausePanelImg/SettingsTitle.png"));
		targetImage = ImageIO.read(new File("images/Target.png"));
		gameOver = ImageIO.read(new File("images/Game_Over.png"));
		leftArrowImage = ImageIO.read(new File("images/Elements/LeftArrow.png"));
		rightArrowImage = ImageIO.read(new File("images/Elements/RightArrow.png"));
		boardImage = ImageIO.read(new File("images/Elements/Board.png"));
		
		curser1 = Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/Elements/cursor1.png").getImage(), new Point(0, 0), "custom cursor1");
		curser2 = Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/Elements/cursor2.png").getImage(), new Point(0, 0), "custom cursor2");
		appIcon = ImageIO.read(new File("images/Elements/AppIcon.png"));
		rightArrowIcon = new ImageIcon("images/Elements/RightArrow.png");
		leftArrowIcon = new ImageIcon("images/Elements/LeftArrow.png");
		intention = ImageIO.read(new File("images/Elements/Intention.png"));
		boomSprites = new BufferedImage[5];
		for (int i = 0; i < boomSprites.length; i++) {
			boomSprites[i] = ImageIO.read(new File("images/Monkeys/MortarMonkey/BoomSprites.png")).getSubimage(i * 240, 0, 240, 268);
		}
		shootingBoom = ImageIO.read(new File("images/Monkeys/MortarMonkey/ShootingBoom.png"));
	}
	
	private static BufferedImage[] buildModeArray(String name) throws IOException {
		BufferedImage[] imgArr = new BufferedImage[3];
		String fixedName = name.replace("_",""); 
		imgArr[0] = ImageIO.read(new File("images/Monkeys/" + fixedName + "/" + name + ".png"));
		imgArr[1] = ImageIO.read(new File("images/Monkeys/" + fixedName + "/Forbidden_Area_" + name + ".png"));
		imgArr[2] = ImageIO.read(new File("images/Monkeys/" + fixedName + "/Unavailable_" + name + ".png"));		
		return imgArr;
	}
}
