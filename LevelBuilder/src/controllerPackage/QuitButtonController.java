package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.MenuPanel;
import entityPackage.LevelModel;

public class QuitButtonController extends MouseAdapter {
	LevelModel model;
	LevelBuilderApplication app;
	
	public QuitButtonController(LevelModel model, LevelBuilderApplication app) {
		this.model = model;
		this.app = app;
	}
	
	/**
	 * Whenever mouse is pressed (left button), set the current view to the MenuPanel.
	 * This is a GUI controller.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		app.setCurrentView(new MenuPanel(app, model));
	}

}
