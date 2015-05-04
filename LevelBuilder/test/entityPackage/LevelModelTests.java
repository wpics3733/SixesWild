package entityPackage;

import junit.framework.TestCase;

public class LevelModelTests extends TestCase {
	
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
