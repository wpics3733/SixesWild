package model;

public class EliminationLevel extends Level {

	@Override
	public boolean isFinished() {
		if(this.movesRemaining <= 0) {
			return true;
		}
		for(int i = 0; i < this.getBoard().getW(); i++) {
			for(int j = 0; j < this.getBoard().getH(); j++) {
				if(this.getBoard().getTiles()[i][j].getMarked() == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean hasPassed() {
		for(int i = 0; i < this.getBoard().getW(); i++) {
			for(int j = 0; j < this.getBoard().getH(); j++) {
				if(this.getBoard().getTiles()[i][j].getMarked() == false) {
					return false;
				}
			}
		}
		if(this.getScore() < this.getMilestones()[0]) {
			return false;
		}
		return true;
	}
	
	@Override
	public void react(IMove move) {
		if(move instanceof UserMove) {
			for(TileContainer tc: move.getTiles()) {
				tc.setMarked(true);
			}
		}
		super.react(move);
	}

	@Override
	public String typeString() {
		return "Elimination";
	}
	

}
