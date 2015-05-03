package boundaryPackage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
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
	JLabel multiplierLabels[][];
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(LevelModel model) {
		this.model = model;
		
		tileIcons = new Icon[9];
		tileIcons[0] = new ImageIcon(this.getClass().getResource("/Images/BucketTile.png"));
		tileIcons[1] = new ImageIcon(this.getClass().getResource("/Images/BlockedTile.png"));
		tileIcons[2] = new ImageIcon(this.getClass().getResource("/Images/UnmodifiedTile.png"));
		tileIcons[3] = new ImageIcon(this.getClass().getResource("/Images/Number1.png"));
		tileIcons[4] = new ImageIcon(this.getClass().getResource("/Images/Number2.png"));
		tileIcons[5] = new ImageIcon(this.getClass().getResource("/Images/Number3.png"));
		tileIcons[6] = new ImageIcon(this.getClass().getResource("/Images/Number4.png"));
		tileIcons[7] = new ImageIcon(this.getClass().getResource("/Images/Number5.png"));
		tileIcons[8] = new ImageIcon(this.getClass().getResource("/Images/Number6.png"));
		
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(9, 9, 0, 0));
		ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/Images/UnmodifiedTile.png"));
		//JButton btnNewButton_1 = new JButton("New button");
		//btnNewButton_1.setIcon(myIcon);
		//add(btnNewButton_1);
		
		tileLabels = new JLabel[9][9];
		multiplierLabels = new JLabel[9][9];
		
		for(int j = 0; j < 9; j++){
			for(int i = 0; i < 9; i++){
				JLabel label_1Tile = new JLabel(myIcon);
				label_1Tile.setName( "(" + ((Integer) j).toString() + ", " + ((Integer) i).toString() + ")");
				label_1Tile.addMouseListener(new TileController(model, this, label_1Tile));
				tileLabels[i][j] = label_1Tile;
				//label_1Tile.setBorder(BorderFactory.createLineBorder(Color.black));   // test the labels
				//JButton btnNewButton = new JButton(myIcon);
				//btnNewButton.setIcon(myIcon);
				//add(btnNewButton);
				add(label_1Tile);
				JLabel multiplierLabel = new JLabel();
				multiplierLabel.setForeground(Color.DARK_GRAY);
				//multiplierLabel.setFont(new Font(null, Font.BOLD, 11));
				multiplierLabel.setBounds(label_1Tile.getX(), label_1Tile.getY(), 70, 70);
				multiplierLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				multiplierLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			    multiplierLabel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
				//test.set
				//test.set
				label_1Tile.add(multiplierLabel);
				//tileButtons[i][j] = btnNewButton;
				multiplierLabels[i][j] = multiplierLabel;
			}
		}
		

		
				

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		// Ensure the border is changed properly for the new selectedTile
		Tile selectedTile = this.model.getSelectedTile();
		
		// Set all tiles to their respective images.
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				tileLabels[x][y].setIcon(tileIcons[model.getTile(x,y).getValue()+2]);
			}
		}
		
		// Clear the border for all tiles
		if (selectedTile != null) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j< 9; j++) {
					tileLabels[i][j].setBorder(null);
					multiplierLabels[i][j].setText(((Integer) model.getBoard()[i][j].getMultiplier()).toString());
				}
			}
			
			
			// Get the x and y position of the new selectedTile
			int x = selectedTile.getX();
			int y = selectedTile.getY();
			
			// Add the border to the new selectedTile
			tileLabels[x][y].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
		}
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int currentMultiplier = model.getBoard()[i][j].getMultiplier();
				if (currentMultiplier == 2 || currentMultiplier == 3) {
					multiplierLabels[i][j].setText( "x" + ((Integer) currentMultiplier).toString() );
				} else {
					multiplierLabels[i][j].setText(null);
				}
			}
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
