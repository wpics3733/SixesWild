package controller;

import java.awt.event.MouseEvent;

import model.LightningLevel;
import view.Application;

/**
 * This is a custom controller for quitting out of lightning
 * levels, as doing so requires us to stop the timer for the level
 * Other than that, the functionality is identical
 * @author jesse
 *
 */
public class ExitLightningLevelController extends ReturnToMenuController {
	LightningLevel l;
	
	public ExitLightningLevelController(LightningLevel l, Application a) {
		super(a);
		this.l = l;
	}
	
	/**
	 * Cancel the Timer for the level and return to main menu
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		l.getTimer().cancel();
		super.mouseClicked(arg0);
	}
	

}
