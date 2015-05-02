package model;

import java.util.Timer;

public class LightningTimer {
	
	static Timer realTimer;
	static LightningTimer instance;
	
	
	private LightningTimer() {}
	
	public static LightningTimer getInstance() {
		if (instance == null) {
			instance = new LightningTimer();
			realTimer = new Timer();
		}
		return instance;
	}
	
	public Timer getTimer() {
		return realTimer;
	}

}
