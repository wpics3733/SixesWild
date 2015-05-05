package controllerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaryPackage.LevelEditorPanel;
import entityPackage.LevelModel;

/**
 * Makes the level model re-do the last undone move when the button is clicked.
 * @author Dean Kiourtsis
 *
 */
public class RedoButtonController implements ActionListener {
	/** A reference to the model. */
	LevelModel model;
	
	/** A reference to the parent panel, which is the level editor. */
	LevelEditorPanel parent;
	
	/**
	 * Constructor for redo button controller.
	 * Handles redo within the level builder.
	 * 
	 * @param parent a reference to the parent panel, which is the level editor.
	 * @param model a reference to the model.
	 * 
	 * @author Dean
	 */
	public RedoButtonController(LevelEditorPanel parent, LevelModel model) {
		this.model = model;
		this.parent = parent;
	}
	
	@Override
	/**
	 * Redo the move.
	 * 
	 * @author Dean
	 */
	public void actionPerformed(ActionEvent e) {
		model.doMove();
	}
}
