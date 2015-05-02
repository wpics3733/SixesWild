package model;

public class LightningLevel extends Level {
	int timeRemaining;
	
	public LightningLevel() {
		super();
		timeRemaining = 60;
	}
	
	public LightningLevel(LevelState state) {
		super(state);
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

}
