package Graphics.Elements;

import javax.swing.JButton;

public class InvisibleButton extends JButton {

	public InvisibleButton(String text) {
		super(text);
		setOpaque(true);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
}
