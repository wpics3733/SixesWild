package controllerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.LevelEditorPanel;
import boundaryPackage.PropertiesMenuPanel;
import entityPackage.LevelModel;

/**
 * Used to save the levelModel to a file when the button is clicked.
 * @author Dean Kiourtsis
 *
 */
public class SaveLevelButtonController implements ActionListener {
	
	/** A reference to the parent panel, which is the level editor panel. */
	protected LevelEditorPanel parent;
	
	/** A reference to the model. */
	protected LevelModel model;
	
	/** A reference to the application */
	LevelBuilderApplication app;
	
	/** A reference to the properties menu panel. */
	PropertiesMenuPanel propertiesMenuPanel;
	
	/**
	 * Constructor for save level button controller.
	 * @param parent a reference to the parent panel, which is the level editor panel.
	 * @param model a reference to the model.
	 */
	public SaveLevelButtonController(LevelEditorPanel parent, LevelModel model, LevelBuilderApplication app, PropertiesMenuPanel propertiesMenuPanel) {
		this.parent = parent;
		this.model = model;
		this.app = app;
		this.propertiesMenuPanel = propertiesMenuPanel;
	}


	@Override
	/**
	 * Saves the level upon mouse click.
	 * It also applies any valid changes made in the properties menu panel.
	 * 
	 * @param e action event, which is a mouse click
	 */
	public void actionPerformed(ActionEvent e) {
		// First apply any changes in the properties menu panel
		new PropertiesMenuPanelController(model, app, propertiesMenuPanel).mousePressed(null);

		// Now we can save
		System.out.println("SaveLevelButtonController::Attempting to save level with current model.");
		model.saveLevel();
	}

}
