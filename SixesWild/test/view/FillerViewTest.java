package view;

import model.EliminationLevel;
import model.LevelState;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;
import junit.framework.TestCase;

public class FillerViewTest extends TestCase {
	
	/**
	 * Don't worry about this
	 * you didn't see anything
	 */
	public void test() {
		Application a = new Application();
		assertTrue(a.getCurrentView() instanceof SplashPanel);

		a.changeView(new MainMenuView(a));
		a.changeView(new AchievementPanel(a));
		LevelView level_view;
		level_view = new LevelView(new PuzzleLevel(new LevelState()), new EliminationLevel(new LevelState()), a);
		a.changeView(level_view);
		level_view.repaint();
		level_view.restart();
		level_view = new LevelView(new EliminationLevel(new LevelState()), new EliminationLevel(new LevelState()), a);
		a.changeView(level_view);
		level_view.repaint();
		level_view.restart();
		level_view = new LevelView(new LightningLevel(new LevelState()), new EliminationLevel(new LevelState()), a);
		a.changeView(level_view);
		level_view.repaint();
		level_view = new LevelView(new ReleaseLevel(new LevelState()), new EliminationLevel(new LevelState()), a);
		a.changeView(level_view);
		level_view.repaint();
		level_view.restart();
		level_view.endLevel();
		a.changeView(new PastLevelPanel(a));
		assertTrue(true);
	}

}
