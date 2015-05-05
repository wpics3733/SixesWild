package controllerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.LevelEditorPanel;
import entityPackage.LevelModel;
import entityPackage.LevelState;

/**
 * Used to load a level into memory, and change the view to a LevelEditorPanel.
 * @author Dean Kiourtsis
 *
 */
public class LoadLevelButtonController implements ActionListener {
	/** A reference to the application. */
	protected LevelBuilderApplication app;
	
	/** The level state, which is the Java object in which levels are saved. */
	protected LevelState model;
	
	
	/**
	 * Constructor for load level button controller.
	 * 
	 * @param app a reference to the application.
	 * @param model the level state, which is the Java object in which levels are saved.
	 */
	public LoadLevelButtonController(LevelBuilderApplication app, LevelState model) {
		this.app = app;
		this.model = model;
	}
	
	
	@Override
	/**
	 * Set the current view to a new level editor panel with a new model.
	 * The new model is generated from the specified level state.
	 */
	public void actionPerformed(ActionEvent e) {
		app.setCurrentView(new LevelEditorPanel(app, new LevelModel(model)));
	}

}
