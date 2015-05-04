package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import view.LevelView;
import model.Level;

/**
 * This controller is bound to the "Restart" button in the LevelView
 * When pressed, it restarts the level, and refreshes the gui.
 * 
 * Restarting the level refreshes the board to the original state, sets the score to 0
 * resests the counters on all special moves, and unmarks all marked tiles
 * @author jesse
 *
 */
public class RestartLevelController implements MouseInputListener {
	Level l;
	LevelView lv;

	public RestartLevelController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		l.restart();
		lv.restart(l);
		lv.repaint();
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
