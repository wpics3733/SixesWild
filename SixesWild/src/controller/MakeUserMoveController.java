package controller;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import view.BoardPanel;
import view.LevelView;
import view.TilePanel;
import model.Level;
import model.UserMove;

/**
 * User moves are the default type. Dragging across one or more tiles is a usermove
 * When the sum of the dragged tiles is exactly six (excluding the case where only one 6 is selected)
 * that constitutes a valid move.
 * 
 * Drag across multiple tiles, then release to complete the move.
 * If the move is valid, it will add the score to the level
 * 
 * The score of a UserMove is 10 * the number of tiles * multiplier1 * multiplier2 * ...
 * 
 * @author jesse
 *
 */
public class MakeUserMoveController extends MouseAdapter {
	Level l;
	LevelView lv;
	BoardPanel bp;
	UserMove um;

	/**
	 * Constructs a new MakeUserMoveController for the given Level and its associated LevelView
	 * @param l		The level the user is playing
	 * @param lv	The LevelView associated with l
	 */
	public MakeUserMoveController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.bp = lv.getBoard();
		this.um = null;
	}

	/**
	 * Initiate a new UserMove, and try to add the current tile
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		um = new UserMove();
		this.mouseDragged(arg0);
	}

	/**
	 * Check to see if the userMove we have created is valid, if so, run it
	 * After every move, check to see if the level is complete
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(this.um == null) {
			return;
		}
		if(um.isValid()) {
			um.pushMove(l);
		}
		l.react(um);
		um.finishMove(l);
		if(l.isFinished()) {
			lv.endLevel();
			return;
		}
		lv.repaint();
		this.um = null;
	}

	/**
	 * As the mouse is dragged, any tiles it drags over will be added to the move
	 * if they are adjacent to any existing tiles, or they are the first tile
	 * 
	 * Note: We do not stop adding tiles after the sum reaches six, so invalid moves
	 * are entirely possible, and subtract moves from the user
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(this.um == null) {
			return;
		}
		Component c = bp.getComponentAt(arg0.getPoint());
		if(c instanceof TilePanel) {
			if(um.addTile( ((TilePanel)c).getTile() )) {
				((TilePanel)c).repaint();
			}
		} 
	}

}
