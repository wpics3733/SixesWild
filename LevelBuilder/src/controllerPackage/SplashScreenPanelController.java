package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entityPackage.LevelModel;
import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.MenuPanel;

public class SplashScreenPanelController extends MouseAdapter {

	LevelBuilderApplication app;
	LevelModel model;
	
	public SplashScreenPanelController(LevelModel model, LevelBuilderApplication app) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * Whenever mouse is pressed (left button), load the MenuPanel.
	 * This is a GUI controller.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		System.out.println("SplashScreenController::Mouse click at " + me.getX() + ", " + me.getY());
		
		app.setCurrentView(new MenuPanel(app, model));
	}
}
