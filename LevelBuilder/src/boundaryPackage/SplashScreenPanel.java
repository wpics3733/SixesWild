package boundaryPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

class SplashScreenPanel extends JPanel {

	private BufferedImage img; 
	private LevelBuilderApplication parentApplication;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public SplashScreenPanel(LevelBuilderApplication parent) {
		
		ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/Images/SplashScreen.png"));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				parentApplication.setCurrentView(new MenuPanel(((SplashScreenPanel)arg0.getSource()).getParentApplication()), (JPanel) arg0.getSource());
			}
		});
		parentApplication = parent;
		setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel(myIcon);
		add(lblNewLabel);
		
		this.repaint();
	}
	
	public LevelBuilderApplication getParentApplication(){return parentApplication;}
}
