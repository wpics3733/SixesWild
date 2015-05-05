package model;

import junit.framework.TestCase;

public class TestTile extends TestCase {
	
	public void setUp() {
		
	}
	
	public void test() {
		Tile t = new Tile(3, 3);
		assertEquals(t.getNum(), 3);
		assertEquals(t.getMultiplier(), 3);
	}

}
