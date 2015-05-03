package model;

/**
 * Buckets are only used in th "Release" level type.
 * They start out empty and can only be filled by
 * a 6 settling in. Once they are full, they act just like
 * null tiles
 * @author jesse
 *
 */
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
