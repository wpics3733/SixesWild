package boundaryPackage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;

import controllerPackage.QuitButtonController;
import entityPackage.LevelModel;

public class BoardPanel extends JPanel {

	// currently unused--the layout uses JLabels, not JButtons
	private JButton tileButtons[][];
	LevelModel model;
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(LevelModel model) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(9, 9, 0, 0));
		ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/Images/Number3.png"));
		//JButton btnNewButton_1 = new JButton("New button");
		//btnNewButton_1.setIcon(myIcon);
		//add(btnNewButton_1);
		
		// currently unused--the layout uses JLabels, not JButtons
		tileButtons = new JButton[9][9];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				JLabel label_1Tile = new JLabel(myIcon);
				//label_1Tile.setBorder(BorderFactory.createLineBorder(Color.black));   // test the labels
				//JButton btnNewButton = new JButton(myIcon);
				//btnNewButton.setIcon(myIcon);
				//add(btnNewButton);
				add(label_1Tile);
				//tileButtons[i][j] = btnNewButton;
			}
		}
				

	}

	public void PaintComponent(Graphics g){
		super.paintComponent(g);
		
	}
	
}
