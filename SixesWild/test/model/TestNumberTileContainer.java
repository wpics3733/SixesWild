package model;

import junit.framework.TestCase;
import model.NumberTileContainer;

public class TestNumberTileContainer extends TestCase {
	
	public void test() {
		Tile three = new Tile(3,1);
		AbstractTileContainer tc = new NumberTileContainer(three, 0, 0);
		AbstractTileContainer adjacent = new NumberTileContainer(new Tile(2,2), 1, 0);
		AbstractTileContainer not_adjacent = new NumberTileContainer(new Tile(2,2), 1, 1);
		assertTrue(tc.isAdjacentTo(adjacent));
		assertTrue(adjacent.isAdjacentTo(tc));
		
		assertFalse(tc.isAdjacentTo(not_adjacent));
		assertFalse(not_adjacent.isAdjacentTo(tc));
		
		assertEquals(tc.getTile(), three);
		
		assertFalse(tc.isNull());
		
		assertFalse(tc.empty());
		tc.clearTile();
		assertTrue(tc.empty());
		
		try {
			tc.addTile(null);
			fail();
		} catch (NullPointerException e) {}
		
		assertTrue(tc.addTile(three));
		assertFalse(tc.addTile(new Tile(5,2)));
		assertEquals(tc.getTile(), three);
	}

}
