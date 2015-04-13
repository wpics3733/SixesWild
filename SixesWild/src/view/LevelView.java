
package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Level;

public class LevelView extends JPanel {

	static final long serialVersionUID = 1;
	Level l;
	BoardView bv;
	TopBarPanel tbp;
	JPanel eastPanel;
	JLabel sideWord;
	GameWestPanel westPanel;

	public LevelView(Level l) {
		super();
		this.l = l;
		this.bv = new BoardView(l.getBoard());
		this.tbp = new TopBarPanel(l);
		this.sideWord = new JLabel("<html><center>S<br>i<br>x<br>e<br>s<br> <br>W<br>i<br>l<br>d<br><center></html>");
		this.westPanel = new GameWestPanel();
		JPanel eastPanel = new JPanel();

		GroupLayout test = new GroupLayout(eastPanel);
		test.setAutoCreateContainerGaps(true);
		
		test.setHorizontalGroup(
				test.createParallelGroup(Alignment.LEADING)
				.addGroup(test.createSequentialGroup()
						.addComponent(sideWord, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
				);
		test.setVerticalGroup(
				test.createParallelGroup(Alignment.LEADING)
				.addGroup(test.createSequentialGroup()
						.addComponent(sideWord, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
				);
		eastPanel.setLayout(test);
		sideWord.setFont(new Font("Sans", Font.BOLD, 26));

		this.setLayout(new BorderLayout());
		this.add(bv, BorderLayout.CENTER);
		this.add(tbp, BorderLayout.NORTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(westPanel, BorderLayout.WEST);

	}

	public Level getLevel() {
		return l;
	}

	public BoardView getBoard() {
		return bv;
	}

}
