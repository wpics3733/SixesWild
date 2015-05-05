package model;

/**
 * The goal of an elimination level is to use every tile once in a UserMove
 * (Special moves do not count)
 * You have a certain number of moves to try to accomplish this, and if you do not
 * mark all tiles before you run out of moves, you lose
 * 
 * 
 * @author jesse
 *
 */
public class EliminationLevel extends Level {
	int movesRemaining;
	
	/**
	 * Create a new EliminationLevel based off the given state
	 * Sets the number of moves remaining to the move limit of the state
	 * in addition to creating the board, etc
	 * @param state
	 */
	public EliminationLevel(LevelState state) {
		super(state);
		this.movesRemaining = state.getMoveLimit();
	}
	
	/**
	 * A level is finished if all tiles have been marked
	 * it is also finished when the User has run out of moves
	 */
	@Override
	public boolean isFinished() {
		return allTilesMarked() || movesRemaining <= 0;
	}
	
	/**
	 * A user only passes a level if all tiles are marked and they 
	 * have earned at least one star
	 */
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
	
	/**
	 * UserMoves and RearrangeMoves use up one move
	 * If the move is a valid UserMove, it also markes all tiles in that move
	 */
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

	/**
	 * Level type is "Elimination"
	 */
	@Override
	public String typeString() {
		return "Elimination";
	}
	
	/**
	 * Get the number of moves remaining
	 * @return	the number of moves remaining
	 */
	public int getMovesRemaining() {
		return movesRemaining;
	}
	
	/**
	 * restart the level by setting score to 0,
	 * restore all used moves and specials
	 */
	public void restart() {
		super.restart();
		this.movesRemaining = state.getMoveLimit();
	}
	

}
