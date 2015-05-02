package model;

public class EliminationLevel extends Level {
	int movesRemaining;
	
	public EliminationLevel(LevelState state) {
		super(state);
		this.movesRemaining = state.getMoveLimit();
	}
	
	public EliminationLevel() {
		super();
		this.movesRemaining = 10;
	}

	@Override
	public boolean isFinished() {
		if(this.movesRemaining <= 0) {
			return true;
		}
		for(int i = 0; i < this.getBoard().getW(); i++) {
			for(int j = 0; j < this.getBoard().getH(); j++) {
				if(this.getBoard().getTileContainers()[i][j].getMarked() == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean hasPassed() {
		TileContainer[][] tiles = this.getBoard().getTileContainers();
		for(int i = 0; i < this.getBoard().getW(); i++) {
			for(int j = 0; j < this.getBoard().getH(); j++) {
				if(tiles[i][j].isNull() == false && tiles[i][j].getMarked() == false) {
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
			movesRemaining--;
			for(TileContainer tc: move.getTiles()) {
				tc.setMarked(true);
			}
		} else if (move instanceof RearrangeMove) {
			movesRemaining--;
		}
		super.react(move);
	}

	@Override
	public String typeString() {
		return "Elimination";
	}
	
	public int getMovesRemaining() {
		return movesRemaining;
	}
	
	public void setMovesRemaining(int moves) {
		this.movesRemaining = moves;
	}
	

}
