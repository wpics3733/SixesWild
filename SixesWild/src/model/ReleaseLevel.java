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
		if(movesRemaining <= 0 || allBucketsFull()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasPassed() {
		return allBucketsFull() && getScore() > getMilestones()[0];
	}
	
	private boolean allBucketsFull() {
		AbstractTileContainer[][] tiles = this.getBoard().getTileContainers();
		for(int i = 0; i < this.getBoard().getW(); i++) {
			for(int j = 0; j < this.getBoard().getH(); j++) {
				if(tiles[i][j] instanceof BucketTileContainer) {
					if(tiles[i][j].empty()) {
						return false;
					}	
				}
			}
		}
		return true;
	}

	@Override
	public String typeString() {
		return "Release";
	}
	
	public int getMovesRemaining() {
		return this.movesRemaining;
	}
	
	public void setMovesRemaining(int moves) {
		this.movesRemaining = moves;
	}
	
	@Override
	public void react(IMove move) {
		super.react(move);
		if(move instanceof UserMove || move instanceof RearrangeMove) {
			this.movesRemaining--;
		}
	}
	
	public void restart() {
		super.restart();
		this.movesRemaining = state.getMoveLimit();
		
	}
}
