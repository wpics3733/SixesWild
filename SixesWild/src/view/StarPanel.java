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
	
	Image full_star;
	Image empty_star;
	
	JLabel stars[];

	public StarPanel(int num, int scale) {
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		try {
			URL imageURL;
			imageURL = new URL (getClass().getProtectionDomain()
					.getCodeSource().getLocation(), "Images/full_star.png");

			full_star = ImageIO.read(imageURL);
			full_star = full_star.getScaledInstance(scale, scale, Image.SCALE_DEFAULT);
			imageURL = new URL(getClass().getProtectionDomain()
					.getCodeSource().getLocation(), "Images/empty_star.png");
			empty_star = ImageIO.read(imageURL);
			empty_star = empty_star.getScaledInstance(scale, scale, Image.SCALE_DEFAULT);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		stars = new JLabel[3];
		for(int i = 0; i < 3; i++) {
			stars[i] = new JLabel();
			if(num > i) {
				stars[i].setIcon(new ImageIcon(full_star));
			} else {
				stars[i].setIcon(new ImageIcon(empty_star));
			}
			this.add(stars[i]);
		}
		
	}

}
