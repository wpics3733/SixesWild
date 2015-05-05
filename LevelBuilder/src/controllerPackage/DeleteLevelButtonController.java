package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entityPackage.LevelModel;
import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.MenuPanel;

/**
 * Controller that manages a click on the delete level button.
 * 
 * @author Tom
 */
public class DeleteLevelButtonController extends MouseAdapter {
	String levelName;
	boolean isGeneratedByLevelModel;
	LevelBuilderApplication app;
	
	/** 
	 * Constructor for a delete level button controller.
	 * 
	 * @param levelName the level name to be deleted, this should always be always the current level
	 * @param isGeneratedByLevelModel true if the current level was loaded from a file, false otherwise
	 * @param app a reference to the application'
	 * 
	 * @author Tom
	 */
	public DeleteLevelButtonController(String levelName, boolean isGeneratedByLevelModel, LevelBuilderApplication app) {
		this.levelName = levelName;
		this.isGeneratedByLevelModel = isGeneratedByLevelModel;
		this.app = app;
	}
	
	/**
	 * If the button is pressed, it will prompt a confirmation window, and 
	 * if pressed YES, will delete the level.
	 * 
	 * @param me the mouse event, a left click
	 * @author Tom
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		if (!isGeneratedByLevelModel) {
			return;
		}
				
		if (JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to delete this level?", "Delete Level", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			File file = new File("Levels/" + this.levelName + ".sav");
			if (file.exists()) {
				file.delete();
				app.setCurrentView(new MenuPanel(app, new LevelModel()));
			}
		}
	}

}
