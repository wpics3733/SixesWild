package model;

/**
 * An achievement for trying to make a move with four or more sixes
 * @author justin
 *
 */
public class OverpopulatedMoveAchievement extends OnMoveAchievement {
	
	public OverpopulatedMoveAchievement() {
		this.name = "Overpopulated";
		this.description= "Try to make a move with 4 or more sixes";
		this.unlocked = false;
		OnMoveAchievement.addToSet(this);
	}

	@Override
	public boolean unlocked(UserMove move) {
		if (move.numTiles >= 4) {
			int counter = 0;
			for (AbstractTileContainer t : move.getTiles()) {
				if (t instanceof NumberTileContainer) {
					if (t.getTile() != null && t.getTile().getNum() != 6) {
						return false;
					} else { counter++; }
				}
			}
			return counter >= 4;
		}
		return false;
	}

}
