package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.MenuPanel;
import boundaryPackage.PropertiesMenuPanel;
import entityPackage.LevelModel;

/**
 * Controller that updates the model for changes made by the user in the properties panel.
 * 
 * The controller is initiated when the user clicks the "Apply" button at the bottom of the properties panel.
 * 
 * @author Tom & Dabai
 *
 */
public class PropertiesMenuPanelController extends MouseAdapter {
	
	/** A reference to the model */
	LevelModel model;
	
	/** A reference to the application */
	LevelBuilderApplication app;
	
	/** A reference to the properties panel, which is where this controller is initiated from. */
	PropertiesMenuPanel panel;
	
	/**
	 * Constructor for the properties menu panel controller
	 * @param model a reference to the model.
	 * @param app a reference to the application.
	 * @param panel a reference to the properties menu panel, which is where the mouse event for this controller is bound to.
	 * 
	 * @author Tom
	 */
	public PropertiesMenuPanelController(LevelModel model, LevelBuilderApplication app, PropertiesMenuPanel panel) {
		this.model = model;
		this.app = app;
		this.panel = panel;
	}
	
	/**
	 * Whenever mouse is pressed (left button), validate the user input from the
	 * properties menu panel, then if successful, update the model with the new data.
	 * 
	 * @param me the mouse event, a left click.
	 * 
	 * @author Tom
	 */
	@Override
	public void mousePressed(MouseEvent me) {
				
		// Validate the user input first, and return if something is invalid
		if (!validate()) {
			return;
		}
				
		model.setMovesAllowed(Integer.parseInt(panel.getMoveLimitTextField().getText()));
		
		model.setMultiplierProbabilities(
				Integer.parseInt(panel.getMultiplierProbability1().getText()),
				Integer.parseInt(panel.getMultiplierProbability2().getText()),
				Integer.parseInt(panel.getMultiplierProbability3().getText()));
		
		model.setSpecialMovesAllowed(
				Integer.parseInt(panel.getRearrangeSpecialTextField().getText()),
				Integer.parseInt(panel.getSwapSpecialTextField().getText()),
				Integer.parseInt(panel.getClearSpecialTextField().getText()));
		
		model.setStarMilestones(
				Integer.parseInt(panel.getStarLevelTextField1().getText()),
				Integer.parseInt(panel.getStarLevelTextField2().getText()),
				Integer.parseInt(panel.getStarLevelTextField3().getText()));
		
		model.setTileProbabilities(
				Integer.parseInt(panel.getTileProbabilityTextField1().getText()),
				Integer.parseInt(panel.getTileProbabilityTextField2().getText()),
				Integer.parseInt(panel.getTileProbabilityTextField3().getText()),
				Integer.parseInt(panel.getTileProbabilityTextField4().getText()),
				Integer.parseInt(panel.getTileProbabilityTextField5().getText()),
				Integer.parseInt(panel.getTileProbabilityTextField6().getText()));
		
		model.setTimeAllowed(Integer.parseInt(panel.getTimeLimitTextField().getText()));
		
		model.setMode((String) panel.getComboBox().getSelectedItem());
		
		model.setName(panel.getLevelNameTextField().getText());
	}
	
	/** 
	 * Validates all of the user input for the PropertiesMenuPanel.
	 * 
	 * @author Tom Finelli
	 * @return true if all the data was valid, false otherwise.
	 */
	public boolean validate() {
		
		
		return validateStarMilestones();
	}
	
	private boolean validateStarMilestones() {
		// Initialize the integers to anything so that Eclipse does not complain
		int starLevel1 = 0, starLevel2 = 0, starLevel3 = 0;
		
		try {
			starLevel1 = Integer.parseInt(panel.getStarLevelTextField1().getText()); 
			starLevel2 = Integer.parseInt(panel.getStarLevelTextField2().getText());
			starLevel3 = Integer.parseInt(panel.getStarLevelTextField3().getText()); }
		
		catch(NumberFormatException e) { 
			System.err.println("Invalid input. Please input an integer value.");
			return false;
			
		}
		
		
		if ( !(starLevel3 > starLevel2 && starLevel2 > starLevel1) ) {
			System.err.println("Star milestone requirements must be increasing.");
			return false;
		}
		
		if ( starLevel1 <= 0 || starLevel2 <= 0 || starLevel3 <= 0) {
			System.err.println("Star milestone requirements must be positive values.");
			return false;
		}
		
		return true;
	}

}
