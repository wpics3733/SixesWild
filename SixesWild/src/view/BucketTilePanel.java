package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.AbstractTileContainer;

public class BucketTilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	AbstractTileContainer tile;
	
	public BucketTilePanel(AbstractTileContainer tile) {
		super();
		this.tile = tile;
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(Color.DARK_GRAY);
	}
	
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
