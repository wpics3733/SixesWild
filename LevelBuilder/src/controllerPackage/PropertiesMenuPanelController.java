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
		
		/*
		// Validate the user input first, and return if something is invalid
		if (!validate()) {
			return;
		}
		*/
		validate();
		
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

	}
	
	/** 
	 * Validates all of the user input for the PropertiesMenuPanel.
	 * 
	 * @author Tom Finelli
	 * @return
	 */
	public boolean validate() {
		
		
		return validateStarMilestones();
	}
	
	private boolean validateStarMilestones() {
		int starLevel1 = Integer.parseInt(panel.getStarLevelTextField1().getText());
		int starLevel2 = Integer.parseInt(panel.getStarLevelTextField2().getText());
		int starLevel3 = Integer.parseInt(panel.getStarLevelTextField3().getText());
		
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
