package controller;

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
public class InitiateClearMoveController implements MouseInputListener {
	
	Level l;
	LevelView lv;
	
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

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg0) {}

}
