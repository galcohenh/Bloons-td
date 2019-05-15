package Trash;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fonts {
	
	public static Font getDwarvenAxeBBRegular() {
		Font f = null;
		try {
			f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/images/GameFont.ttf"))).deriveFont(Font.PLAIN, 20);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
		}
}
