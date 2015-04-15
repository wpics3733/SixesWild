package sixesWild.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sixesWild.controller.ExitSplashScreen;

public class SplashPanel extends JPanel {
	
	public SplashPanel(Application a) {
		this.add(new JLabel("SixesWild Splash Screen under construction"), BorderLayout.CENTER);
		this.addMouseListener(new ExitSplashScreen(a));
	}

}
