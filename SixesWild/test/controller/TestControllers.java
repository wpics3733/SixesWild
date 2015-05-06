package controller;

import java.awt.event.MouseEvent;

import view.AchievementPanel;
import view.Application;
import view.MainMenuView;
import junit.framework.TestCase;

public class TestControllers extends TestCase {

	public void testTransitionControllers() {
		Application app = new Application();
		AchievementPanelController ach = new AchievementPanelController(app);
		ShowCreditController scc = new ShowCreditController(app);
		ExitSplashScreen exit = new ExitSplashScreen(app);
		ResetAchievementsController reset = new ResetAchievementsController(app);
		ReturnToMenuController menuReturn = new ReturnToMenuController(app);
		QuitController quit = new QuitController(app);
		MainMenuView main = new MainMenuView(app);
		AchievementPanel achievement = new AchievementPanel(app);
		app.changeView(main);
		
		MouseEvent me = new MouseEvent(app.getCurrentView(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				main.creditsButton.getX(), main.creditsButton.getY(), 0, false);
		
		scc.mouseClicked(me);
		
		me = new MouseEvent(app.getCurrentView(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				0, 0, 0, false);
		
		exit.mouseClicked(me);
		
		me = new MouseEvent(app.getCurrentView(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				main.achievementsButton.getX(), main.achievementsButton.getY(), 0, false);
		
		ach.mouseClicked(me);
		
		me = new MouseEvent(app.getCurrentView(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				achievement.reset.getX(), achievement.reset.getY(), 0, false);
		
		reset.mouseClicked(me);
		
		reset.mouseClicked(me);
		
		me = new MouseEvent(app.getCurrentView(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				achievement.back.getX(), achievement.back.getY(), 0, false);
		
		menuReturn.mouseClicked(me);
	}
}
