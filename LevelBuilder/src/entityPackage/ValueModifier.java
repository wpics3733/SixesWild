package entityPackage;

/**
 * Used to modify a tile's value
 * @author Dean Kiourtsis
 */
public class ValueModifier implements ITileModifier {
	int value;
	
	// constructor
	public ValueModifier(int value) {
		this.value = value;
	}

	@Override
	public void modifyTile(Tile tile) {
		tile.setValue(value);
	}

}
