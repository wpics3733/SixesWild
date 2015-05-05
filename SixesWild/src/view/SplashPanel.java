package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.ExitSplashScreen;

/**
 * This splash panel is shown on startup, and also doubles as the credits screen
 * It loads up the Splash screen image in the Images folder
 * @author jesse
 *
 */
public class SplashPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Image splashImage;
	Dimension size;

	/**
	 * Construct a new SplashPanel for the given Application
	 * @param a		The top level Application frame
	 */
	public SplashPanel(Application a) {
		try {
			URL imageUrl = new URL(getClass().getProtectionDomain()
					.getCodeSource().getLocation(), "Images/SplashScreen.png");

			splashImage = ImageIO.read(imageUrl);
			this.size = new Dimension(1024,768);

			this.addMouseListener(new ExitSplashScreen(a));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Paint the image
	 */
	@Override
	public void paint(Graphics g) {
		if(g!=null) {
			g.drawImage(this.splashImage, 0, 0, (int)size.getWidth(),(int)size.getHeight(), this);
		}
	}

}
