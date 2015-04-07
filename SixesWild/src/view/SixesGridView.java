package view;
import javax.swing.*;
import java.awt.*;
import model.*;
import controller.*;

public class SixesGridView extends JPanel {
	static final long serialVersionUID = 1;
	SixesGridModel sgm;
	TileView tiles[][];
	
	public SixesGridView(SixesGridModel sgm) {
		super();
		int h = sgm.getH();
		int w = sgm.getW();
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(9,9));
		tiles = new TileView[h][w];
		
		for(int i = 0; i < h; i++) {
			for( int j = 0; j < w; j++ ) {
				tiles[i][j] = new TileView(sgm.getTiles()[i][j]);
				this.add(tiles[i][j]);
			}
		}
		
		this.sgm = sgm;
		this.addMouseListener(new SixesGridController(this, sgm));
		this.addMouseMotionListener(new SixesGridController(this, sgm));
	}
}
