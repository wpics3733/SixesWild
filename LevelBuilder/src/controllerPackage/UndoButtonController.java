package controllerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaryPackage.LevelEditorPanel;
import entityPackage.LevelModel;

/**
 * Causes the model to undo a move whenever the button is pressed.
 * @author Dean Kiourtsis
 *
 */
public class UndoButtonController implements ActionListener {
	/** A reference to the model. */
	LevelModel model;
	
	/** A reference to the parent panel, which is the level editor panel. */
	LevelEditorPanel parent;
	
	/**
	 * Constructor for undo button controller.
	 * @param parent a reference to the parent panel, which is the level editor panel.
	 * @param model a reference to the model.
	 */
	public UndoButtonController(LevelEditorPanel parent, LevelModel model) {
		this.model = model;
		this.parent = parent;
	}
	
	@Override
	/**
	 * Undoes the move.
	 * @param arg0 the action event, which is a mouse click on the undo button.
	 */
	public void actionPerformed(ActionEvent arg0) {
		model.undoMove();
	}
}
