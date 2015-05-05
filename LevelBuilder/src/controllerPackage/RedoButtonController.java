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
	LevelModel model;
	LevelEditorPanel parent;
	
	public RedoButtonController(LevelEditorPanel parent, LevelModel model) {
		this.model = model;
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.doMove();
	}
}
