package sixesWild.view;
import java.awt.*;

import javax.swing.*;

import sixesWild.model.*;

public class TilePanel extends JPanel {
	static final long serialVersionUID = 1;
	JLabel num;
	TileContainer tc;
	JPanel inner;
	
	public TilePanel(TileContainer tc) {
		super();
		
		this.num = new JLabel( Integer.toString(tc.getTile().getNum()));
		
		num.setFont(new Font("AvenyyirNext", Font.PLAIN, 26));
		num.setForeground(Color.BLACK);
		
		this.inner = new JPanel();
		GroupLayout gl_layout = new GroupLayout(this);
		gl_layout.setAutoCreateContainerGaps(true);
		gl_layout.setHorizontalGroup(
				gl_layout.createSequentialGroup()
				.addGap(5)
				.addComponent(inner)
				.addGap(5));
		gl_layout.setVerticalGroup(
				gl_layout.createSequentialGroup()
				.addGap(5)
				.addComponent(inner)
				.addGap(5));
		this.setLayout(gl_layout);
		this.add(inner, BorderLayout.CENTER);
		
		inner.setBackground(new Color(112,147, 113));
		this.setBackground(Color.BLACK);
		num.setForeground(Color.WHITE);
		inner.add(num);

		this.tc = tc;
	}
	
	public TileContainer getTile() {
		return this.tc;
	}
	
	/*
	public void paintComponent(Graphics g) {
		this.num.setText(Integer.toString(tc.getTile().getNum()));
		if(tc.getMarked()) {

			this.setBackground(Color.RED);
		} else {
			this.setBackground(new Color(112,147,113));
		}
		super.paintComponent(g);
	}
	*/

}
