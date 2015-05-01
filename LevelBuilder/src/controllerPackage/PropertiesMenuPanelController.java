package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.MenuPanel;
import boundaryPackage.PropertiesMenuPanel;
import entityPackage.LevelModel;

public class PropertiesMenuPanelController extends MouseAdapter {
	LevelModel model;
	LevelBuilderApplication app;
	PropertiesMenuPanel panel;
	
	int starLevel1, starLevel2, starLevel3, moveLimit, multiplierProbability1, multiplierProbability2, multiplierProbability3,
	rearrangeSpecial, swapSpecial, clearSpecial, tileProbability1, tileProbability2, tileProbability3, tileProbability4,
	tileProbability5, tileProbability6, timeLimit;
	String mode;
	
	public PropertiesMenuPanelController(LevelModel model, LevelBuilderApplication app, PropertiesMenuPanel panel) {
		this.model = model;
		this.app = app;
		this.panel = panel;
	}
	
	/**
	 * Whenever mouse is pressed (left button), set the current view to the MenuPanel.
	 * This is a GUI controller.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
			
		// Validate the user input first, and return if something is invalid
		if (!validate()) {
			return;
		}
		
		model.setMode(mode);
		model.setMovesAllowed(moveLimit);
		model.setMultiplierProbabilities(multiplierProbability1, multiplierProbability2, multiplierProbability3);
		model.setSpecialMovesAllowed(rearrangeSpecial, swapSpecial, clearSpecial);
		model.setStarMilestones(starLevel1, starLevel2, starLevel3);
		model.setTileProbabilities(tileProbability1, tileProbability2, tileProbability3, tileProbability4, tileProbability5, tileProbability6);
		model.setTimeAllowed(timeLimit);
	}
	
	/** 
	 * Validates all of the user input for the PropertiesMenuPanel.
	 * 
	 * @author Tom Finelli
	 * @return
	 */
	public boolean validate() {		
		if (! (validateTextFields() &&
				validateMode() &&
				validateMoveLimit() &&
				validateMultiplierProbability() &&
				validateSpecial() &&
				validateStarMilestones() &&
				validateTileProbability()) ) {
			System.out.println("PropertiesMenuPanelController::Validation failed.");
			return false;
		}
		
		System.out.println("PropertiesMenuPanelController::Validation passed.");
		return true;
	}
	
	public boolean validateTextFields() {
		try {
			mode = (String) panel.getComboBox().getSelectedItem();
			
			moveLimit = Integer.parseInt(panel.getMoveLimitTextField().getText());
			
			multiplierProbability1 = Integer.parseInt(panel.getMultiplierProbability1().getText());
			multiplierProbability2 = Integer.parseInt(panel.getMultiplierProbability2().getText());
			multiplierProbability3 = Integer.parseInt(panel.getMultiplierProbability3().getText());
			
			rearrangeSpecial = Integer.parseInt(panel.getRearrangeSpecialTextField().getText());
			swapSpecial = Integer.parseInt(panel.getSwapSpecialTextField().getText());
			clearSpecial = Integer.parseInt(panel.getClearSpecialTextField().getText());
						
			starLevel1 = Integer.parseInt(panel.getStarLevelTextField1().getText()); 
			starLevel2 = Integer.parseInt(panel.getStarLevelTextField2().getText());
			starLevel3 = Integer.parseInt(panel.getStarLevelTextField3().getText()); 
			
			tileProbability1 = Integer.parseInt(panel.getTileProbabilityTextField1().getText());
			tileProbability2 = Integer.parseInt(panel.getTileProbabilityTextField2().getText());
			tileProbability3 = Integer.parseInt(panel.getTileProbabilityTextField3().getText());
			tileProbability4 = Integer.parseInt(panel.getTileProbabilityTextField4().getText());
			tileProbability5 = Integer.parseInt(panel.getTileProbabilityTextField5().getText());
			tileProbability6 = Integer.parseInt(panel.getTileProbabilityTextField6().getText());
			
			timeLimit = Integer.parseInt(panel.getTimeLimitTextField().getText());
			

		}
		catch(NumberFormatException e) { 
			System.err.println("Invalid input. Please make sure that all text fields have an integer value.");
			return false;	
		}
		return true;
	}
	
	
	private boolean validateMode() {
		if (! (mode.equals("Puzzle") || mode.equals("Lightning") || mode.equals("Six Drop") || mode.equals("Marked Tiles")) ) {
			System.err.println("Invalid mode.");
			return false;
		}
		return true;
	}
	
	private boolean validateMoveLimit() {
		if (moveLimit <= 0) {
			System.err.println("The number of moves must be greater than 0.");
			return false;
		}
		return true; 
	}
	
	private boolean validateMultiplierProbability() {
		int multiplierProbabilitySum = multiplierProbability1 + multiplierProbability2 + multiplierProbability3;
		if (multiplierProbabilitySum != 100) {
			System.err.println("Multiplier probabilities must sum to 100.  Current sum is " + multiplierProbabilitySum + 
					", and " + (100 - multiplierProbabilitySum) + " more units are needed to equal 100.");
			return false;
		}
		
		if ((multiplierProbability1 < 0) || (multiplierProbability2 < 0) || (multiplierProbability1 < 0)) {
			System.err.println("Multiplier probabilities must be positive values.");
			return false;
		}
		
		return true;
	}
	
	private boolean validateSpecial() {
		if (rearrangeSpecial < 0 && swapSpecial < 0 && clearSpecial < 0) {
			System.err.println("Special move counts must be greater than zero.");
			return false;
		}
		return true;
	}
	
	private boolean validateStarMilestones() {
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
	
	private boolean validateTileProbability() {
		int tileProbabilitySum = tileProbability1 + tileProbability2 + tileProbability3 + tileProbability4 + tileProbability5 + tileProbability6;
		
		if (tileProbabilitySum != 100) {
			System.err.println("Tile probabilities must sum to 100.  Current sum is " + tileProbabilitySum + 
					", and " + (100 - tileProbabilitySum) + " more units are needed to equal 100.");
			return false;
		}
		
		if ( tileProbability1 < 0 || tileProbability2 < 0 || tileProbability3 < 0 || tileProbability3 < 0 ||
				tileProbability4 < 0 || tileProbability5 < 0 || tileProbability6 < 0) {
			System.err.println("Tile probabilities must be positive values.");
			return false;
		}
		
		return true;
	}
}
