package model;


public abstract class Level {
	int score;
	int tileRatios[];
	int specials[];
	int milestones[];
	Board b;
	IMove activeMove;
	int movesRemaining;
	boolean finished;
	
	public static final int REARRANGE = 0;
	public static final int SWAP = 1;
	public static final int CLEAR = 2;
	
	public Level() {
		this(9,9);
	}
	
	public Level(int w, int h) {
		this(new Board(w, h));
	}
	
	/**
	 * Construct a Level based on a given board, this should be depracated in the future
	 * in favor of Level(LevelState)
	 * @param b
	 */
	public Level(Board b) {
		this.b = b;
		this.activeMove = null;
		this.movesRemaining = 10;
		this.specials = new int[3];
		this.specials[REARRANGE] = 5;
		this.specials[SWAP] = 5;
		this.specials[CLEAR] = 5;
		this.milestones = new int[3];
		milestones[0] = 100;
		milestones[1] = 200;
		milestones[2] = 300;
	}
	
	public Level(LevelState l){
		this.b = new Board(l);
		this.movesRemaining = l.getMoveLimit();
		this.specials = l.getSpecialMoves();
		this.milestones = l.getStarScores();
		this.tileRatios = l.getTileProbabilities();
		this.finished = false;
	}
	
	public Board getBoard() {
		return b;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getMovesRemaining() {
		return movesRemaining;
	}
	
	public void subtractMove() {
		this.movesRemaining--;
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

	public boolean hasSpecial(int type) {
		if( type < 0 || type > 2) {
			return false;
		}
		return specials[type] > 0;
	}
	
	public int getNumSpecial(int type) {
		if(!hasSpecial(type)) {
			return 0;
		}
	return specials[type];
	}
	
	public int[] getMilestones() {
		return this.milestones;
	}
	
		
	// This is where we put level specific reactions to moves
	// For example, an elimination move marks all of the tiles used
	public void react(IMove move) {
	}

	public abstract boolean isFinished();
	public abstract boolean hasPassed();
	public abstract String typeString();
}
