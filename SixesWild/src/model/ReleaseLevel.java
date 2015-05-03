package model;

public class ReleaseLevel extends Level {
	int movesRemaining;
	
	
	public ReleaseLevel() {
		this(new LevelState());
		this.movesRemaining = 10;
	}
	
	public ReleaseLevel(LevelState state) {
		super(state);
		this.movesRemaining = state.getMoveLimit();
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPassed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String typeString() {
		// TODO Auto-generated method stub
		return null;
	}

}
