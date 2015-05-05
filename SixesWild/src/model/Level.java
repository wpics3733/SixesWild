package model;


/**
 * A class to hold anything that all Levels have in common
 * This includes:
 * The Game board values
 * Score milestones (1/2/3 stars)
 * Number of special moves
 * 
 * As well as some common behavior associated with these attributes
 * 
 * @author jesse
 *
 */
public abstract class Level {
	int score;
	int specials[];
	int milestones[];
	Board b;
	LevelState state;
	boolean finished;
	
	public static final int REARRANGE = 0;
	public static final int SWAP = 1;
	public static final int CLEAR = 2;
	
	
	/**
	 * Construct a new level
	 * @param l		The levelState data that this level should use
	 */
	public Level(LevelState l){
		this.b = new Board(l);
		this.state = l;
		this.milestones = state.getStarScores();
		this.restart();
	}
	
	/**
	 * Returns the board this level is using
	 * @return	The board this level is using
	 */
	public Board getBoard() {
		return b;
	}
	
	/**
	 * the current score
	 * @return	the current score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * set the current score. Most often used like
	 * setScore(getScore() + something);
	 * @param score		The new score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * By using a special move, the number of that special that you are allowed to used
	 * is decremented, call this method after applying a special move to do that decrement
	 * 
	 * @param type the type of special used, either Level.SWAP, Level.REARRANGE, or Level.CLEAR
	 */
	public void useSpecial(int type) {
		if(hasSpecial(type)) specials[type]--;
	}

	/**
	 * checks if the user has any specials of the given type remaining
	 * The type should be either Level.SWAP, Level.REARRANGE, or Level.CLEAR
	 * @param type	The special type
	 * @return		whether or not the user has any remaining
	 */
	public boolean hasSpecial(int type) {
		if( type < 0 || type > 2) {
			return false;
		}
		return specials[type] > 0;
	}
	
	/**
	 * gets the number of specials of the given type remaining
	 * used by the gui to tell the user how many of each move type remain
	 * @param type	the special type, Level.SWAP, etc
	 * @return	the number remaining
	 */
	public int getNumSpecial(int type) {
		if(!hasSpecial(type)) {
			return 0;
		}
		return specials[type];
	}
	
	/**
	 * The scores at which 1/2/3 stars are earned
	 * @return	an int array, [0] is the milestone for the fist star
	 */
	public int[] getMilestones() {
		return this.milestones;
	}
	
		
	/**
	 * After every move, the board settles the tiles.
	 * Depending on the Level type, it may override this in order
	 * to take care of level specific things
	 * @param move	The move just applied to the board
	 */
	public void react(IMove move) {
		getBoard().settleTiles();
	}
	
	/**
	 * Gets the LevelState that this level is using
	 * @return	The levelState
	 */
	public LevelState getLevelState() {
		return state;
	}
	
	/**
	 * Restarts the level.
	 * Sets the score to 0
	 * Swaps out the board for a new one
	 * resets the number of all special moves
	 * Note: this will not affect the gui until lv.restart() is called
	 */
	public void restart() {
		this.score = 0;
		this.b = new Board(state);
		this.specials = state.getSpecialMoves();
		this.finished = false;
		this.score = 0;
	}
	
	/**
	 * Given a score, returns an int 0..3 representing the number
	 * of stars that score will earn the player on this level
	 * @param score		the score
	 * @return			The number of stars that score earns
	 */
	public int starsEarned(int score) {
		int[] milestones = state.getStarScores();
		if(score < milestones[0]) {
			return 0;
		} else if (score < milestones[1]) {
			return 1;
		} else if (score < milestones[2]) {
			return 2;
		} else {
			return 3;
		}
		
	}

	public abstract boolean isFinished();
	public abstract boolean hasPassed();
	public abstract String typeString();
}
