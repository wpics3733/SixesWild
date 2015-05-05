package entityPackage;

/**
 * Used to modify a tile's multiplier
 * @author Dean Kiourtsis
 */
public class MultiplierModifier implements ITileModifier {
	/** The multiplier value which a tile is to be set to. */
	int multiplier;
	
	/** 
	 * Constructor for a multiplier modified.
	 * @param multiplier the multiplier value which a tile is to be set to.
	 * 
	 * @author Dean
	 */
	public MultiplierModifier(int multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	/**
	 * Sets the specified tile's multiplier.
	 * @param Tile the tile for which the multiplier is to be changed.
	 * 
	 * @author Dean
	 */
	public void modifyTile(Tile tile) {
		System.out.println("MultiplierModifier::Setting tile " + tile.getCoordinate() + " to multiplier " + multiplier + ".");
		tile.setMultiplier(multiplier);
	}

}
