package sixesWild.model;

import sixesWild.model.UserMove;

public class Level {
	int score;
	Board b;
	IMove activeMove;
	
	public Level() {
		this(9,9);
	}
	
	public Level(int h, int w) {
		this(new Board(w, h));
	}
	
	public Level(Board b) {
		this.b = b;
		this.activeMove = null;
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
	
	public void addMoveTile(TileContainer tc) {
		if(this.activeMove == null) {
			activeMove = new UserMove();
			activeMove.addTile(tc);
		}
	}
	
	public void finishMove() {
		this.score += activeMove.getScore();
	}

}
