
package view;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.MouseInputListener;

import controller.InitiateClearMoveController;
import controller.InitiateSwapMoveController;
import controller.MakeUserMoveController;
import controller.RearrangeBoardController;
import model.Level;

/**
 * The view associated with playing a level.
 * it directly contains the board view
 * it indirectly contains the progress bar, special moves buttons, moves left indicator, etc
 * This is intended to be a top level JPanel, it should be the only thing in a frame
 * @author jesse
 *
 */
public class LevelView extends JPanel {

	static final long serialVersionUID = 1;
	private Application parent;

	Level l;
	BoardPanel bp;
	TopBarPanel tbp;
	JPanel eastPanel;
	JLabel sideWord;
	GameWestPanel westPanel;
	
	MouseInputListener controller;

	public LevelView(Level l, Application parent) {
		super();
		this.parent = parent;
		this.l = l;
		this.bp = new BoardPanel(this);
		this.controller = new MakeUserMoveController(l, this);
		bp.addMouseListener(controller);
		bp.addMouseMotionListener(controller);
		this.tbp = new TopBarPanel(l, parent);
		this.sideWord = new JLabel("<html><center>S<br>i<br>x<br>e<br>s<br> <br>W<br>i<br>l<br>d<br><center></html>");
		this.westPanel = new GameWestPanel(l);
		JPanel eastPanel = new JPanel();
		
		this.tbp.getRearrangeButton().addMouseListener(new RearrangeBoardController(l, this));
		this.tbp.getSwapButton().addMouseListener(new InitiateSwapMoveController(l, this));
		this.tbp.getClearButton().addMouseListener(new InitiateClearMoveController(l, this));

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
		sideWord.setFont(new Font("Sans", Font.BOLD, 30));

		this.setLayout(new BorderLayout());
		this.add(bp, BorderLayout.CENTER);
		this.add(tbp, BorderLayout.NORTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(westPanel, BorderLayout.WEST);

	}
	
	/**
	 * Change the move controller associated with the board.
	 * The default is a MakeUserMoveController, which handles standard swipe moves
	 * However, if it is desired to use a special move, the special move controller
	 * can call this method to instead bind a MakeSpecialMoveController to the board
	 * 
	 * @param controller the new controller to bind to the board
	 */
	public void changeController(MouseInputListener controller) {
		this.bp.removeMouseListener(this.controller);
		this.bp.removeMouseMotionListener(this.controller);
		this.controller = controller;
		this.bp.addMouseListener(controller);
		this.bp.addMouseMotionListener(controller);
	}

	/**
	 * Returns the level that this LevelView represents
	 * @return
	 */
	public Level getLevel() {
		return l;
	}

	/**
	 * Returns the BoardPanel contained in this view.
	 * @return
	 */
	public BoardPanel getBoard() {
		return bp;
	}
}
