package controller;

import javax.swing.JDialog;

import model.Level;
import view.Application;
import view.EndLevelPopup;
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
		JDialog popup = new EndLevelPopup(l, lv, a);
		popup.setVisible(true);
		//Check score
		//Generate a popup window, telling the user they have won or lost
			//Ask them if they want to restart to try and do better, or quit to main menu
	}

}
