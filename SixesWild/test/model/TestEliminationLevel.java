package model;

import junit.framework.TestCase;

public class TestEliminationLevel extends TestCase {
	LevelState state;
	EliminationLevel l;
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
		l = new EliminationLevel(state);
		l.movesRemaining = 1;
		this.b = l.getBoard();
	}
	
	public void test() {
		assertEquals(l.typeString(), "Elimination");
		
		assertFalse(l.isFinished());
		assertFalse(l.hasPassed());
		
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
		
		assertEquals(l.getMovesRemaining(), 0);
		
		assertTrue(b.getTileContainers()[0][0].marked());
		assertTrue(l.isFinished());
		assertFalse(l.hasPassed());
		
		for(int i = 0; i < b.getW(); i++) {
			for(int j = 0; j < b.getH(); j++) {
				b.getTileContainers()[i][j].mark();
			}
		}
		
		assertTrue(l.isFinished());
		assertTrue(l.hasPassed());
		
		l.setScore(0);
		assertTrue(l.isFinished());
		assertFalse(l.hasPassed());

	}

}
