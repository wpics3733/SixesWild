package model;

/**
 * An achievement for Making three invalid moves in a row
 * @author justin
 *
 */
public class UnderachieverMoveAchievement extends OnMoveAchievement {
	private int counter;
	
	public UnderachieverMoveAchievement() {
		this.name = "Underachiever";
		this.description = "You tried to make three bad moves in a row!";
		this.unlocked = false;
		OnMoveAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(UserMove move) {
		if (!move.isValid()) { counter++; }
		else { counter = 0; }
		return counter == 3;
	}

}
