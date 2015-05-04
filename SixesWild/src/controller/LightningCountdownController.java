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
	
	public LightningCountdownController(LightningLevel l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}
	
	public void run() {
		l.setTimeRemaining(l.getTimeRemaining() - 1);
		lv.repaint();
		if(l.isFinished()) {
			lv.endLevel();
		}
		
	}

}
