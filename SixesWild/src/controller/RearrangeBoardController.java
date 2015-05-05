package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.LevelView;
import model.Level;
import model.RearrangeMove;

/**
 * The controller attached to the "Rearrange" button in the LevelView
 * Pressing the button will replace all non-six
 * @author jesse
 *
 */
public class RearrangeBoardController extends MouseAdapter {
	Level l;
	LevelView lv;
	
	/**
	 * Construct a new RearrangeBoardController for the given Level
	 * and its associated LevelView
	 * @param l		The level the user is playing
	 * @param lv	The View associated with that level
	 */
	public RearrangeBoardController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(l.hasSpecial(Level.REARRANGE)) {
		RearrangeMove move = new RearrangeMove();
		move.pushMove(l);
		if(l.isFinished()) {
			lv.endLevel();
			return;
		}
		lv.repaint();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
