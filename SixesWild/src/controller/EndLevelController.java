package controller;

import javax.swing.JDialog;

import model.IOnLevelAchievement;
import model.Level;
import view.Application;
import view.EndLevelPanel;
import view.LevelView;

public class EndLevelController {
	
	Level l;
	LevelView lv;
	Application a;
	

	public EndLevelController(Level l, LevelView lv, Application a) {
		this.l = l;
		this.lv = lv;
		this.a = a;
	}
	
	public void run() {
		a.changeView(new EndLevelPanel(l, lv, a));
		//Check score
		//Generate a popup window, telling the user they have won or lost
		//Ask them if they want to restart to try and do better, or quit to main menu
		
		
		// After each level i finished, we check the achievements to see if any have been unlocked
		// then we save the achievements to a file so that they can be loaded the next time we start the game
		IOnLevelAchievement.checkAll(l);
		AchievementFileController.saveFile();
	}

}
