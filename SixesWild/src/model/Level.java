package model;

public class Level {
	int score;
	Board b;
	
	public Level() {
		this.b = new Board(9,9);
	}
	
	public Level(Board b) {
		this.b = b;
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

}
