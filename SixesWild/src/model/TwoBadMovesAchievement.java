package model;

public class TwoBadMovesAchievement extends OnMoveAchievement {
	private int counter;
	
	public TwoBadMovesAchievement() {
		this.name = "Underachiever";
		this.description = "You tried to make two bad moves in a row!";
		this.unlocked = false;
		OnMoveAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(UserMove move) {
		if (!move.isValid()) { counter++; }
		else { counter = 0; }
		return counter == 2;
	}

}
