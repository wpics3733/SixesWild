package entityPackage;

public class LevelModel {
	Tile board[][];
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
	
	public LevelModel(LevelState l) {
		this.mode = l.getLevelType();
		this.movesAllowed = l.getMoveLimit();
		this.specialMovesAllowed = l.getSpecialMoves();
		this.timeAllowed = l.getTimeLimit();
		this.multiplierProbabilities = l.getMultiplierProbabilities();
		this.tileProbabilities = l.getTileProbabilities();
		this.levelName = l.getLevelName();
		
		this.board = new Tile[9][9];
		for(int col = 0; col < 9; col++){
			for(int row = 0; row < 9; row++){
				this.board[col][row] = new Tile(l.getMarks()[col][row], l.getBoardVals()[col][row], l.getMultipliers()[col][row], l.getBlockedTiles()[col][row]);
			}
		}
	}
	
	public void saveLevel() {
		int boardNumbers[][] = new int[9][9];
		int boardMarks[][] = new int[9][9];
		int multipliers[][] = new int[9][9];
		boolean blockedTiles[][] = new boolean[9][9];
		for(int col = 0; col < 9; col++){
			for(int row = 0; row < 9; row++){
				boardNumbers[col][row] = board[col][row].value;
				boardMarks[col][row] = board[col][row].mark;
				multipliers[col][row] = board[col][row].multiplier;
				blockedTiles[col][row] = board[col][row].isBlocked;
			}
		}
		LevelState l = new LevelState(levelName, boardNumbers, boardMarks, multipliers, blockedTiles, 9, 9, mode, starMilestones, specialMovesAllowed, timeAllowed, movesAllowed, multiplierProbabilities, tileProbabilities, true, 0);
		l.saveState();
	}

}
