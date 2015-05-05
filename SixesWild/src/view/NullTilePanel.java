package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.AbstractTileContainer;

/**
 * NullTilePanel are the TilePanel used for representing NullTileContainers
 * They always appear light grey
 * @author jesse
 *
 */
public class NullTilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construct a new NullTilePanel
	 */
	public NullTilePanel() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(100, 100));
	}
}
