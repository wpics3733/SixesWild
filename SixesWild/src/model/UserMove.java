package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * UserMove is the basic move type for the SixesWild game
 * They are the only way to score points or mark tiles in Elimination rounds
 * 
 * A valid UserMove is 2 or more adjacent tiles that sum to 6
 * 
 * @author jesse
 *
 */
public class UserMove implements IMove {
	ArrayList<AbstractTileContainer> tiles;
	int sum;
	int multiplier;
	int numTiles;

	/**
	 * Construct a new empty UserMove
	 * the initial sum is 0
	 * the initial multiplier is 1, and is doubled for every x2 tile, tripled for every x3 tile
	 */
	public UserMove() {
		sum = 0;
		multiplier = 1;
		numTiles = 0;
		tiles = new ArrayList<AbstractTileContainer>();
	}

	/**
	 * Add a TileContainer to the UserMove
	 * TileContainers that have already been added to the UserMove cannot be added again
	 * a TileContainer that is not adjacent to at least one existing TileContainer cannot be added 
	 * 	(this prevents diagonal moves)
	 * null or empty tiles cannot be added
	 */
	@Override
	public boolean addTile(AbstractTileContainer tc) {
		if(tiles.contains(tc)) {
			return false;
		}
		if(tc.empty() || tc.isNull()) {
			return false;
		}
		if(tiles.isEmpty()) {
			addAcceptedTile(tc);
			return true;
		}

		for(AbstractTileContainer i: tiles) {
			if(i.isAdjacentTo(tc)) {
				addAcceptedTile(tc);
				return true;
			}
		}
		return false;
	}

	private void addAcceptedTile(AbstractTileContainer tc) {
		tc.setUsed(true);
		tiles.add(tc);
		sum += tc.getTile().getNum();
		multiplier *= tc.getTile().getMultiplier();
		numTiles++;

	}

	/**
	 * get the score of this UserMove
	 * The score for a valid UserMove is 10 * the number of tiles used * multipliers
	 * @return	the score
	 */
	public int getScore() {
		if(this.isValid()) {
			return 10 * numTiles * multiplier;
		} else {
			return 0;
		}		
	}


	/**
	 * A userMove is valid if the sum is 6 and there are two or more tiles
	 */
	@Override
	public boolean isValid() {
		return sum == 6 && numTiles > 1;
	}

	/**
	 * When a valid move is done, this method is called
	 * in order to push that move to the level
	 * This method updates the score appropriately
	 */
	@Override
	public void pushMove(Level l) {
		for(AbstractTileContainer tc: tiles) {
			tc.clearTile();
		}
		l.setScore(l.getScore() + this.getScore());
	}

	/**
	 * After any move, valid or invalid,
	 * this method should be called, to reset the markings
	 * on the tiles, and apply any logic that takes
	 * place after either a successful or failed move
	 * 
	 * After any move, all achievements will be checked
	 */
	public void finishMove() {
		for(AbstractTileContainer tc: tiles) {
			tc.setUsed(false);
		}
		
		// check to see if this move has unlocked any achievements
		OnMoveAchievement.checkAll(this);
	}

	/**
	 * returns all tiles in this UserMove
	 */
	@Override
	public ArrayList<AbstractTileContainer> getTiles() {
		return tiles;
	}
}
