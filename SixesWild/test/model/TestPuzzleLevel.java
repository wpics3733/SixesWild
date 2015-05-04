package model;

import junit.framework.TestCase;

public class TestPuzzleLevel extends TestCase {
	LevelState state;
	PuzzleLevel l;
	int[][] boardVals;
	Board b;
	
	public void setUp() {
		state = new LevelState();
		int[][] vals = 
			{
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1},
				{1,2,1,4,5,6,1,2,-1}
			};
		boardVals = vals;
		state.setBoardVals(boardVals);
		int[] mileStones = {20,30,40};
		state.setStarScores(mileStones);
		l = new PuzzleLevel(state);
		l.setMovesRemaining(1);
		this.b = l.getBoard();
	}
	
	public void test() {
		assertFalse(l.hasPassed());
		assertFalse(l.isFinished());
		assertEquals(l.getMilestones()[0], 20);
		assertEquals(l.getMovesRemaining(), 1);
		
		UserMove move = new UserMove();
		move.addTile(b.getTileContainers()[0][0]);
		move.addTile(b.getTileContainers()[1][0]);
		move.addTile(b.getTileContainers()[2][0]);
		move.addTile(b.getTileContainers()[3][0]);
		move.addTile(b.getTileContainers()[4][0]);
		move.addTile(b.getTileContainers()[5][0]);
		
		assertTrue(move.isValid());
		
		move.pushMove(l);
		l.react(move);
		
		assertTrue(l.isFinished());
		assertTrue(l.hasPassed());
		l.setScore(0);
		assertTrue(l.isFinished());
		assertFalse(l.hasPassed());
		
	}

}
