
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
		this.setLayout(new BorderLayout());

		this.bp = new BoardPanel(this);
		this.add(bp, BorderLayout.CENTER);

		this.sideWord = new JLabel("<html><center>S<br>i<br>x<br>e<br>s<br> <br>W<br>i<br>l<br>d<br><center></html>");
		sideWord.setFont(new Font("Sans", Font.BOLD, 30));
		this.add(sideWord, BorderLayout.EAST);

		this.westPanel = new GameWestPanel(l, this);
		this.add(westPanel, BorderLayout.WEST);

		this.tbp = new TopBarPanel(l, parent);
		this.tbp.getRearrangeButton().addMouseListener(new RearrangeBoardController(l, this));
		this.tbp.getSwapButton().addMouseListener(new InitiateSwapMoveController(l, this));
		this.tbp.getClearButton().addMouseListener(new InitiateClearMoveController(l, this));
		this.add(tbp, BorderLayout.NORTH);

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
		if(l.hasPassed()) {
			//Should replace this with a popup menu with retry or back to main menu
			System.out.println("You have passed the level, congratulations");
			//Save level to disk
		} else {
			System.out.println("You have finished the level, but not passed, try again");
		}
		this.parent.changeView(new MainMenuView(parent));
	}

	public void restart() {
		l.restart();
		this.parent.changeView(new LevelView(l, parent));

	}
	
}
