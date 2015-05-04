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
	

	public EndLevelController(Level l, Level next, LevelView lv, Application a) {
		this.l = l;
		this.lv = lv;
		this.a = a;
		this.next = next;
	}
	
	public void run() {
		if(l instanceof LightningLevel) {
			((LightningLevel)l).getTimer().cancel();
		}
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
