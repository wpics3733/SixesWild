package controller;

import view.LevelView;
import model.Level;
import model.LightningLevel;

public class LightningCountdownController {
	Level l;
	LevelView lv;
	
	public LightningCountdownController(LightningLevel l, LevelView lv) {
		l.setTimeRemaining(l.getTimeRemaining() - 1);
	}

}
