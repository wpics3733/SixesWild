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
	protected LevelBuilderApplication app;
	protected LevelState model;
	
	
	
	public LoadLevelButtonController(LevelBuilderApplication app, LevelState model) {
		this.app = app;
		this.model = model;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.setCurrentView(new LevelEditorPanel(app, new LevelModel(model)));
	}

}
