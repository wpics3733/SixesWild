package model;

import controller.AchievementFileController;
import junit.framework.TestCase;

public class TestAchievements extends TestCase {
	
	public void setUp() {
		Achievement.initializeAll();
		AchievementFileController controller = new AchievementFileController();
		controller.loadSave();
	}
	
	public void testOverpopulatedMoveAchievement() {
		UserMove move = new UserMove();
		NumberTileContainer container1 = new NumberTileContainer(new Tile(6, 1), 0, 0);
		NumberTileContainer container2 = new NumberTileContainer(new Tile(6, 1), 1, 0);
		NumberTileContainer container3 = new NumberTileContainer(new Tile(6, 1), 1, 1);
		NumberTileContainer container4 = new NumberTileContainer(new Tile(6, 1), 0, 1);
		move.addTile(container1);
		move.addTile(container2);
		move.addTile(container3);
		
		OverpopulatedMoveAchievement a = new OverpopulatedMoveAchievement();
		
		assertFalse(a.unlocked(move));
		move.addTile(container4);
		assertTrue(a.unlocked(move));
	}
	
	public void testOverpopulatedMoveAchievement2() {
		UserMove move = new UserMove();
		NumberTileContainer container1 = new NumberTileContainer(new Tile(6, 1), 0, 0);
		NumberTileContainer container2 = new NumberTileContainer(new Tile(6, 1), 1, 0);
		NumberTileContainer container3 = new NumberTileContainer(new Tile(6, 1), 1, 1);
		NumberTileContainer container4 = new NumberTileContainer(new Tile(2, 1), 0, 1);
		move.addTile(container1);
		move.addTile(container2);
		move.addTile(container3);
		move.addTile(container4);
		
		Achievement.initializeAll();
		OverpopulatedMoveAchievement a = new OverpopulatedMoveAchievement();
		
		assertFalse(a.unlocked(move));
	}
	
	public void testTileSwapMoveAchievement() {
		SwapMove move = new SwapMove();
		move.addTile(new NumberTileContainer(new Tile(6, 1), 0, 0));
		move.addTile(new NumberTileContainer(new Tile(6, 1), 0, 1));
		
		TileSwapMoveAchievement a = new TileSwapMoveAchievement();
		
		TileSwapMoveAchievement.check(move);
		assertTrue(a.isUnlocked());
	}
}
