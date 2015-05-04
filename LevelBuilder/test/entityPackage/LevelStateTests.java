package entityPackage;
import junit.framework.TestCase;


public class LevelStateTests extends TestCase {
	
	public void testSimple(){
		LevelState l = new LevelState();
		LevelState m = new LevelState();
		
		l.setLevelType("Puzzle");
		assertTrue(l.getLevelType().equals("Puzzle"));
		
		l.saveState();
		
		
		m.loadState(l.levelName.concat(".sav"));
		assertTrue(m.getLevelType().equals("Puzzle"));
	}
	
	public void testLevel(){
		
		int[][] a = new int[9][9];
		boolean[][] b = new boolean[9][9];
		for(int col = 0; col < 9; col++){
			for(int row = 0; row < 9; row++){
				a[row][col] = 1;
				b[col][row] = false;
			}
		}
		int[] milestones = new int[3];
		int[] specMoves = new int[3];
		int[] multProb = new int[3];
		int[] tileProb = new int[6];
		milestones[0] = 100; milestones[1] = 200; milestones[2] = 300;
		specMoves[0] = 10; specMoves[1] = 10; specMoves[2] = 10;
		multProb[0] = 1; multProb[1] = 0; multProb[2] = 0;
		tileProb[0] = 1; tileProb[1] = 0; tileProb[2] = 0; tileProb[0] = 0; tileProb[1] = 0; tileProb[2] = 0;
		
		LevelState l = new LevelState("testLevel", a, a, a, b, 9, 9, "Elimination", milestones, specMoves, 0, 100, multProb, tileProb, true, 0);
		l.saveState();
		l.setBlockedTiles(b);
		l.setBoardVals(a);
		l.setMultipliers(a);
		l.setMarks(a);
		l.setMultiplierProbabilities(multProb);
		l.setStarScores(milestones);
		l.setSpecialMoves(specMoves);
		l.setTileProbabilities(tileProb);
		l.setLevelName("testLevel");
		l.setLevelType("Elimination");
		l.setTimeLimit(0);
		l.setMoveLimit(100);
		l.setUnlocked(true);
		l.setHighScore(0);
		
		
		l.getBoardVals();
		l.getMultipliers();
		l.getMarks();
		l.getMultiplierProbabilities();
		l.getTileProbabilities();
		l.getStarScores();
		l.getLevelName();
		l.getLevelType();
		l.getTimeLimit();
		l.getMoveLimit();
		l.isUnlocked();
		l.getHighScore();
		
		
		assertTrue(l.getLevelType().equals("Elimination"));
		//System.out.println(l.isUnlocked());
		l.loadState("testLevel.sav");
		//System.out.println(l.isUnlocked());
	}
}
