package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entityPackage.LevelModel;
import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.MenuPanel;

/**
 * Controller for the splash screen.
 * Directs the user to the main menu upon clicking anywhere within the splash screen.
 * 
 * @author Tom & Dabai
 */
public class SplashScreenPanelController extends MouseAdapter {

	/** A reference to the application. */
	LevelBuilderApplication app;
	
	/** A reference to the model. */
	LevelModel model;
	
	/** 
	 * Constructor for the splash screen panel controller.
	 * @param model a reference to the model.
	 * @param app a reference to the application.
	 */
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
