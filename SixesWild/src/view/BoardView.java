package view;
import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import java.awt.*;

import model.*;
import controller.*;

public class BoardView extends JPanel {
	static final long serialVersionUID = 1;
	Board b;
	TilePanel tiles[][];
	
	public BoardView(Board b) {
		super();
		this.b = b;
		this.tiles = new TilePanel[9][9];
		GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);

		int h = b.getH();
		int w = b.getW();
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				tiles[i][j] = new TilePanel(b.getTiles()[i][j]);
			}
		}
				
		ParallelGroup g_h = layout.createParallelGroup();
		ParallelGroup g_v = layout.createParallelGroup();
		
		
		for(int i = 0; i < w; i++) {
			SequentialGroup new_row = layout.createSequentialGroup();
			SequentialGroup new_col = layout.createSequentialGroup();
			for(int j = 0; j < h; j++) {
				new_row.addComponent(tiles[i][j], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
				new_col.addComponent(tiles[j][i], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			}
			g_h.addGroup(new_row);
			g_v.addGroup(new_col);
		}
		
		layout.setHorizontalGroup(g_h);
		layout.setVerticalGroup(g_v);
		
		this.setLayout(layout);
	}
}
