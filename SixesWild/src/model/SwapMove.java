package model;

import java.util.ArrayList;

/**
 * A swap move swaps two adjacent tiles on the board
 * Only non-empty, non-null tiles can be swapped
 * Once two tiles are added, the move is valid and should be run
 * @author jesse
 *
 */
public class SwapMove implements IMove {
	AbstractTileContainer tc_1, tc_2;

	/**
	 * Add a TileContainer to the move
	 * null and empty TileContainers cannot be added
	 * once two tiles have been added, the move will throw an exception when another is added
	 * The second tile can only be successfully added if it is adjacent to the first
	 */
	@Override
	public boolean addTile(AbstractTileContainer tc) {
		if(tc.isNull() || tc.empty()) {
			return false;
		}
		if(tc_1 == null) {
			tc_1 = tc;
			tc_1.setUsed(true);
			return true;
		}

		if (tc_2 == null) {
			if(tc_1.isAdjacentTo(tc)) {
				tc_2 = tc;
				tc_2.setUsed(true);
				return true;
			}
			return false;
		}
		throw new RuntimeException("Tried to add a tile to a full SwapMove");
	}

	/**
	 * Push the SwapMove to the level.
	 * Swaps the contents of the two TileContainers
	 */
	@Override
	public void pushMove(Level l) {
		Tile swap_1 = tc_1.getTile();
		Tile swap_2 = tc_2.getTile();
		tc_1.clearTile();
		tc_2.clearTile();
		tc_1.addTile(swap_2);
		tc_2.addTile(swap_1);
		l.useSpecial(Level.SWAP);
		tc_1.setUsed(false);
		tc_2.setUsed(false);
		l.react(this);
	}

	/**
	 * A SwapMove is only valid if it contains two TileContainers
	 */
	@Override
	public boolean isValid() {
		if(tc_1 != null && tc_2 != null) {
			return true;
		}
		return false;
	}

	/**
	 * gets all tiles in the move.
	 * Returns an ArrayList of size 0, 1, or 2
	 * Each element is a TileContainer in the move
	 */
	@Override
	public ArrayList<AbstractTileContainer> getTiles() {
		ArrayList<AbstractTileContainer> toRet = new ArrayList<AbstractTileContainer>();
		if(tc_1 != null) {
			toRet.add(tc_1);
		}
		if(tc_2 != null) {
			toRet.add(tc_2);
		}
		return toRet;
	}

}
