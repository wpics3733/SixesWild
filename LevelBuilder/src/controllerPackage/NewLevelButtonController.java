package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import entityPackage.LevelModel;
import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.LevelEditorPanel;
/**
 * Controller that sets the current view to the level editor panel.
 * 
 * @author Tom & Dabai 
 */
public class NewLevelButtonController extends MouseAdapter {
	/** A reference to the application. */
	LevelBuilderApplication app;
	
	/** A reference to the model. */
	LevelModel model;
	
	/**
	 * Constructor for new level button controller.
	 * 
	 * @param app a reference to the application
	 * @param model a reference to the model
	 * 
	 * @author Tom
	 */
	public NewLevelButtonController(LevelBuilderApplication app, LevelModel model) {
		this.app = app;
		this.model = model;
	}
	
	
	/**
	 * Set the view to LevelEditorPanel.
	 * This is a GUI controller.
	 * 
	 * @param me the mouse event, a left click
	 * 
	 * @author Tom
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		System.out.println("NewLevelButtonController::Mouse click at: " + me.getX() + ", " + me.getY());
		
		LevelModel newLevelModel = new LevelModel();
		app.setModel(newLevelModel);
		this.model = newLevelModel;
		
		app.setCurrentView(new LevelEditorPanel(app, model));
	}

}
