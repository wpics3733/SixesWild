package model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestSwapMove extends TestCase {
	Board b;
	Level l;
	LevelState state;
	int[][] boardVals;

	public void setUp() {
		state = new LevelState();
		int[][] vals = 
			{
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3},
				{1,2,1,4,5,6,1,2,3}
			};
		boardVals = vals;
		state.setBoardVals(boardVals);
		int[] specials = {1,1,1};
		state.setSpecialMoves(specials);
		l = new EliminationLevel(state);
		this.b = l.getBoard();
		
	}

	public void test() {
		AbstractTileContainer[][] tiles = b.getTileContainers();
		SwapMove move = new SwapMove();
		ArrayList<AbstractTileContainer> moveTiles = move.getTiles();
		assertEquals(moveTiles.size(), 0);
		assertFalse(move.isValid());
		//Cannot add because the tile is null
		assertFalse(move.addTile(tiles[0][8]));
		assertTrue(move.addTile(tiles[1][1]));
		assertTrue(tiles[1][1].used());
		assertFalse(move.addTile(tiles[1][1]));
		assertFalse(move.isValid());
		assertFalse(move.addTile(tiles[0][0]));
		assertTrue(move.addTile(tiles[1][0]));
		moveTiles = move.getTiles();
		assertEquals(moveTiles.size(), 2);
		assertTrue(moveTiles.contains(tiles[1][1]));
		assertTrue(moveTiles.contains(tiles[1][0]));
		Tile swap_1 = tiles[1][1].getTile();
		Tile swap_2 = tiles[1][0].getTile();
		assertTrue(move.isValid());
		try {
			move.addTile(tiles[5][5]);
			fail("Should've caught an exception");
		} catch (RuntimeException e) {
		}
		move.pushMove(l);
		l.react(move);
		assertFalse(tiles[1][1].used());
		assertFalse(tiles[1][0].used());
		assertEquals(tiles[1][0].getTile(), swap_1);
		assertEquals(tiles[1][1].getTile(), swap_2);
		assertEquals(l.getNumSpecial(Level.SWAP), 0);
	}


}
