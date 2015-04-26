package model;

public class SwapMove implements IMove {
	TileContainer tc_1, tc_2;

	@Override
	public boolean addTile(TileContainer tc) {
		if(tc_1 == null) {
			tc_1 = tc;
		} else if (tc_2 == null) {
			tc_2 = tc;
		} else {
			throw new RuntimeException("Tried to add a tile to a full SwapMove");
		}
		// TODO Auto-generated method stub
		return false;
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
