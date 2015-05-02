package model;

import java.util.TimerTask;

import view.LevelView;

public class LightningTimerTask extends TimerTask {
	Level l;
	LevelView lv;

	public LightningTimerTask(Level l, LevelView lv) {
		this.l = l;
		this.lv = lv;
	}

	@Override
	public void run() {
		
		
	}

}
