package model;

import java.util.ArrayList;

public class SwapMove implements IMove {
	TileContainer tc_1, tc_2;

	@Override
	public boolean addTile(TileContainer tc) {
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

	@Override
	public void pushMove(Level l) {
		Tile swap = tc_1.getTile();
		tc_1.setTile(tc_2.getTile());
		tc_2.setTile(swap);
		l.useSpecial(Level.SWAP);
		tc_1.setUsed(false);
		tc_2.setUsed(false);
		l.react(this);
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid() {
		if(tc_1 != null && tc_2 != null) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<TileContainer> getTiles() {
		ArrayList<TileContainer> toRet = new ArrayList<TileContainer>();
		toRet.add(tc_1);
		toRet.add(tc_2);
		return toRet;
	}

}
