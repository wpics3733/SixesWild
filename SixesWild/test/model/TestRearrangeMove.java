package model;

import junit.framework.TestCase;

public class TestRearrangeMove extends TestCase {
	LevelState state;
	Level l;
	Board b;
	
	public void setUp() {
		state = new LevelState();
		int[][] vals = 
			{
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3}
			};
		state.setBoardVals(vals);
		int[] specials = {1,1,1};
		state.setSpecialMoves(specials);
		l = new EliminationLevel(state);
		b = l.getBoard();
	}
	
	public void test() {
		RearrangeMove move = new RearrangeMove();
		TileContainer[][] tiles = b.getTileContainers();
		assertFalse(move.addTile(tiles[0][0]));
		assertTrue(move.isValid());
		assertNull(move.getTiles());
		Tile nonMovingSix = tiles[0][5].getTile();
		move.pushMove(l);
		l.react(move);

		//6 Tiles never move when the board is rearranged
		assertEquals(tiles[0][5].getTile(), nonMovingSix);
		
		
	}

}
