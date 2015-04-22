package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.TileContainer;

public class TilePanel extends JPanel {
	JLabel num;
	TileContainer tile;
	
	public TilePanel(TileContainer tc) {
		this.tile = tc;
		this.num = new JLabel();
		this.add(num, BorderLayout.CENTER);
		this.setBackground(new Color(112,147,113));
		num.setForeground(Color.WHITE);
		num.setFont(new Font("Sans", Font.PLAIN, 30));
	}
	
	public TileContainer getTile() {
		return this.tile;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		num.setText(Integer.toString(tile.getTile().getNum()));
	}

}
