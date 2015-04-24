package entityPackage;

public class LevelModel {
	Tile board[];
	String mode;
	int starMilestones[]; // size 3
	int movesAllowed;
	int specialMovesAllowed[]; // size 3
	int timeAllowed; // size 0..1
	int multiplierProbabilities[]; // size 3
	int tileProbabilities[]; // size 6
	String levelName;
	int levelNumber;
	ITileModifier selectedModifier;
	
	// constructor
	public LevelModel() {
		//TODO
		
	}
	
	public void saveLevel() {
		//TODO
	}

}
