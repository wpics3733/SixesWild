package boundaryPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controllerPackage.QuitButtonController;
import controllerPackage.SplashScreenPanelController;
import entityPackage.LevelModel;

/** Create the splash screen for level builder
 * @author Dabai
 *
 */
class SplashScreenPanel extends JPanel {

	private BufferedImage img; 
	private LevelBuilderApplication parentApplication;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	LevelModel model;
	
	public SplashScreenPanel(LevelBuilderApplication parent, LevelModel model) {
		this.model = model;
		
		ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/Images/SplashScreen.png"));

		this.addMouseListener(new SplashScreenPanelController(model, parent));
		parentApplication = parent;
		setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel(myIcon);
		add(lblNewLabel);
		
		this.repaint();
	}
	
	public LevelBuilderApplication getParentApplication(){return parentApplication;}
}
