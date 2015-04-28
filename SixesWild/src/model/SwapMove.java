package model;

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
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void pushMove(Level l) {
		Tile swap = tc_1.getTile();
		tc_1.setTile(tc_2.getTile());
		tc_2.setTile(swap);
		l.useSpecial(Level.SWAP);
		tc_1.setUsed(false);
		tc_2.setUsed(false);
		tc_1 = null;
		tc_2 = null;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
