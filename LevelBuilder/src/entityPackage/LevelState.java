package entityPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Contains all level information.
 * 
 * This is the class that is shared between the game and the level builder.
 * It allows us to save the Object as a file, and then load it into either the game or the level builder.
 * 
 * @author Dean Kiourtsis
 * 
 */
public class LevelState {
	/** The name of a level. */
	protected String levelName;
	
	/** The board tile's values. */
	protected int boardVals[][];
	
	/** Indicates whether the tiles are marked. */
	protected int marks[][];
	
	/** Multiplier values for each of the tiles. */
	protected int multipliers[][];
	
	/** Indicates which of the tiles are blocked. */
	protected boolean blockedTiles[][];
	
	/** The number of tiles along the width of the board. */
	protected int width;
	
	/** The number of tiles along the height of the board. */
	protected int height;
	
	/** The type of level (e.g. Puzzle, Lightning, etc.). */	
	protected String levelType;
	
	/** The star milestones. */
	protected int starScores[];
	
	/** The number of special moves allowed. */
	protected int specialMoves[];
	
	/** The maximum time limit allowed. */
	protected int timeLimit;
	
	/** The maximum number of moves allowed. */
	protected int moveLimit;
	
	/** The multiplier probabilities for the tiles. */
	protected int multiplierProbabilities[];
	
	/** The probabilities for the tile numbers. */
	protected int tileProbabilities[];
	
	/** Indicates whether a level is unlocked. */
	protected boolean isUnlocked;
	
	/** The highest score attained for a level. */
	protected int highScore;
	
	/**
	 * Creates a LevelState object with the given parameters
	 * @param levelName the name of a level.
	 * @param boardVals the tile values.
	 * @param marks indicates whether the tile is marked.
	 * @param multipliers the multiplier probabilities.
	 * @param blockedTiles indicates whether a tile is blocked.
	 * @param width the width of the board, in terms of number of tiles.
	 * @param height the height of the board, in terms of the number of tiles.
	 * @param levelType the level type (e.g. Puzzle, Lightning, etc.).
	 * @param starScores the star milestone scores.
	 * @param specialMoves the number of special moves allowed.
	 * @param timeLimit the time limit permitted.
	 * @param moveLimit the number of moves allowed.
	 * @param multiplierProbabilities the probabilities for the multipliers.
	 * @param tileProbabilities the probabilities for the tile numbers.
	 * @param isUnlocked indicates whether the level is unlocked.
	 * @param highScore the highest score attained for a level.
	 */
	public LevelState(String levelName, int[][] boardVals, int[][] marks,
			int[][] multipliers, boolean[][] blockedTiles, int width,
			int height, String levelType, int[] starScores, int[] specialMoves,
			int timeLimit, int moveLimit, int[] multiplierProbabilities,
			int[] tileProbabilities, boolean isUnlocked, int highScore) {
		this.levelName = levelName;
		this.boardVals = boardVals;
		this.marks = marks;
		this.multipliers = multipliers;
		this.blockedTiles = blockedTiles;
		this.width = width;
		this.height = height;
		this.levelType = levelType;
		this.starScores = starScores;
		this.specialMoves = specialMoves;
		this.timeLimit = timeLimit;
		this.moveLimit = moveLimit;
		this.multiplierProbabilities = multiplierProbabilities;
		this.tileProbabilities = tileProbabilities;
		this.isUnlocked = isUnlocked;
		this.highScore = highScore;
	}

	/**
	 * Creates a default LevelState object
	 */
	public LevelState() {
		levelName = "defaultLevel";
		
		width = 9;
		height = 9;
		boardVals = new int[width][height];
		marks = new int[width][height];
		multipliers = new int[width][height];
		blockedTiles = new boolean[width][height];
		
		levelType = "Puzzle";
		starScores = new int[3];
		specialMoves = new int[3];
		timeLimit = 0;
		moveLimit = 100;
		
		multiplierProbabilities = new int[3];
		tileProbabilities = new int[6];
		
		isUnlocked = false;
		highScore = 0;
	}
	
	/**
	 * Creates a LevelState using the name of an existing LevelState save file
	 * @param fileName the name of the file which is to be loaded by the LevelState
	 */
	public LevelState(String fileName) {
		this.loadState(fileName);
	}

	/**
	 * Returns the name of the level
	 * @return String 
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * Sets the name of the level
	 * @param levelName
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 * Returns the level type
	 * @return String
	 */
	public String getLevelType() {
		return levelType;
	}

	/**
	 * Sets the level type
	 * @param levelType
	 */
	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	/**
	 * Returns the milestones for star scores
	 * @return int[]
	 */
	public int[] getStarScores() {
		return starScores;
	}

	/**
	 * Sets the milestones for the star scores
	 * @param starScores
	 */
	public void setStarScores(int[] starScores) {
		this.starScores = starScores;
	}

	/**
	 * Returns the number of each special move
	 * @return int[]
	 */
	public int[] getSpecialMoves() {
		return specialMoves;
	}

	/**
	 * Sets the number of special moves
	 * @param specialMoves
	 */
	public void setSpecialMoves(int[] specialMoves) {
		this.specialMoves = specialMoves;
	}

	/**
	 * Returns the level time limit
	 * @return int
	 */
	public int getTimeLimit() {
		return timeLimit;
	}

	/**
	 * Sets the level time limit.
	 * @param timeLimit
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	/**
	 * Returns the level move limit
	 * @return int
	 */
	public int getMoveLimit() {
		return moveLimit;
	}

