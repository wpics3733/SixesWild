package model;

/**
 * An achievement for making a move of at least 4 tiles that has all multipliers
 * @author Justin
 *
 */
public class MultiplierHeavenAchievement extends OnMoveAchievement {
	
	public MultiplierHeavenAchievement() {
		this.name = "Multiplier Heaven";
		this.description = "Make a move of at least 4 tiles that has all 3x multipliers";
		this.unlocked = false;
		OnMoveAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(UserMove move) {
		return move.numTiles >= 4 && move.multiplier == Math.pow(3, move.numTiles);
	}

}
