package model;

import java.util.ArrayList;

/**
 * A ClearMove operates on a single NumberTileContainer
 * Clearing the tile removes the number, and then the board should settle.
 * 
 * Clearmoves are used to clear away pesky sixes, but can make Release Levels unwinnable
 * They cannot be used on Buckets or Null tiles
 * @author jesse
 *
 */
public class ClearMove implements IMove {
	AbstractTileContainer tile;

	/**
	 * Add a tile to the ClearMove
	 * if the tile was good, the move should now be valid
	 * 
	 * Null tiles cannot be cleared, neither can empty tileContainers
	 */
	@Override
	public boolean addTile(AbstractTileContainer tc) {
		if(tc.empty() || tc.isNull()) {
			return false;
		}
		if(tile == null) {
			this.tile = tc;
			return true;
		}
		return false;
	}

	/**
	 * Update the level to reflect the changes this move creates
	 * the Tile is cleared, the board settles, and one Clear special is taken away
	 */
	@Override
	public void pushMove(Level l) {
		tile.clearTile();
		l.useSpecial(Level.CLEAR);
		l.react(this);
		
	}

	/**
	 * A clearmove is valid iff only one tile has been added
	 */
	@Override
	public boolean isValid() {
		if(this.tile == null) {
			return false;
		}
		return true;
	}

	/**
	 * Returns an ArrayList of tiles in the move.
	 * Either size 0 or 1
	 */
	@Override
	public ArrayList<AbstractTileContainer> getTiles() {
		ArrayList<AbstractTileContainer> toRet = new ArrayList<AbstractTileContainer>();
		if(tile != null) {
			toRet.add(tile);
		}
		return toRet;
	}

}
