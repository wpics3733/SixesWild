
package sixesWild.view;
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

import sixesWild.model.Level;

public class LevelView extends JPanel {

	static final long serialVersionUID = 1;
	private Application parent;

	Level l;
	BoardView bv;
	TopBarPanel tbp;
	JPanel eastPanel;
	JLabel sideWord;
	GameWestPanel westPanel;

	public LevelView(Level l, Application parent) {
		super();
		this.parent = parent;
		this.l = l;
		this.bv = new BoardView(l.getBoard());
		this.tbp = new TopBarPanel(l, parent);
		this.sideWord = new JLabel("<html><center>S<br>i<br>x<br>e<br>s<br> <br>W<br>i<br>l<br>d<br><center></html>");
		this.westPanel = new GameWestPanel();
		JPanel eastPanel = new JPanel();

		GroupLayout eastLayout = new GroupLayout(eastPanel);
		eastLayout.setAutoCreateContainerGaps(true);
		
		eastLayout.setHorizontalGroup(
				eastLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(eastLayout.createSequentialGroup()
						.addComponent(sideWord, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
				);
		eastLayout.setVerticalGroup(
				eastLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(eastLayout.createSequentialGroup()
						.addComponent(sideWord, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
				);
		eastPanel.setLayout(eastLayout);
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
