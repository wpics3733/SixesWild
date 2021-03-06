package entityPackage;

import junit.framework.TestCase;

public class LevelModelTests extends TestCase {
	
	public void setup(){
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
	}
	
	public void testMoves(){
		LevelState l = new LevelState();
		l.loadState("testLevel.sav");
		
		LevelModel model = new LevelModel(l);
		assertEquals(model.getTile(0, 0).getValue(), 1);
		assertEquals(model.getTile(0, 0).getMultiplier(), 1);
		model.setSelectedTile(0, 0);
		assertEquals(model.getSelectedTile(), model.getTile(0, 0));
		
		ModifyTileMove m = new ModifyTileMove(model, new ValueModifier(2));
		model.setCurrentMove(m);
		model.addMove(0, 0);
		assertEquals(model.getTile(0, 0).getValue(), 2);
		model.undoMove();
		assertEquals(model.getTile(0, 0).getValue(), 1);
		model.doMove();
		assertEquals(model.getTile(0, 0).getValue(), 2);
	}
	
}
