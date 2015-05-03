package view;

import java.awt.Color;
import java.awt.Graphics;

import controller.InitiateClearMoveController;
import controller.InitiateSwapMoveController;
import controller.RearrangeBoardController;
import controller.ReturnToMenuController;
import model.Level;
import model.PuzzleLevel;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

public class PuzzleTopBarPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	PuzzleLevel l;
	LevelView lv;
	Application parent;
	
	private JButton clear;
	private JButton swap;
	private JButton quit;
	private JButton rearrange;
	private JLabel score;
	private JLabel movesLeft;
	
	public PuzzleTopBarPanel(PuzzleLevel l, LevelView lv, Application parent) {
		
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
		movesLeft.setText("Moves Left: " + l.getMovesRemaining());
		score.setText("Score: " + l.getScore());
		swap.setText("Swap (" + swapMoves + ")");
		rearrange.setText("Rearrange (" + rearrangeMoves + ")");
		clear.setText("Clear (" + clearMoves + ")");
	}
}
