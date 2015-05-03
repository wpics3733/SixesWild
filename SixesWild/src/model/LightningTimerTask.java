package model;

import java.util.TimerTask;

import controller.LightningCountdownController;
import view.Application;
import view.LevelView;

public class LightningTimerTask extends TimerTask {
	
	LightningLevel l;
	LevelView lv;
	LightningCountdownController controller;

	
	public LightningTimerTask(LightningLevel l, LevelView lv) {
		this.l = l;
		this.lv = lv;
		this.controller = new LightningCountdownController(l, lv);
	}


	@Override
	public void run() {
		controller.run();
		
	}

}
