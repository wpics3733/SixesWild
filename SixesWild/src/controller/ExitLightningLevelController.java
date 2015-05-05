package controller;

import java.awt.event.MouseEvent;

import model.LightningLevel;
import view.Application;

public class ExitLightningLevelController extends ReturnToMenuController {
	LightningLevel l;
	
	public ExitLightningLevelController(LightningLevel l, Application a) {
		super(a);
		this.l = l;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		l.getTimer().cancel();
		super.mouseClicked(arg0);
	}
	

}
