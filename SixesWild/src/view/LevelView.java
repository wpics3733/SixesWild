
package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;

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
import model.ReleaseLevel;

public class LevelView extends JPanel {

	static final long serialVersionUID = 1;
	private Application parent;

	Level l, next;
	BoardPanel bp;
	JPanel eastPanel;
	JLabel sideWord;
	GameWestPanel westPanel;
	JPanel topBar;
	
	MouseAdapter controller;
	
	private LevelView(Level l, Level next, Application parent) {
		super();
		this.l = l;
		this.next = next;
		this.parent = parent;
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
	
	/**
	 * Construct a new LevelView for a PuzzleLevel, as well as the next level that will be unlocked
	 * The only difference between constructors is which Top Panel is used
	 * @param l			The level
	 * @param next		The next level
	 * @param parent	The top level Application frame
	 */
	public LevelView(PuzzleLevel l, Level next, Application parent) {
		this((Level)l, next, parent);
		this.topBar = new PuzzleTopBarPanel(l, this, parent);
		this.add(topBar, BorderLayout.NORTH);
	}
	
	/**
	 * Construct a new LevelView for a EliminationLevel, as well as the next level that will be unlocked
	 * The only difference between constructors is which Top Panel is used
	 * @param l			The level
	 * @param next		The next level
	 * @param parent	The top level Application frame
	 */
	public LevelView(EliminationLevel l, Level next, Application parent) {
		this((Level)l, next, parent);
		this.topBar = new EliminationTopBarPanel(l, this, parent);
		this.add(topBar, BorderLayout.NORTH);
	}
	
	/**
	 * Construct a new LevelView for a LightningLevel, as well as the next level that will be unlocked
	 * The only difference between constructors is which Top Panel is used
	 * @param l			The level
	 * @param next		The next level
	 * @param parent	The top level Application frame
	 */
	public LevelView(LightningLevel l, Level next, Application parent) {
		this((Level)l, next, parent);
		this.topBar = new LightningTopBarPanel(l, this, parent);
		this.add(topBar, BorderLayout.NORTH);
	}
	
	/**
	 * Construct a new LevelView for a ReleaseLevel, as well as the next level that will be unlocked
	 * The only difference between constructors is which Top Panel is used
	 * @param l			The level
	 * @param next		The next level
	 * @param parent	The top level Application frame
	 */
	public LevelView(ReleaseLevel l, Level next, Application parent) {
		this((Level)l, next, parent);
		this.topBar = new ReleaseTopBarPanel(l, this, parent);
		this.add(topBar, BorderLayout.NORTH);
	}
	
	/**
	 * Change which controller is currently bound to the board.
	 * Invoked when the "Swap" button (for example) is pressed,
	 * and the InitiateSwapMoveController changes the active controller to
	 * a new MakeSwapMoveController
	 * 
	 * Before setting the new controller, the previous one is removed
	 * 
	 * @param controller	the new controller
	 */
	public void changeController(MouseAdapter controller) {
		if(controller != null) {
			this.bp.removeMouseListener(this.controller);
			this.bp.removeMouseMotionListener(this.controller);
		}
		this.controller = controller;
		this.bp.addMouseListener(controller);
		this.bp.addMouseMotionListener(controller);
	}

	/**
	 * Returns the level associated with this levelView
	 * @return	the level
	 */
	public Level getLevel() {
		return l;
	}
	
	/**
	 * Returns the board associated with this
	 * @return	the board
	 */
	public BoardPanel getBoard() {
		return bp;
	}
	
	/**
	 * When the level is finished, this invokes a new EndLevelController to show the user
	 * their score and ask them if they want to retry or return to menu
	 */
	public void endLevel() {
		this.setEnabled(false);
		EndLevelController end = new EndLevelController(l, next, this, parent);
		end.run();
	}

	/**
	 * Restart the level
	 */
	public void restart() {
		if(l instanceof PuzzleLevel) {
			this.parent.changeView(new LevelView((PuzzleLevel)l, next, parent));
		} else if(l instanceof EliminationLevel) {
			this.parent.changeView(new LevelView((EliminationLevel)l, next, parent));
		} else if(l instanceof LightningLevel) {
			this.parent.changeView(new LevelView((LightningLevel)l, next, parent));
		} else if(l instanceof ReleaseLevel) {
			this.parent.changeView(new LevelView((ReleaseLevel)l, next, parent));
		}
	}
}
