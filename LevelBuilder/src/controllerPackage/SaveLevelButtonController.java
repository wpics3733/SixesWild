package controllerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaryPackage.LevelEditorPanel;
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
	
	/**
	 * Constructor for save level button controller.
	 * @param parent a reference to the parent panel, which is the level editor panel.
	 * @param model a reference to the model.
	 */
	public SaveLevelButtonController(LevelEditorPanel parent, LevelModel model) {
		this.parent = parent;
		this.model = model;
	}


	@Override
	/**
	 * Saves the level upon mouse click.
	 * 
	 * @param e action event, which is a mouse click
	 */
	public void actionPerformed(ActionEvent e) {
		model.saveLevel();
	}

}
