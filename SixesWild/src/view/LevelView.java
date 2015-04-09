
package view;
import javax.swing.*;

import controller.MakeMove;
import model.*;

import java.awt.*;

public class LevelView extends JPanel {

	static final long serialVersionUID = 1;
	JLabel score;
	Level l;
	BoardView bv;
	
	public LevelView(Level l) {
		super();
		this.l = l;
		this.bv = new BoardView(l.getBoard());
		this.score = new JLabel(Integer.toString(l.getScore()));
		
		this.setLayout(new BorderLayout());
		this.add(score, BorderLayout.NORTH);
		this.add(bv, BorderLayout.CENTER);

		MakeMove mm = new MakeMove(new UserMove(), this);
		this.addMouseListener(mm);
		this.addMouseMotionListener(mm);
	}
	
	public Level getLevel() {
		return l;
	}
	
	public BoardView getBoard() {
		return bv;
	}
	
	public void paintComponent(Graphics g) {
		this.score.setText(Integer.toString(l.getScore()));
		super.paintComponent(g);
	}
}
