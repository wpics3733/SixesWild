package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.EliminationLevel;
import model.Level;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;
import view.Application;
import view.LevelView;

/**
 * The controller attached to each Level button in the PastLevelsView
 * clicking on the button takes you to a LevelView for that level
 * @author jesse
 *
 */
public class PlayPastLevelController extends MouseAdapter {
	Application parent;
	Level toPlay, next;
	
	/**
	 * Construct a new PlayPastLevelController in the given Application frame
	 * topPlay is the Level that will start when the button is pressed
	 * next is the Level that will be unlocked after toPlay is completed
	 * @param parent	The top level application frame
	 * @param toPlay	The level that will start
	 * @param next		The level that should be unlocked if toPlay is passed (can be null if toPlay is the last level)
	 */
	public PlayPastLevelController(Application parent, Level toPlay, Level next) {
		this.parent = parent;
		this.toPlay = toPlay;
		this.next = next;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		LevelView lv;
		if(toPlay instanceof PuzzleLevel) {
			lv = new LevelView((PuzzleLevel)toPlay, next, parent);
		} else if (toPlay instanceof EliminationLevel) {
			lv = new LevelView((EliminationLevel)toPlay, next, parent);
		} else if (toPlay instanceof ReleaseLevel) {
			lv = new LevelView((ReleaseLevel)toPlay, next, parent);
		} else {
			lv = new LevelView((LightningLevel)toPlay, next, parent);
		}
		parent.changeView(lv);
		
	}
}