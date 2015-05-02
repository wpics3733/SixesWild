package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.AbstractTileContainer;
import model.TileContainer;

public class BucketTilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	AbstractTileContainer tile;
	
	public BucketTilePanel(AbstractTileContainer tile) {
		super();
		this.tile = tile;
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(100,100));
	}
	
	public void paintComponent(Graphics g) {
		if(!tile.empty()) {
			this.add(new JLabel("6"));
		}
		
	}
} 
