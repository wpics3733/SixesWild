package model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestUserMove extends TestCase {
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
		l = new EliminationLevel(state);
		this.b = l.getBoard();
	}
	
	public void test() {
		AbstractTileContainer[][] tiles = b.getTileContainers();
		UserMove move = new UserMove();
		ArrayList<AbstractTileContainer> moveTiles = move.getTiles();
		assertEquals(moveTiles.size(), 0);
		assertTrue(move.addTile(tiles[0][1]));
		assertFalse(move.addTile(tiles[0][1]));
		assertFalse(move.addTile(tiles[1][2]));
		assertTrue(move.addTile(tiles[1][1]));
		assertFalse(move.addTile(tiles[0][8]));
		assertFalse(move.isValid());
		assertTrue(move.addTile(tiles[1][2]));
		assertTrue(move.addTile(tiles[0][2]));
		assertTrue(move.isValid());
		assertTrue(tiles[0][1].used());
		moveTiles = move.getTiles();
		assertEquals(moveTiles.size(), 4);
		assertTrue(moveTiles.contains(tiles[0][1]));
		assertTrue(moveTiles.contains(tiles[1][1]));
		assertTrue(moveTiles.contains(tiles[1][2]));
		assertTrue(moveTiles.contains(tiles[0][2]));

		Tile willDrop = tiles[0][0].getTile();
		move.pushMove(l);
		move.finishMove();
		l.react(move);
		assertFalse(tiles[0][1].used());
		assertTrue(tiles[0][1].marked());
		assertEquals(l.getScore(), 4 * 10);
		assertEquals(tiles[0][2].getTile(), willDrop);
	}

}
