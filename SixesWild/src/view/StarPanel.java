package view;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A star panel is the panel that shows how many stars a player has earned.
 * It contains 3 JLabels, each of which is either a full star or an empty star
 * @author jesse
 *
 */
public class StarPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	static Image full_star;
	static Image empty_star;
	Image scaled_full;
	Image scaled_empty;
	
	int scale;

	JLabel stars[];

	/**
	 * Construct a new StarPanel where num stars are full (3 - num are empty)
	 * Scaling is decided by the scale parameter (smaller generates a smaller image
	 * @param num	the number of filled stars
	 * @param scale	the scale
	 */
	public StarPanel(int num, int scale) {
		this.scale = scale;

		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		if(full_star == null || empty_star == null) {
			try {
				URL imageURL;
				imageURL = new URL (getClass().getProtectionDomain()
						.getCodeSource().getLocation(), "Images/full_star.png");

				full_star = ImageIO.read(imageURL);
				imageURL = new URL(getClass().getProtectionDomain()
						.getCodeSource().getLocation(), "Images/empty_star.png");
				empty_star = ImageIO.read(imageURL);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		scaled_full = full_star.getScaledInstance(scale, scale, Image.SCALE_FAST);
		scaled_empty = empty_star.getScaledInstance(scale, scale, Image.SCALE_FAST);

		stars = new JLabel[3];
		for(int i = 0; i < 3; i++) {
			stars[i] = new JLabel();
			if(num > i) {
				stars[i].setIcon(new ImageIcon(scaled_full));
			} else {
				stars[i].setIcon(new ImageIcon(scaled_empty));
			}
			this.add(stars[i]);
		}

	}

	/**
	 * Change the number of filled stars
	 * @param num	the new number of filled stars
	 */
	public void setStars(int num) {
		for(int i = 0; i < 3; i++) {
			if(num > i) {
				stars[i].setIcon(new ImageIcon(scaled_full));
			} else {
				stars[i].setIcon(new ImageIcon(scaled_empty));
			}
			this.add(stars[i]);
		}
	}

}
