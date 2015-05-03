package entityPackage;

/**
 * @author Dean Kiourtsis
 * Used to modify a tile's multiplier
 */
public class MultiplierModifier implements ITileModifier {
	
	int multiplier;
	
	public MultiplierModifier(int multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	public void modifyTile(Tile tile) {
		System.out.println("MultiplierModifier::Setting tile " + tile.getCoordinate() + " to multiplier " + multiplier + ".");
		tile.setMultiplier(multiplier);
	}

}
