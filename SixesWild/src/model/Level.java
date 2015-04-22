package model;

import model.UserMove;

public class Level {
	int score;
	Board b;
	IMove activeMove;
	int movesRemaining;
	
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
}
