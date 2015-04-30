package entityPackage;

public class ValueModifier implements ITileModifier {
	int value;
	
	// constructor
	public ValueModifier(int value) {
		// TODO
		this.value = value;
	}

	@Override
	public void modifyTile(Tile tile) {
		// TODO Auto-generated method stub
		tile.setValue(value);
	}

}
