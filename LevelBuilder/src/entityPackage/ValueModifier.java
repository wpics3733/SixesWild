package entityPackage;

/**
 * Used to modify a tile's value
 * @author Dean Kiourtsis
 */
public class ValueModifier implements ITileModifier {
	/** The value for which a tile should be set to. */
	int value;
	
	/**
	 * The constructor for a value modifer.
	 * @param value the value for which a tile should be set to.
	 * 
	 * @author Dean
	 */
	public ValueModifier(int value) {
		this.value = value;
	}

	@Override
	/**
	 * Sets the value of a tile.
	 * 
	 * @param tile the tile for which the value should be changed.
	 * 
	 * @author Dean
	 */
	public void modifyTile(Tile tile) {
		tile.setValue(value);
	}

}
