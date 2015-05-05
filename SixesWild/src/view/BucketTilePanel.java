package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.AbstractTileContainer;

/**
 * The JPanel associated with a Tile that is a bucket
 * Buckets are represented as DARK_GRAY until they are filled, 
 * at which point they become LIGHT_GRAY, and indistinguisable from
 * null tiles
 * @author jesse
 */
public class BucketTilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	AbstractTileContainer tile;
	
	/**
	 * Constructs a BucketTilePanel that represents the given tileContainer
	 * @param tile
	 */
	public BucketTilePanel(AbstractTileContainer tile) {
		super();
		this.tile = tile;
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(Color.DARK_GRAY);
	}
	
	/**
	 * If the bucket is empty, it is dark grey, if it is full, it is painted the same color as null tiles
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(tile.empty()) {
			this.setBackground(Color.DARK_GRAY);
		} else {
			this.setBackground(Color.LIGHT_GRAY);
		}
	}
} 
