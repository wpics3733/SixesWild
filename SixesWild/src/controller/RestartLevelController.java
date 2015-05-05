package controller;

import java.awt.event.MouseAdapter;
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
public class RestartLevelController extends MouseAdapter {
	Level l;
	LevelView lv;

	/**
	 * Construct a new RestartLevelController for the given Level and its associated view
	 * @param l		The level that the user is playing
	 * @param lv	The view for l
	 */
	public RestartLevelController(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		
	}

	/**
	 * Restart the Level and refresh the GUI
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		l.restart();
		lv.restart();
		lv.repaint();
	}
}
