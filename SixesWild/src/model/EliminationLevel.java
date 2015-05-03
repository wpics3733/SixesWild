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
		return allTilesMarked() || movesRemaining <= 0;
	}
	
	@Override
	public boolean hasPassed() {
		return allTilesMarked() && oneStar();
	}
	
	private boolean oneStar() {
		if( this.getScore() < this.getMilestones()[0]) {
			return false;
		}
		return true;
	}
	
	private boolean allTilesMarked() {
		AbstractTileContainer[][] tiles = this.getBoard().getTileContainers();
		for(int i = 0; i < this.getBoard().getW(); i++) {
			for(int j = 0; j < this.getBoard().getH(); j++) {
				if(tiles[i][j].marked() == false) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	@Override
	public void react(IMove move) {
		if(move instanceof UserMove || move instanceof RearrangeMove) {
			movesRemaining--;
		}
		if( move instanceof UserMove && move.isValid()) {
			for(AbstractTileContainer tc: move.getTiles()) {
				tc.mark();
			}
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
	
	public void restart() {
		super.restart();
		this.movesRemaining = state.getMoveLimit();
	}
	

}
