package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.TileContainer;

public class BucketTilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	TileContainer tile;
	
	public BucketTilePanel(TileContainer tile) {
		super();
		this.tile = tile;
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(100,100));
	}
}
