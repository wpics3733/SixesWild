package controller;

import view.LevelView;
import model.Level;
import model.LightningLevel;

/**
 * In a lightning level, this controller is run by the timer each second
 * It decrements the time remaining, and checks if you are out of time
 * When you are out of time, it ends the level
 * @author jesse
 *
 */
public class LightningCountdownController {
	LightningLevel l;
	LevelView lv;
	
	/**
	 * make a new LightningCountdownController
	 * @param l		The lightningLevel the user is playing
	 * @param lv	the levelView associated with l
	 */
	public LightningCountdownController(LightningLevel l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}
	
	/**
	 * Runs the controller
	 * decrements the time remaining by one, if that was the last second,
	 * stops the timer and ends the level
	 */
	public void run() {
		l.setTimeRemaining(l.getTimeRemaining() - 1);
		lv.repaint();
		if(l.isFinished()) {
			l.getTimer().cancel();
			lv.endLevel();
		}
		
	}

}
