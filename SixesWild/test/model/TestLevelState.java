package model;
import java.io.FileNotFoundException;

import junit.framework.TestCase;


public class TestLevelState extends TestCase {
	
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
		assertEquals(l.getLevelName(), "testLevel");
		l.setLevelName("testName");
		assertEquals(l.getLevelName(), "testName");
		assertEquals(l.getStarScores()[0], 100);
		assertEquals(l.getSpecialMoves()[0], 10);
		l.setTimeLimit(100);
		assertEquals(l.getTimeLimit(), 100);
		l.setMoveLimit(50);
		assertEquals(l.getMoveLimit(), 50);
		l.saveState();
		assertTrue(l.getLevelType().equals("Elimination"));
		//System.out.println(l.isUnlocked());
		l.loadState("testLevel.sav");
		l.deleteState();
	}
}
