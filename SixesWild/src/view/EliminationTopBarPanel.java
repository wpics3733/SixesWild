package view;

import java.awt.Color;
import java.awt.Graphics;

import controller.InitiateClearMoveController;
import controller.InitiateSwapMoveController;
import controller.RearrangeBoardController;
import controller.ReturnToMenuController;
import model.Level;
import model.EliminationLevel;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

/**
 * Each Level type needs to display different information in the top bar
 * Elimination levels need to show how many moves are left
 * @author jesse
 *
 */
public class EliminationTopBarPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	EliminationLevel l;
	LevelView lv;
	Application parent;
	
	private JButton clear;
	private JButton swap;
	private JButton quit;
	private JButton rearrange;
	private JLabel score;
	private JLabel movesLeft;
	
	/**
	 * Create a new EliminationTopBapPanel for the given level and its associated levelView
	 * @param l			The current level
	 * @param lv		The view associated with l
	 * @param parent	The top level application frame
	 */
	public EliminationTopBarPanel(EliminationLevel l, LevelView lv, Application parent) {
		
		this.l = l;
		this.lv = lv;
		this.parent = parent;
		
		clear = new JButton("Clear");
		swap = new JButton("Swap");
		rearrange = new JButton("Rearrange");
		
		quit = new JButton("Quit");
		quit.addMouseListener(new ReturnToMenuController(parent));
		
		movesLeft = new JLabel();
		movesLeft.setFont(new Font("AvenyyirNext", Font.PLAIN, 20));
		movesLeft.setForeground(Color.WHITE);
		
		score = new JLabel();
		score.setFont(new Font("AvenyyirNext", Font.PLAIN, 20));
		score.setForeground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(quit)
							.addComponent(score)
							.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
							.addComponent(movesLeft)
							.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
							.addComponent(rearrange)
							.addComponent(swap)
							.addComponent(clear))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rearrange)
						.addComponent(swap)
						.addComponent(score)
						.addComponent(clear)
						.addComponent(movesLeft)
						.addComponent(quit)))
		);
		
		
		this.rearrange.addMouseListener(new RearrangeBoardController(l, lv));
		this.swap.addMouseListener(new InitiateSwapMoveController(l, lv));
		this.clear.addMouseListener(new InitiateClearMoveController(l, lv));
		setLayout(groupLayout);
		setBackground(new Color(112,147,113));

	}
	
	/**
	 * Whenever the bar repaints, it needs to update the number of special moves remaining (possibly disabling the buttons)
	 * and update how many moves the user has left
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		movesLeft.setText("Moves Left: " + l.getMovesRemaining());
		score.setText("Score: " + l.getScore());
		swap.setText("Swap (" + l.getNumSpecial(Level.SWAP) + ")");
		rearrange.setText("Rearrange (" + l.getNumSpecial(Level.REARRANGE) + ")");
		clear.setText("Clear (" + l.getNumSpecial(Level.CLEAR) + ")");
	}
}
