package model;

import junit.framework.TestCase;

public class TestBucketTileContainer extends TestCase {
	
	public void test() {
		AbstractTileContainer bucket = new BucketTileContainer(0, 0);
		assertTrue(bucket.empty());
		assertFalse(bucket.isNull());
		assertEquals(bucket.getTile(), null);
		assertFalse(bucket.addTile(new Tile(3,1)));
		assertTrue(bucket.addTile(new Tile(6,1)));
		assertFalse(bucket.empty());
		assertTrue(bucket.isNull());
		assertFalse(bucket.marked());
	}

}
