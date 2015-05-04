package controller;

import java.awt.event.MouseEvent;

import view.Application;
import view.MainMenuView;
import view.SplashPanel;
import junit.framework.TestCase;

public class TestSplashScreenController extends TestCase {
	
	public void test() {
		Application a = new Application();
		SplashPanel panel = new SplashPanel(a);
		ExitSplashScreen controller = new ExitSplashScreen(a);
		panel.addMouseListener(controller);
		a.changeView(panel);
		MouseEvent me = new MouseEvent(a.getCurrentView(), 0, 0, 0, 0, 0, 0, false);
		controller.mouseClicked(me);
		assertTrue(a.getCurrentView() instanceof MainMenuView);
	}

}
