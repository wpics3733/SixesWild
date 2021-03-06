package view;
import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import java.awt.*;

import model.*;
import controller.*;

/**
 * The Panel that the 9x9 board is displayed on
 * it uses a GroupLayout so that tile positions can be adjusted more accurately
 * @author jesse
 *
 */
public class BoardPanel extends JPanel {
	static final long serialVersionUID = 1;
	Board b;
	Level l;
	LevelView parent;
	JPanel tiles[][];
	
	public BoardPanel(LevelView parent) {
		super();
		this.l = parent.getLevel();
		this.b = l.getBoard();
		this.tiles = new JPanel[b.getW()][b.getH()];
		GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);

		int h = b.getH();
		int w = b.getW();
		AbstractTileContainer[][] containers = b.getTileContainers();
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				if(containers[i][j] instanceof BucketTileContainer) {
					tiles[i][j] = new BucketTilePanel(containers[i][j]);
				} else if (containers[i][j] instanceof NullTileContainer) {
					tiles[i][j] = new NullTilePanel();
				} else {
					tiles[i][j] = new TilePanel(b.getTileContainers()[i][j]);
				}
			}
		}
				
		ParallelGroup g_h = layout.createParallelGroup();
		ParallelGroup g_v = layout.createParallelGroup();
		
		
		for(int i = 0; i < w; i++) {
			SequentialGroup new_row = layout.createSequentialGroup();
			for(int j = 0; j < h; j++) {
				new_row.addComponent(tiles[i][j], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			}
			g_v.addGroup(new_row);
		}

		for(int j = 0; j < h; j++) {
			SequentialGroup new_col = layout.createSequentialGroup();
			for(int i = 0; i < w; i++) {
				new_col.addComponent(tiles[i][j], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			}
			g_h.addGroup(new_col);
		}
		
		layout.setHorizontalGroup(g_h);
		layout.setVerticalGroup(g_v);
		
		this.setLayout(layout);
	}
	
	/**
	 * Get all tile panel on the board
	 * Used for testing
	 * @return	all tiles
	 */
	public JPanel[][] getTiles() {
		return tiles;
	}
}
