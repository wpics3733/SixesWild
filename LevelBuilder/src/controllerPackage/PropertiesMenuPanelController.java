package controllerPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

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
	
	/** The point requirement for the first star. */
	int starLevel1;
	
	/** The point requirement for the second star. */
	int starLevel2;
	
	/** The point requirement for the third star. */
	int starLevel3;
	
	/** The maximum number of moves allowed. */
	int moveLimit;
	
	/** The 1 multiplier probability. */
	int multiplierProbability1;
	
	/** The 2 multiplier probability. */
	int multiplierProbability2;
	
	/** The 3 multiplier probability. */
	int multiplierProbability3;
	
	/** The number of special move rearranges allowed. */
	int rearrangeSpecial;
	
	/** The number of special move swaps allowed. */
	int swapSpecial;
	
	/** The number of special move clears allowed. */
	int clearSpecial;
	
	/** The 1 tile appearance probability. */
	int tileProbability1;
	
	/** The 2 tile appearance probability. */
	int tileProbability2;
	
	/** The 3 tile appearance probability. */
	int tileProbability3;
	
	/** The 4 tile appearance probability. */
	int tileProbability4;
	
	/** The 5 tile appearance probability. */
	int tileProbability5;
	
	/** The 6 tile appearance probability. */
	int tileProbability6;
	
	/** The maximum time allowed for a level. */
	int timeLimit;
	
	/** The level type (e.g. Lightning, Release, etc.). */
	String mode;
	
	/** The level name. */
	String levelName;
	
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
		model.setName(levelName);
		model.setSpecialMovesAllowed(rearrangeSpecial, swapSpecial, clearSpecial);
		model.setStarMilestones(starLevel1, starLevel2, starLevel3);
		model.setTileProbabilities(tileProbability1, tileProbability2, tileProbability3, tileProbability4, tileProbability5, tileProbability6);
		model.setTimeAllowed(timeLimit);
	}
	
	/** 
	 * Validates all of the user input for the PropertiesMenuPanel.
	 * 
	 * @author Tom Finelli
	 * @return true if all user input is valid.
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
		/*
		JOptionPane.showMessageDialog(app, "Your changes have been applied.\n\n NOTE: The level will "
				+ "not be saved until the 'Save Level' button at the top is clicked.");
		*/				
		return true;
	}
	
	public boolean validateTextFields() {
		try {
			mode = (String) panel.getComboBox().getSelectedItem();
			levelName = panel.getLevelNameTextField().getText();
			
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
			displayErrorPopup("Invalid input. Please make sure that all text fields have an integer value.");
			return false;	
		}
		return true;
	}
	
	/**
	 * Validates the mode.
	 * @return true if valid.
	 * 
	 * @author Tom
	 */
	private boolean validateMode() {
		if (! (mode.equals("Puzzle") || mode.equals("Lightning") || mode.equals("Release") || mode.equals("Elimination")) ) {
			displayErrorPopup("Invalid mode.");
			return false;
		}
		return true;
	}
	
	/**
	 * Validates the move limit.
	 * @return true if valid.
	 * 
	 * @author Tom
	 */
	private boolean validateMoveLimit() {
		if (moveLimit <= 0) {
			displayErrorPopup("The number of moves must be greater than 0.");
			return false;
		}
		return true; 
	}
	
	/**
	 * Validates the multiplier probabilities.
	 * @return true if valid.
	 * 
	 * @author Tom
	 */
	private boolean validateMultiplierProbability() {
		int multiplierProbabilitySum = multiplierProbability1 + multiplierProbability2 + multiplierProbability3;
		if (multiplierProbabilitySum != 100) {
			displayErrorPopup("Multiplier probabilities must sum to 100.  Current sum is " + multiplierProbabilitySum + 
					", and " + (100 - multiplierProbabilitySum) + " more units are needed to equal 100.");
			return false;
		}
		
		if ((multiplierProbability1 < 0) || (multiplierProbability2 < 0) || (multiplierProbability1 < 0)) {
			displayErrorPopup("Multiplier probabilities must be positive values.");
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * Validates the special move counts.
	 * @return true if valid.
	 * 
	 * @author Tom
	 */
	private boolean validateSpecial() {
		if (rearrangeSpecial < 0 && swapSpecial < 0 && clearSpecial < 0) {
			displayErrorPopup("Special move counts must be greater than zero.");
			return false;
		}
		return true;
	}
	
	
	/**
	 * Validates the star milestone requirements.
	 * @return true if valid.
	 * 
	 * @author Tom
	 */
	private boolean validateStarMilestones() {
		if ( !(starLevel3 > starLevel2 && starLevel2 > starLevel1) ) {
			displayErrorPopup("Star milestone requirements must be increasing.");
			return false;
		}
		
		if ( starLevel1 <= 0 || starLevel2 <= 0 || starLevel3 <= 0) {
			displayErrorPopup("Star milestone requirements must be positive values.");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Validates the tile probabilities.
	 * @return true if valid.
	 * 
	 * @author Tom
	 */
	private boolean validateTileProbability() {
		int tileProbabilitySum = tileProbability1 + tileProbability2 + tileProbability3 + tileProbability4 + tileProbability5 + tileProbability6;
		
		if (tileProbabilitySum != 100) {
			displayErrorPopup("Tile probabilities must sum to 100.  Current sum is " + tileProbabilitySum + 
					", and " + (100 - tileProbabilitySum) + " more units are needed to equal 100.");
			return false;
		}
		
		if ( tileProbability1 < 0 || tileProbability2 < 0 || tileProbability3 < 0 || tileProbability3 < 0 ||
				tileProbability4 < 0 || tileProbability5 < 0 || tileProbability6 < 0) {
			displayErrorPopup("Tile probabilities must be positive values.");
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * Displays a popup error message with the specified String.
	 * @param s the string to be included in the error window popup.
	 */
	public void displayErrorPopup(String s) {
		JOptionPane.showMessageDialog(app, s + "\n\nYour changes have not been applied.", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
