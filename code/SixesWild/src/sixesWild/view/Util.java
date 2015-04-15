package sixesWild.view;
import java.awt.Font;

import javax.swing.JLabel;


public class Util {

	public static void resizeLabelFont(JLabel label) {
		Font labelFont = label.getFont();
		String labelText = label.getText();

		int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = label.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = label.getHeight();

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the label's font size to the newly determined size.
		label.setFont(new Font("Sans", Font.PLAIN, fontSizeToUse/2));
		System.out.println("Setting font size to " + fontSizeToUse);
	}

}