	/**
	 * Sets the level move limit
	 * @param moveLimit
	 */
	public void setMoveLimit(int moveLimit) {
		this.moveLimit = moveLimit;
	}

	/**
	 * Returns the multiplier probablilities
	 * @return int[]
	 */
	public int[] getMultiplierProbabilities() {
		return multiplierProbabilities;
	}

	/**
	 * Sets the multiplier probabilities
	 * @param multiplierProbabilities
	 */
	public void setMultiplierProbabilities(int[] multiplierProbabilities) {
		this.multiplierProbabilities = multiplierProbabilities;
	}

	/**
	 * Returns the tile probabilities
	 * @return int[]
	 */
	public int[] getTileProbabilities() {
		return tileProbabilities;
	}

	/**
	 * Sets the tile probabilities
	 * @param tileProbabilities
	 */
	public void setTileProbabilities(int[] tileProbabilities) {
		this.tileProbabilities = tileProbabilities;
	}

	/**
	 * Returns the board values
	 * @return int[][]
	 */
	public int[][] getBoardVals() {
		return boardVals;
	}

	/**
	 * Sets the board values
	 * @param boardVals
	 */
	public void setBoardVals(int[][] boardVals) {
		this.boardVals = boardVals;
	}

	/**
	 * Returns the marks on the board
	 * @return int[][]
	 */
	public int[][] getMarks() {
		return marks;
	}

	/**
	 * Sets the marks on the board
	 * @param marks
	 */
	public void setMarks(int[][] marks) {
		this.marks = marks;
	}

	/**
	 * Returns the multipliers on the board
	 * @return int[][]
	 */
	public int[][] getMultipliers() {
		return multipliers;
	}

	/**
	 * Sets the multipliers on the board
	 * @param multipliers
	 */
	public void setMultipliers(int[][] multipliers) {
		this.multipliers = multipliers;
	}

	/**
	 * Returns the blocked board tiles
	 * @return boolean[][]
	 */
	public boolean[][] getBlockedTiles() {
		return blockedTiles;
	}

	/**
	 * Sets the blocked board tiles.
	 * @param blockedTiles
	 */
	public void setBlockedTiles(boolean[][] blockedTiles) {
		this.blockedTiles = blockedTiles;
	}

	/**
	 * Returns the board width
	 * @return int
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the board width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the height of the board
	 * @return int
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of the board
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Returns the level's unlocked status
	 * @return boolean
	 */
	public boolean isUnlocked() {
		return isUnlocked;
	}

	/**
	 * Sets the level's unlocked status
	 * @param unlocked
	 */
	public void setUnlocked(boolean unlocked) {
		this.isUnlocked = unlocked;
	}

	/**
	 * Returns the level's highscore
	 * @return int
	 */
	public int getHighScore() {
		return highScore;
	}

	/**
	 * Sets the level's highscore
	 * @param highScore
	 */
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	
	/**
	 * Saves the level to the level directory with the name [levelname].sav
	 * 
	 * @author Dean
	 */
	public void saveState(){
		File f;
		FileOutputStream saveFile;
		ObjectOutputStream save;
		try{// Catch errors in I/O if necessary.
			
			// Open a file to write to
			f = new File("Levels/" + levelName.concat(".sav"));
			if(!f.exists()){
				f.createNewFile();
			}
			
			saveFile=new FileOutputStream(f);
			
			// Create an ObjectOutputStream to put objects into save file.
			save = new ObjectOutputStream(saveFile);
			
			// Now we do the save.
			
			save.writeObject(this.levelName);
			save.writeObject(this.boardVals);
			save.writeObject(this.marks);
			save.writeObject(this.multipliers);
			save.writeObject(this.blockedTiles);
			save.writeObject(this.width);
			save.writeObject(this.height);
			save.writeObject(this.levelType);
			save.writeObject(this.starScores);
			save.writeObject(this.specialMoves);
			save.writeObject(this.timeLimit);
			save.writeObject(this.moveLimit);
			save.writeObject(this.multiplierProbabilities);
			save.writeObject(this.tileProbabilities);
			save.writeObject(this.isUnlocked);
			save.writeObject(this.highScore);
			
			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	/**
	 * Loads a LevelState object from [fileName].sav in the levels directory
	 * @param fileName the name of the file in which to load a level state
	 * 
	 * @author Dean
	 */
	public void loadState(String fileName){
		File f;
		FileInputStream saveFile;
		ObjectInputStream save;
		try{
			
			f = new File("Levels/" + fileName);
			
			
			// Open file to read from
			saveFile = new FileInputStream(f);
			
			// Create an ObjectInputStream to get objects from save file.
			save = new ObjectInputStream(saveFile);

			// Now we do the restore.
			
			this.levelName = (String) save.readObject();
			this.boardVals = (int[][]) save.readObject();
			this.marks = (int[][]) save.readObject();
			this.multipliers = (int[][]) save.readObject();
			this.blockedTiles = (boolean[][]) save.readObject();
			this.width = (int) save.readObject();
			this.height = (int) save.readObject();
			this.levelType = (String) save.readObject();
			this.starScores = (int[]) save.readObject();
			this.specialMoves = (int[]) save.readObject();
			this.timeLimit = (int) save.readObject();
			this.moveLimit = (int) save.readObject();
			this.multiplierProbabilities = (int[]) save.readObject();
			this.tileProbabilities = (int[]) save.readObject();
			this.isUnlocked = (boolean) save.readObject();
			System.out.println(isUnlocked+ " " + levelName);
			this.highScore = (int) save.readObject();

			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc){
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}
}
