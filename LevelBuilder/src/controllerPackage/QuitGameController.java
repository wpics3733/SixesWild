package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.LevelBuilderApplication;
import entityPackage.LevelModel;


/**
 * Changes the application view to a MenuPanel on mouse press.
 * @author 
 *
 */
public class QuitGameController extends MouseAdapter {
	LevelBuilderApplication app;
	
	public QuitGameController(LevelBuilderApplication app) {
		this.app = app;
	}
	
	/**
	 * Whenever mouse is pressed (left button), set the current view to the MenuPanel.
	 * This is a GUI controller.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		app.dispose();
	}

}
