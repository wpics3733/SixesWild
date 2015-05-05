package controller;

import javax.swing.JDialog;

import model.IOnLevelAchievement;
import model.Level;
import model.LevelState;
import model.LightningLevel;
import model.LightningTimer;
import view.Application;
import view.EndLevelPanel;
import view.LevelView;

/**
 * When a level is done, this controller is run.
 * If the user passed the level, it saves their high score and unlocks the
 * next level
 * 
 * Then it shows them a screen asking if they want to retry, or quit to main menu
 * @author jesse
 *
 */
public class EndLevelController {
	
	Level l;
	Level next;
	LevelView lv;
	Application a;
	

	/**
	 * Constructs a new EndLevelController
	 * @param l	The level we are ending
	 * @param next	the next level, if we pass l, next will be unlocked
	 * @param lv	the levelView associated with l
	 * @param a		the top level application. We need this to switch to the EndLevelPanel
	 */
	public EndLevelController(Level l, Level next, LevelView lv, Application a) {
		this.l = l;
		this.lv = lv;
		this.a = a;
		this.next = next;
	}
	
	/**
	 * runs the Controller. This assumes l has just been completed
	 * If we pass, it checks the high score with the one on record, overwriting if necessary
	 * Then it unlocks the next level to play
	 */
	public void run() {
		if(l.hasPassed()) {
			LevelState state = l.getLevelState();
			if(l.getScore() > state.getHighScore()) {
				state.setHighScore(l.getScore());
				state.saveState();
				System.out.println("High Score");
			}
			if (next != null) {
				next.getLevelState().setUnlocked(true);
				next.getLevelState().saveState();
			} else {
			}
		}
		
		IOnLevelAchievement.checkAll(l);
		AchievementFileController.saveFile();
		
		a.changeView(new EndLevelPanel(l, lv, a));
	}

}
