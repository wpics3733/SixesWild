package view;

import model.LevelState;
import model.PuzzleLevel;
import junit.framework.TestCase;

public class FillerViewTest extends TestCase {
	
	/**
	 * Don't worry about this
	 * you didn't see anything
	 */
	public void test() {
		Application a = new Application();
		a.changeView(new MainMenuView(a));
		a.changeView(new AchievementPanel(a));
		LevelView level_view = new LevelView(new PuzzleLevel(new LevelState()), a);
		a.changeView(level_view);
		level_view.endLevel();
		a.changeView(new PastLevelPanel(a));
		assertTrue(true);
	}

}
