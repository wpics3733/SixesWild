package view;

import java.awt.Color;
import java.awt.Graphics;

import controller.ReturnToMenuController;
import model.Level;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

/**
 * This panel sits on top of the level, showing number of moves left (or time, etc)
 * It also contains the buttons to initiate special moves, as well as displaying the score
 * @author jesse
 *
 */
public class TopBarPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Level l;
	Application parent;
	
	private JButton clear;
	private JButton swap;
	private JButton quit;
	private JButton rearrange;
	private JLabel score;
	private JLabel timeLeft;
	
	public TopBarPanel(Level l, Application parent) {
		
		this.l = l;
		this.parent = parent;
		
		clear = new JButton("Clear");
		swap = new JButton("Swap");
		rearrange = new JButton("Rearrange");
		timeLeft = new JLabel("Moves Left: 99");
		timeLeft.setFont(new Font("AvenyyirNext", Font.PLAIN, 20));
		timeLeft.setForeground(Color.WHITE);
		
		quit = new JButton("Quit");
		quit.addMouseListener(new ReturnToMenuController(parent));
		score = new JLabel("Score: " + 999);
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
							.addComponent(timeLeft)
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
						.addComponent(timeLeft)
						.addComponent(quit)))
		);
		setLayout(groupLayout);
		setBackground(new Color(112,147,113));

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int swapMoves = l.getNumSpecial(Level.SWAP);
		int clearMoves = l.getNumSpecial(Level.CLEAR);
		int rearrangeMoves = l.getNumSpecial(Level.REARRANGE);
		if(swapMoves <= 0) {
			swap.setEnabled(false);
		}
		if(rearrangeMoves <= 0) {
			rearrange.setEnabled(false);
		}

		if(clearMoves <= 0) {
			clear.setEnabled(false);
		}
		timeLeft.setText("Moves Left: " + l.getMovesRemaining());
		score.setText("Score: " + l.getScore());
		swap.setText("Swap (" + swapMoves + ")");
		rearrange.setText("Rearrange (" + rearrangeMoves + ")");
		clear.setText("Clear (" + clearMoves + ")");
	}
	
	public JButton getRearrangeButton() {
		return rearrange;
	}
	public JButton getSwapButton() {
		return swap;
	}
	public JButton getClearButton() {
		return clear;
	}
}
