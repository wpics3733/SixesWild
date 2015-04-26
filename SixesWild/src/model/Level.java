package model;

public class Level {
	int score;
	int tileRatios[];
	int specials[];
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
	
	public void finishMove() {
		this.score += activeMove.getScore();
	}
	
	public IMove getActiveMove() {
		return this.activeMove;
	}
	
	public void setActiveMove(IMove move) {
		this.activeMove = move;
	}
	
	public int getMovesRemaining() {
		return movesRemaining;
	}
	
	public void subtractMove() {
		this.movesRemaining--;
	}
	
	public void useSpecial(int type) {

	}

	public boolean hasSpecial(int type) {
		if( type < 0 || type > 2) {
			return false;
		}
		
		return specials[type] > 0;
		
	}
}
