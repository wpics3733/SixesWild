package entityPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Contains all level information
 * @author Dean Kiourtsis
 * 
 */
public class LevelState {
	protected String levelName;
	
	protected int boardVals[][];
	protected int marks[][];
	protected int multipliers[][];
	protected boolean blockedTiles[][];
	protected int width;
	protected int height;
	
	protected String levelType;
	protected int starScores[];
	protected int specialMoves[];
	protected int timeLimit;
	protected int moveLimit;
	
	protected int multiplierProbabilities[];
	protected int tileProbabilities[];
	
	protected boolean isUnlocked;
	protected int highScore;
	
	/**
	 * Creates a LevelState object with the given parameters
	 * @param levelName
	 * @param boardVals
	 * @param marks
	 * @param multipliers
	 * @param blockedTiles
	 * @param width
	 * @param height
	 * @param levelType
	 * @param starScores
	 * @param specialMoves
	 * @param timeLimit
	 * @param moveLimit
	 * @param multiplierProbabilities
	 * @param tileProbabilities
	 * @param isUnlocked
	 * @param highScore
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
	 * @param fileName
	 */
	public LevelState(String fileName) {
		this.loadState(fileName);
	}

	/**
	 * Returns the name of the level
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @param fileName
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
