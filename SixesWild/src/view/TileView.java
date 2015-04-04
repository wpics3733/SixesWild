package view;
import java.awt.*;

import javax.swing.*;

import model.*;

public class TileView extends JPanel {
	static final long serialVersionUID = 1;
	JLabel num;
	TileContainer tc;
	
	public TileView(TileContainer tc) {
		super();
		
		this.setBackground(Color.ORANGE);
		
		this.num = new JLabel( Integer.toString(tc.getTile().getNum()));

		
		this.add(num);
		this.tc = tc;
	}

}
