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
	LevelModel model;
	LevelEditorPanel parent;
	
	public UndoButtonController(LevelEditorPanel parent, LevelModel model) {
		this.model = model;
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.undoMove();
	}
}
