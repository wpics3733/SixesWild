package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.LevelBuilderApplication;
import entityPackage.LevelModel;


/**
 * Quits the level builder when the button is clicked.
 * @author Dean, Dabai
 *
 */
public class QuitGameController extends MouseAdapter {
	/** A reference to the application. */
	LevelBuilderApplication app;
	
	/**
	 * Constructor for the quit game controller.
	 * Maintains a reference to the current application.
	 * @param app
	 */
	public QuitGameController(LevelBuilderApplication app) {
		this.app = app;
	}
	
	/**
	 * Whenever mouse is pressed (left button), get dispose of the current view.
	 * This should cause the main menu panel to be displayed.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		app.dispose();
	}

}
