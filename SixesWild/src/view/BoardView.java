package view;
import javax.swing.*;
import java.awt.*;
import model.*;
import controller.*;

public class BoardView extends JPanel {
	static final long serialVersionUID = 1;
	Board b;
	TileView tiles[][];
	
	public BoardView(Board b) {
		super();
		int h = b.getH();
		int w = b.getW();
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(9,9));
		tiles = new TileView[h][w];
		
		for(int i = 0; i < h; i++) {
			for( int j = 0; j < w; j++ ) {
				tiles[i][j] = new TileView(b.getTiles()[i][j]);
				this.add(tiles[i][j]);
			}
		}
		
		this.b = b;
	}
}
