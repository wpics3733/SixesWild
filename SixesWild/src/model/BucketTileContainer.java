package model;

public class BucketTileContainer extends AbstractTileContainer {
	boolean empty;

	public BucketTileContainer(int x, int y) {
		super(x, y);
		empty = true;
	}

	@Override
	public boolean empty() {
		return empty;
	}

	@Override
	public boolean isNull() {
		return !empty;
	}

	@Override
	public boolean addTile(Tile t) {
		if(t.getNum() == 6) {
			this.empty = false;
			return true;
		}
		return false;
	}

	@Override
	public Tile getTile() {
		return null;
	}

	@Override
	public boolean marked() {
		return false;
	}

}
