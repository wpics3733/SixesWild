// Author: Dean K.

package boundaryPackage;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import controllerPackage.LoadLevelButtonController;
import entityPackage.LevelState;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

/** LevelPanels contains buttons used to select levels to edit
 * @author XOM
 * 
 */
public class LevelsPanel extends JPanel {
	protected MenuPanel parent;
	
	/**
	 * Creates a LevelsPanel using the default levels folder
	 * @param parent
	 */
	public LevelsPanel(MenuPanel parent) {
		this.parent = parent;
		setLayout(new GridLayout(4,0,10,10));
		
		try{
			File dir = new File("Levels");
			File[] directoryListing = dir.listFiles();
			//this.setPreferredSize(new Dimension());
			if(directoryListing != null){  // Use default level directory to create buttons
				for(File child : directoryListing){
					LevelState tmp = new LevelState();
					System.out.println(child.getName());
					tmp.loadState(child.getName());
					JButton button = new JButton(child.getName());
					button.addActionListener(new LoadLevelButtonController(parent.getParentApplication(), tmp));
					add(button);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
