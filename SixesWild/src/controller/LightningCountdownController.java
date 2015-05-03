package controller;

import view.LevelView;
import model.Level;
import model.LightningLevel;

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
