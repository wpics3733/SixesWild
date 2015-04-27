package model;

public class Level {
	int score;
	int tileRatios[];
	int specials[];
	int milestones[];
	Board b;
	IMove activeMove;
	int movesRemaining;
	
	public static final int REARRANGE = 0;
	public static final int SWAP = 1;
	public static final int CLEAR = 2;
	
	public Level() {
		this(9,9);
	}
	
	public Level(int h, int w) {
		this(new Board(w, h));
	}
	
	public Level(Board b) {
		this.b = b;
		this.activeMove = null;
		this.movesRemaining = 99;
		this.specials = new int[3];
		this.specials[REARRANGE] = 5;
		this.specials[SWAP] = 5;
		this.specials[CLEAR] = 5;
		this.milestones = new int[3];
		milestones[0] = 100;
		milestones[1] = 200;
		milestones[2] = 300;
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
}
