package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.TileContainer;

public class NullTilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	TileContainer tile;
	
	public NullTilePanel(TileContainer tile) {
		this.tile = tile;
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(100, 100));
	}
}
