package model;

/**
 * A secret achievement for obtaining the highest score possible in the game
 * @author justin
 *
 */
public class OverachieverMoveAchievement extends OnMoveAchievement {
	
	public OverachieverMoveAchievement() {
		this.unlocked = false;
		this.name = "Overachiever!";
		this.secret = true;
		this.description = "You must have really tried for this one.";
		OnMoveAchievement.addToSet(this);
	}
	
	@Override
	public boolean unlocked(UserMove move) {
		return move.getScore() >= 43000;
	}

}
