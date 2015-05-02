
package view;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.MouseInputListener;

import controller.EndLevelController;
import controller.InitiateClearMoveController;
import controller.InitiateSwapMoveController;
import controller.MakeUserMoveController;
import controller.RearrangeBoardController;
import model.EliminationLevel;
import model.Level;
import model.LightningLevel;
import model.PuzzleLevel;

public class LevelView extends JPanel {

	static final long serialVersionUID = 1;
	private Application parent;

	Level l;
	BoardPanel bp;
	JPanel eastPanel;
	JLabel sideWord;
	GameWestPanel westPanel;
	JPanel topBar;
	
	MouseInputListener controller;
	
	private LevelView(Level l, Application parent) {
		super();
		this.l = l;
		this.setLayout(new BorderLayout());

		this.bp = new BoardPanel(this);
		this.add(bp, BorderLayout.CENTER);

		this.sideWord = new JLabel("<html><center>S<br>i<br>x<br>e<br>s<br> <br>W<br>i<br>l<br>d<br><center></html>");
		sideWord.setFont(new Font("Sans", Font.BOLD, 30));
		this.add(sideWord, BorderLayout.EAST);

		this.westPanel = new GameWestPanel(l, this);
		this.add(westPanel, BorderLayout.WEST);


		this.eastPanel = new JPanel();
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
		this.add(eastPanel, BorderLayout.EAST);

		this.changeController(new MakeUserMoveController(l, this));
		
	}
	
	public LevelView(PuzzleLevel l, Application parent) {
		this((Level)l, parent);
		this.topBar = new PuzzleTopBarPanel(l, this, parent);
		this.add(topBar, BorderLayout.NORTH);
	}
	
	public LevelView(EliminationLevel l, Application parent) {
		this((Level)l, parent);
		this.topBar = new EliminationTopBarPanel(l, this, parent);
		this.add(topBar, BorderLayout.NORTH);
	}
	
	public LevelView(LightningLevel l, Application parent) {
		this((Level)l, parent);
		this.topBar = new LightningTopBarPanel(l, this, parent);
		this.add(topBar, BorderLayout.NORTH);
	}
	
	public void changeController(MouseInputListener controller) {
		if(controller != null) {
			this.bp.removeMouseListener(this.controller);
			this.bp.removeMouseMotionListener(this.controller);
		}
		this.controller = controller;
		this.bp.addMouseListener(controller);
		this.bp.addMouseMotionListener(controller);
	}

	public Level getLevel() {
		return l;
	}
	
	public BoardPanel getBoard() {
		return bp;
	}
	
	/**
	 * if the level is finished, this will check if the user has passed the level.
	 * If they have, it will save their score to disk
	 * No matter what, it will then return them to the main menu
	 */
	public void endLevel() {
		this.setEnabled(false);
		EndLevelController end = new EndLevelController(l, this, parent);
		end.run();
	}

	public void restart(Level l) {
		if(l instanceof PuzzleLevel) {
			this.parent.changeView(new LevelView((PuzzleLevel)l, parent));
		}
		if(l instanceof EliminationLevel) {
			this.parent.changeView(new LevelView((EliminationLevel)l, parent));
		}
		if(l instanceof LightningLevel) {
			this.parent.changeView(new LevelView((LightningLevel)l, parent));
		}
	}
}
