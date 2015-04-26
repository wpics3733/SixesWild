package model;

public class RearrangeMove implements IMove {

	@Override
	public boolean addTile(TileContainer tc) {
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
		Board b = l.getBoard();
		TileContainer[][] tiles = b.getTiles();
		for(int i = 0; i < b.getW(); i++) {
			for(int j = 0; j < b.getH(); j++) {
				tiles[i][j].setTile(b.getRandomTile());
			}
		}
		l.useSpecial(Level.REARRANGE);
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
