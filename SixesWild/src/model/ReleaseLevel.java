package model;

/**
 * Release levels have a number of buckets. The goal is to drop a "6" tile into each bucket
 * When every bucket is filled, the level is complete
 * 
 * The player has a certain number of moves to do this, if they run out of moves, they lose
 * @author jesse
 *
 */
public class ReleaseLevel extends Level {
	int movesRemaining;
	
	/**
	 * Construct a new ReleaseLevel from the given state
	 * @param state	a loaded levelState, should be of type release
	 */
	public ReleaseLevel(LevelState state) {
		super(state);
		this.movesRemaining = state.getMoveLimit();
	}

	/**
	 * ReleaseLevels are only finished when the user runs out of moves or
	 * all buckets are full
	 */
	@Override
	public boolean isFinished() {
		if(movesRemaining <= 0 || allBucketsFull()) {
			return true;
		}
		return false;
	}

	/**
	 * The player cannot win if there is an empty bucket. 
	 * They also need to have achieved at least one star
	 */
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

	/**
	 * This level is of type "Release"
	 */
	@Override
	public String typeString() {
		return "Release";
	}
	
	/**
	 * get how many moves the user has left
	 * @return	the number of remaining moves
	 */
	public int getMovesRemaining() {
		return this.movesRemaining;
	}
	
	/**
	 * UserMoves and RearrangeMoves us up one moveRemaining, that is the only effect on the level
	 */
	@Override
	public void react(IMove move) {
		super.react(move);
		if(move instanceof UserMove || move instanceof RearrangeMove) {
			this.movesRemaining--;
		}
	}
	
	/**
	 * Restart the level
	 */
	public void restart() {
		super.restart();
		this.movesRemaining = state.getMoveLimit();
		
	}
}
