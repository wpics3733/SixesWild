package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class backButtonPanel extends JPanel {
	
	private BufferedImage image;

    public backButtonPanel() {
    	
    	try {                
          image = ImageIO.read(new File("src/backButton.png"));
          this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
          } catch (IOException ex) {
        	  ex.printStackTrace();
          }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);     
    }

}
