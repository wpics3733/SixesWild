package model;

public class LightningLevel extends Level {
	int timeRemaining;
	LightningTimer timer;
	
	public LightningLevel() {
		this(new LevelState());
		this.timeRemaining = 10;
	}
	
	public LightningLevel(LevelState state) {
		super(state);
		this.timer = new LightningTimer();
		this.timeRemaining = state.getTimeLimit();
	}


	@Override
	public boolean isFinished() {
		return timeRemaining <= 0;
	}

	@Override
	public boolean hasPassed() {
		return getScore() >= getMilestones()[0];
	}

	@Override
	public String typeString() {
		return "Lightning";
	}
	
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	public void setTimeRemaining(int time) {
		this.timeRemaining = time;
	}
	
	public void restart() {
		super.restart();
		this.timer = new LightningTimer();
		this.timeRemaining = state.getTimeLimit();
	}
	
	public LightningTimer getTimer() {
		return timer;
	}

}
