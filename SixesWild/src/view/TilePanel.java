package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.TileContainer;

public class TilePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel num;
	JLabel multiplier;
	TileContainer tile;
	
	public TilePanel(TileContainer tc) {
		this.tile = tc;
		this.num = new JLabel();
		this.multiplier = new JLabel();
		this.add(num);
		this.add(multiplier);
		this.setBackground(new Color(112,147,113));
		num.setForeground(Color.WHITE);
		num.setFont(new Font("Sans", Font.PLAIN, 26));
	}
	
	public TileContainer getTile() {
		return this.tile;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(this.tile.empty()) {
			this.num.setText("");
		}
		num.setText(Integer.toString(tile.getTile().getNum()));
		multiplier.setText("x" + Integer.toString(tile.getTile().getMultiplier()));
		if(tile.used()) {
			this.setBackground(Color.YELLOW);
		} else if (tile.getMarked()) {
			this.setBackground(new Color(130, 170, 130));
		} else {
			this.setBackground(new Color(112,147,113));
		}
	}

}
