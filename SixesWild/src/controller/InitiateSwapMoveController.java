package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import model.Level;
import view.LevelView;

/**

 * This is the controller attached to the "Swap" button in the top bar
 * When it is pressed, it attaches a SwapMoveController to the game board
 * @author jesse

 */
public class InitiateSwapMoveController extends MouseAdapter {

	Level l;
	LevelView lv;

	/**
	 * Make a new InitiateSwapMoveController
	 * @param l		the level we are playing
	 * @param lv	the levelView associated with l
	 */
	public InitiateSwapMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}

	/**
	 * Set the active controller on the board to a MakeSwapMoveController
	 * do this only if the User has a SwapMove to use
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(l.hasSpecial(Level.SWAP)) {
			lv.changeController(new MakeSwapMoveController(l, lv));
		}

	}
}