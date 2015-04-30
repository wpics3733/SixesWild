package model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestClearMove extends TestCase {
	Board b;
	Level l;
	LevelState state;
	int[][] boardVals;

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
		boardVals = vals;
		state.setBoardVals(boardVals);
		int[] specials = {1,1,1};
		state.setSpecialMoves(specials);
		l = new EliminationLevel(state);
		this.b = l.getBoard();
		
	}

	public void test() {
		TileContainer[][] tiles = b.getTiles();
		ClearMove move = new ClearMove();
		ArrayList<TileContainer> moveTiles = move.getTiles();
		assertEquals(moveTiles.size(), 0);
		assertFalse(move.isValid());
		assertTrue(move.addTile(tiles[1][1]));
		assertTrue(move.isValid());
		assertFalse(move.addTile(tiles[1][1]));
		moveTiles = move.getTiles();
		assertEquals(moveTiles.size(), 1);
		assertEquals(moveTiles.get(0), tiles[1][1]);
		Tile willDrop = tiles[1][0].getTile();
		move.pushMove(l);
		l.react(move);
		assertFalse(tiles[0][1].used());
		assertEquals(tiles[1][1].getTile(), willDrop);
		assertEquals(l.getNumSpecial(Level.CLEAR), 0);
	}

}