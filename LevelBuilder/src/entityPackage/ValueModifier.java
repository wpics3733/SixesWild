package entityPackage;

/**
 * @author Dean Kiourtsis
 * Used to modify a tile's value
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
