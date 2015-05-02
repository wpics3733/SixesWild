package entityPackage;

public class MultiplierModifier implements ITileModifier {
	
	int multiplier;
	
	public MultiplierModifier(int multiplier) {
		// TODO
		this.multiplier = multiplier;
	}

	@Override
	public void modifyTile(Tile tile) {
		// TODO Auto-generated method stub
		System.out.println("MultiplierModifier::Setting tile " + tile.getCoordinate() + " to multiplier " + multiplier + ".");
		tile.setMultiplier(multiplier);
	}

}
