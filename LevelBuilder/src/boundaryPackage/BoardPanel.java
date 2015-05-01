package boundaryPackage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;

import controllerPackage.TileController;
import entityPackage.LevelModel;
import entityPackage.Tile;

public class BoardPanel extends JPanel {
	LevelModel model;
	JLabel tileLabels[][];
	Icon tileIcons[];
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(LevelModel model) {
		this.model = model;
		
		tileIcons = new Icon[8];
		tileIcons[0] = new ImageIcon(this.getClass().getResource("/Images/BlockedTile.png"));
		tileIcons[1] = new ImageIcon(this.getClass().getResource("/Images/UnmodifiedTile.png"));
		tileIcons[2] = new ImageIcon(this.getClass().getResource("/Images/Number1.png"));
		tileIcons[3] = new ImageIcon(this.getClass().getResource("/Images/Number2.png"));
		tileIcons[4] = new ImageIcon(this.getClass().getResource("/Images/Number3.png"));
		tileIcons[5] = new ImageIcon(this.getClass().getResource("/Images/Number4.png"));
		tileIcons[6] = new ImageIcon(this.getClass().getResource("/Images/Number5.png"));
		tileIcons[7] = new ImageIcon(this.getClass().getResource("/Images/Number6.png"));
		
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(9, 9, 0, 0));
		ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/Images/UnmodifiedTile.png"));
		//JButton btnNewButton_1 = new JButton("New button");
		//btnNewButton_1.setIcon(myIcon);
		//add(btnNewButton_1);
		
		tileLabels = new JLabel[9][9];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				JLabel label_1Tile = new JLabel(myIcon);
				label_1Tile.setName( ((Integer) j).toString() + ", " + ((Integer) i).toString());
				label_1Tile.addMouseListener(new TileController(model, this, label_1Tile));
				tileLabels[i][j] = label_1Tile;
				//label_1Tile.setBorder(BorderFactory.createLineBorder(Color.black));   // test the labels
				//JButton btnNewButton = new JButton(myIcon);
				//btnNewButton.setIcon(myIcon);
				//add(btnNewButton);
				add(label_1Tile);
				//tileButtons[i][j] = btnNewButton;
			}
		}
		

		
				

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		// Ensure the border is changed properly for the new selectedTile
		Tile selectedTile = this.model.getSelectedTile();
		
		// Clear the border for all tiles
		if (selectedTile != null) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j< 9; j++) {
					tileLabels[i][j].setBorder(null);
				}
			}
			
			
			// Get the x and y position of the new selectedTile
			int x = selectedTile.getX();
			int y = selectedTile.getY();
			
			// Add the border to the new selectedTile
			tileLabels[x][y].setBorder(BorderFactory.createLineBorder(Color.yellow, 4));
			tileLabels[x][y].setIcon(tileIcons[selectedTile.getValue()+1]);
		}
		
	}

	/**
	 * Returns the x and y coordinates of the specified JLabel as a Point.
	 * If the specified JLabel is not found in the tileLabels array, then it returns null.
	 * 
	 * @author Tom
	 */
	public Point contains(JLabel label) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (tileLabels[i][j] == label) {
					return new Point(i, j);
				}
					
			}
		}
		return null;
	}
	
	
}
