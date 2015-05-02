package model;

public class PuzzleLevel extends Level {
	
	int movesRemaining;

	public PuzzleLevel(LevelState state) {
		super(state);
		movesRemaining = state.getMoveLimit();
	}
	
	public PuzzleLevel() {
		super();
		movesRemaining = 10;
	}
	
	@Override
	public boolean isFinished() {
		return this.movesRemaining == 0;
	}

	@Override
	public void react(IMove move) {
	}

	@Override
	public String typeString() {
		return "Puzzle";
	}

	@Override
	public boolean hasPassed() {
		if(this.getScore() < this.getMilestones()[0]) {
			return false;
		}
		return true;

	}

	public int getMovesRemaining() {
		return movesRemaining;
	}
	
	public void setMovesRemaining(int moves) {
		this.movesRemaining = moves;
	}

}
