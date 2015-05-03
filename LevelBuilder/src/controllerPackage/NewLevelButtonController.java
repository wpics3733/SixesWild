package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import entityPackage.LevelModel;
import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.LevelEditorPanel;

public class NewLevelButtonController extends MouseAdapter {
	LevelBuilderApplication app;
	LevelModel model;
	
	public NewLevelButtonController(LevelBuilderApplication app, LevelModel model) {
		this.app = app;
		this.model = model;
	}
	
	
	/**
	 * Set the view to LevelEditorPanel.
	 * This is a GUI controller.
	 * 
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
