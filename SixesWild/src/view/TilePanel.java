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

public class TilePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel num;
	JLabel multiplier;
	AbstractTileContainer tile;
	
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
	
	public AbstractTileContainer getTile() {
		return this.tile;
	}
	
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
			this.setBackground(new Color(130, 170, 130));
		} else {
			this.setBackground(new Color(112,147,113));
		}
	}

}
