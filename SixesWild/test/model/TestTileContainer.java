package model;

import junit.framework.TestCase;

public class TestTileContainer extends TestCase {
	
	public void setUp() {
		
	}
	
	public void test() {
		try {
			new TileContainer(null, 0, 0);
			fail("Should've caught a nullPointer exception");
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
		Tile t = new Tile(2,2);
		TileContainer testee = new TileContainer(t, 2, 2);
		assertEquals(testee.getTile(), t);
		assertEquals(testee.getX(), 2);
		assertEquals(testee.getY(), 2);
		TileContainer other = new TileContainer(t, 1, 1);
		assertFalse(testee.isAdjacentTo(other));
		other = new TileContainer(t, 1, 2);
		assertTrue(testee.isAdjacentTo(other));
		try {
			testee.setTile(null);
			fail("Should've caught a nullPointer exception");
		} catch (NullPointerException ex) {
			assertTrue(true);
		}
		
		testee.clearTile();
		assertTrue(testee.empty());
		testee.setTile(t);
		assertFalse(testee.empty());
		assertFalse(testee.used());
		testee.setUsed(true);
		assertTrue(testee.used());
		
		assertFalse(testee.getMarked());
		testee.setMarked(true);
		assertTrue(testee.getMarked());
	}

}
