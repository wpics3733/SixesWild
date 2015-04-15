package sixesWild.view;
import java.awt.*;

import javax.swing.*;

import sixesWild.model.*;

public class TilePanel extends JPanel {
	static final long serialVersionUID = 1;
	JLabel num;
	TileContainer tc;
	
	public TilePanel(TileContainer tc) {
		super();
		
		this.setBackground(Color.ORANGE);
		
		this.num = new JLabel( Integer.toString(tc.getTile().getNum()));
		
		num.setFont(new Font("Sans", Font.PLAIN, 26));
		
		this.add(num);

		this.tc = tc;
	}
	
	public TileContainer getTile() {
		return this.tc;
	}
	
	public void paintComponent(Graphics g) {
		this.num.setText(Integer.toString(tc.getTile().getNum()));
		if(tc.getMarked()) {
			this.setBackground(Color.RED);
		} else {
			this.setBackground(Color.GREEN);
		}
		super.paintComponent(g);
	}

}
