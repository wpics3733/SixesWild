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
/**
 * Board panel that shows the board preview for level builder.
 * 
 * @author Dabai & Dean & Tom
 *
 */
public class BoardPanel extends JPanel {
	/** A reference to the model. */
	LevelModel model;
	
	/** The JLabels that are displayed on the board, which represent the Tile entities. */
	JLabel tileLabels[][];
	
	/** The icons to be displayed in the tileLabels. */
	Icon tileIcons[];
	
	/** The JLabels that represent the multiplier for a given tileLabel.  They are displayed on top of the tileLabels. */
	JLabel multiplierLabels[][];
	
	/**
	 * Constructor for a board panel.
	 * Initializes the board (i.e. the tiles' values, multipliers, etc.) based upon data in the model.
	 * @param model a reference to the model.
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
		
		tileLabels = new JLabel[9][9];
		multiplierLabels = new JLabel[9][9];
		
		for(int j = 0; j < 9; j++){
			for(int i = 0; i < 9; i++){
				JLabel label_1Tile = new JLabel(myIcon);
				label_1Tile.setName( "(" + ((Integer) j).toString() + ", " + ((Integer) i).toString() + ")");
				label_1Tile.addMouseListener(new TileController(model, this, label_1Tile));
				tileLabels[i][j] = label_1Tile;
				add(label_1Tile);
				JLabel multiplierLabel = new JLabel();
				multiplierLabel.setForeground(Color.DARK_GRAY);
				//multiplierLabel.setFont(new Font(null, Font.BOLD, 11));
				multiplierLabel.setBounds(label_1Tile.getX(), label_1Tile.getY(), 70, 70);
				multiplierLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				multiplierLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			    multiplierLabel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
				label_1Tile.add(multiplierLabel);
				multiplierLabels[i][j] = multiplierLabel;
			}
		}
	}

	/**
	 * Update the board with the following items: 
	 * the correct image (i.e. the tile's number value), 
	 * clear all tile's borders,
	 * set the border for the currently selected tile only, and
	 * display the correct/current multiplier for a tile. 
	 * 
	 * Required for Java Swing functionality.
	 * @parame g
	 * 
	 * @author Tom, Dean
	 */
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
		
		// Clear the border for all tiles, then highlight the current selected tile with a border
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
		
		// Set the multipliers for all of the tiles
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
	 * @return Point
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
