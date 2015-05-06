package model;

/**
 * An achievement for making 3 moves in a row that contain a multiplier
 * @author justin
 *
 */
public class MultiplierMultiplierMoveAchievement extends OnMoveAchievement {
	private int counter;
	
	public MultiplierMultiplierMoveAchievement() {
		this.name = "Multiplier Multiplier!";
		this.description = "Make three moves in a row that have a multiplier"
				+ '\n' + "I dare you to say this achievement 10 times fast";
		this.unlocked = false;
		OnMoveAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(UserMove move) {
		if (move.isValid() && move.multiplier > 1) { counter++; }
		else { counter = 0; }
		return counter == 3;
	}

}
