package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.MenuPanel;
import entityPackage.LevelModel;

/**
 * Controller that returns the user back to the main menu
 * 
 * @author Tom
 *
 */
public class QuitButtonController extends MouseAdapter {
	/** A reference to the model. */
	LevelModel model;
	
	/** A reference to the application */
	LevelBuilderApplication app;
	
	/**
	 * Constructor for the quit button controller.
	 * @param model a reference to the model.
	 * @param app a reference to the application.
	 * 
	 * @author Tom
	 */
	public QuitButtonController(LevelModel model, LevelBuilderApplication app) {
		this.model = model;
		this.app = app;
	}
	
	/**
	 * Whenever mouse is pressed (left button), set the current view to the MenuPanel.
	 * This is a GUI controller.
	 * 
	 * @author Tom
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		app.setCurrentView(new MenuPanel(app, model));
	}

}
