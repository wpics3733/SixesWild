package entityPackage;
import junit.framework.TestCase;


public class LevelStateTests extends TestCase {
	
	public void testSimple(){
		LevelState l = new LevelState();
		LevelState m = new LevelState();
		
		l.setLevelType("Lightning");
		assertTrue(l.getLevelType().equals("Lightning"));
		
		l.saveState();
		
		
		m.loadState(l.levelName.concat(".sav"));
		assertTrue(m.getLevelType().equals("Lightning"));
	}
	
}
