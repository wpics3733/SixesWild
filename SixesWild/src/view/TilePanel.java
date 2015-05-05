package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.AbstractTileContainer;

/**
 * The Panel that represents a NumberTileContainer in the board
 * It is green, (turns slightly lighter when marked in an elimination level)
 * It shows the Tile number and multiplier (if the TileContainer is not empty)
 * @author jesse
 *
 */
public class TilePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel num;
	JLabel multiplier;
	AbstractTileContainer tile;
	
	/**
	 * Construct a new TilePanel based on the given TileContainer
	 * @param tc	the TileContainer this represents
	 */
	public TilePanel(AbstractTileContainer tc) {
		this.tile = tc;
		this.num = new JLabel();
		this.multiplier = new JLabel();
		this.add(num);
		this.add(multiplier);
		this.setBackground(new Color(112,147,113));
		num.setForeground(Color.WHITE);
		num.setFont(new Font("Sans", Font.PLAIN, 26));
		this.setPreferredSize(new Dimension(100, 100));
	}
	
	/**
	 * gets the tile Associated with this view
	 * @return	the tile
	 */
	public AbstractTileContainer getTile() {
		return this.tile;
	}
	
	/**
	 * When we repaint, we might need to change the number if the Containers tile changed
	 * we may also need to remove the number entirely
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(this.tile.empty()) {
			this.num.setText("");
			multiplier.setText("");
		} else {
			num.setText(Integer.toString(tile.getTile().getNum()));
			multiplier.setText("x" + Integer.toString(tile.getTile().getMultiplier()));
		}
		if(tile.used()) {
			this.setBackground(Color.YELLOW);
		} else if (tile.marked()) {
			this.setBackground(new Color(142, 177, 143));
		} else {
			this.setBackground(new Color(112,147,113));
		}
	}

}
