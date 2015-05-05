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
 * @author Dabai
 *
 */
public class DeleteLevelButtonController extends MouseAdapter {
	String levelName;
	boolean isGeneratedByLevelModel;
	LevelBuilderApplication app;
	
	public DeleteLevelButtonController(String levelName, boolean isGeneratedByLevelModel, LevelBuilderApplication app) {
		this.levelName = levelName;
		this.isGeneratedByLevelModel = isGeneratedByLevelModel;
		this.app = app;
	}
	
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
