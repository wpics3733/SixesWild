package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ExitSplashScreen;

public class SplashPanel extends JPanel {
	
	public SplashPanel(Application a) {
		this.add(new JLabel("Sixes Wild"), BorderLayout.CENTER);
		this.addMouseListener(new ExitSplashScreen(a));
	}

}
