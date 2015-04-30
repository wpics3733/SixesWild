package model;

import java.util.ArrayList;

public class RearrangeMove implements IMove {

	@Override
	public boolean addTile(TileContainer tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pushMove(Level l) {
		l.subtractMove();
		Board b = l.getBoard();
		TileContainer[][] tiles = b.getTileContainers();
		for(int i = 0; i < b.getW(); i++) {
			for(int j = 0; j < b.getH(); j++) {
				if(tiles[i][j].getTile().getNum() != 6) {
					tiles[i][j].setTile(b.getRandomTile());
				}
			}
		}
		l.useSpecial(Level.REARRANGE);
	}

	@Override
	public boolean isValid() {
		return true;
	}
	
	public ArrayList<TileContainer> getTiles() {
		return null;
	}

}
