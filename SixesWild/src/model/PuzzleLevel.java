package model;

public class PuzzleLevel extends Level {
	
	@Override
	public boolean isFinished() {
		return this.getMovesRemaining() == 0;
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

}
