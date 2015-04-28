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

}
