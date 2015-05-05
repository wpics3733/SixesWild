package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import view.Application;
import view.PastLevelButton;
import view.PastLevelPanel;
import model.Level;
import model.LevelState;

/**
 * This controller resets all progress made so far.
 * All unlocked levels (except the first) are re-lockd
 * All high scores are set to 0
 * All bound PlayPastLevel controllers are unbound, except the first
 * @author jesse
 *
 */
public class ResetProgressController extends MouseAdapter {
	
	ArrayList<Level> levels;
	PastLevelPanel view;
	ArrayList<PastLevelButton> buttons;
	
	/**
	 * Construct a new ResetProgressController 
	 * 
	 * @param levels	The list of all levels in the game
	 * @param view		The PastLevelPanel containing all PastLevelButtons
	 * @param buttons	The list of PastLevelButtons in the view
	 */
	public ResetProgressController(ArrayList<Level> levels, PastLevelPanel view, ArrayList<PastLevelButton> buttons) {
		this.buttons = buttons;
		this.levels = levels;
		this.view = view;
	}

	/**
	 * Reset all level progress and high scores
	 * Lock all but the first level
	 * Unbind controllers from the PastLevelButtons
	 * Cannot be undone
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		for(Level l: levels) {
			LevelState state = l.getLevelState();
			state.setHighScore(0);
			state.setUnlocked(false);
			state.saveState();
		}
		for(int i = 1; i < buttons.size(); i++) {
			PastLevelButton b = buttons.get(i);
			b.removeMouseListener(b.getController());
		}
		levels.get(0).getLevelState().setUnlocked(true);
		view.repaint();
	}

}
