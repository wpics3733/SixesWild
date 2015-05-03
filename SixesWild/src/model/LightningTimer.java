package model;

import java.util.Timer;

public class LightningTimer {
	
	Timer realTimer;
	
	public LightningTimer() {
		this.realTimer = new Timer();
	}
	
	public Timer getTimer() {
		return realTimer;
	}
	
	public void cancel() {
		realTimer.cancel();
	}

}
