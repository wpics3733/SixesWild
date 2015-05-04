package controllerPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaryPackage.LevelEditorPanel;
import entityPackage.LevelModel;

/** Controller for Save Level Button
 * @author Dean K.
 *
 */
public class SaveLevelButtonController implements ActionListener {
	protected LevelEditorPanel parent;
	protected LevelModel model;
	
	
	
	public SaveLevelButtonController(LevelEditorPanel parent, LevelModel model) {
		this.parent = parent;
		this.model = model;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		model.saveLevel();
	}

}
