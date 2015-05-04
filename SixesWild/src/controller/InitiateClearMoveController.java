package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import model.Level;
import view.LevelView;

/**
 * This is the controller attached to the "Clear" button in the top bar
 * When it is pressed, it attaches a clearMoveController to the game board
 * @author jesse
 *
 */
public class InitiateClearMoveController extends MouseAdapter {
	
	Level l;
	LevelView lv;
	
	/**
	 * Make a new InitiateClearMoveController
	 * @param l		the level we are playing
	 * @param lv	the levelView associated with l
	 */
	public InitiateClearMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(l.hasSpecial(Level.CLEAR)) {
			lv.changeController((MouseInputListener)new MakeClearMoveController(l, lv));
		}
		
	}
}
