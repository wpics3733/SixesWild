package view;

import java.awt.Color;
import java.awt.Graphics;

import controller.ExitLightningLevelController;
import controller.InitiateClearMoveController;
import controller.InitiateSwapMoveController;
import controller.RearrangeBoardController;
import controller.ReturnToMenuController;
import model.Level;
import model.LightningLevel;
import model.LightningTimer;
import model.LightningTimerTask;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

/**
 * Each Level type needs to display different information in the top bar
 * Lightning levels need to show the time left and count down each second
 * @author jesse
 *
 */
public class LightningTopBarPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	LightningLevel l;
	LevelView lv;
	Application parent;
	
	private JButton clear;
	private JButton swap;
	private JButton quit;
	private JButton rearrange;
	private JLabel score;
	private JLabel timeLeft;
	
	private LightningTimer timer;
	
	/**
	 * Construct a new LightningTopBarPanel for the given LightningLevel, its associated view, and the Application frame
	 * containing it
	 * @param l		 the level
	 * @param lv	 the view for l
	 * @param parent the Application frame
	 */
	public LightningTopBarPanel(LightningLevel l, LevelView lv, Application parent) {
		
		timer = l.getTimer();
		LightningTimerTask task = new LightningTimerTask(l, lv);
		timer.getTimer().schedule(task, 0, 1000);
		
		this.l = l;
		this.lv = lv;
		this.parent = parent;
		
		clear = new JButton("Clear");
		swap = new JButton("Swap");
		rearrange = new JButton("Rearrange");
		
		quit = new JButton("Quit");
		quit.addMouseListener(new ExitLightningLevelController(l, parent));
		
		timeLeft = new JLabel();
		timeLeft.setFont(new Font("AvenyyirNext", Font.PLAIN, 20));
		timeLeft.setForeground(Color.WHITE);
		
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
		
		
		this.rearrange.addMouseListener(new RearrangeBoardController(l, lv));
		this.swap.addMouseListener(new InitiateSwapMoveController(l, lv));
		this.clear.addMouseListener(new InitiateClearMoveController(l, lv));
		setLayout(groupLayout);
		setBackground(new Color(112,147,113));

	}
	
	/**
	 * Whenever the bar repaints, it needs to update the number of special moves remaining (possibly disabling the buttons)
	 * and update how many seconds the user has left
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if(l.getNumSpecial(Level.SWAP) <= 0) swap.setEnabled(false);
		if(l.getNumSpecial(Level.REARRANGE) <= 0)	rearrange.setEnabled(false);
		if(l.getNumSpecial(Level.CLEAR) <= 0) clear.setEnabled(false);

		timeLeft.setText("Time Left: " + l.getTimeRemaining());
		score.setText("Score: " + l.getScore());
		swap.setText("Swap (" + l.getNumSpecial(Level.SWAP) + ")");
		rearrange.setText("Rearrange (" + l.getNumSpecial(Level.REARRANGE) + ")");
		clear.setText("Clear (" + l.getNumSpecial(Level.CLEAR) + ")");
	}
}
