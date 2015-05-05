package view;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StarPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	static Image full_star;
	static Image empty_star;
	Image scaled_full;
	Image scaled_empty;
	
	int scale;

	JLabel stars[];

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

		scaled_full = full_star.getScaledInstance(scale, scale, Image.SCALE_DEFAULT);
		scaled_empty = empty_star.getScaledInstance(scale, scale, Image.SCALE_DEFAULT);

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
