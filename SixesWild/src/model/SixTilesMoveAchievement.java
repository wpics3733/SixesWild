package model;

/**
 * An achievement for making a move that contains 6 tiles
 * @author justin
 *
 */
public class SixTilesMoveAchievement extends OnMoveAchievement {
	
	public SixTilesMoveAchievement() {
		this.unlocked = false;
		this.name = "Six Tiles";
		this.description = "Use 6 tiles in one move";
		OnMoveAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(UserMove move) {
		int num = move.getTiles().size();
		return num == 2;
	}

}
