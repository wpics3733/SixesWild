package controllerPackage;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import boundaryPackage.BoardPanel;
import boundaryPackage.LevelBuilderApplication;
import entityPackage.LevelModel;

public class TileController extends MouseAdapter {
	LevelModel model;
	//LevelBuilderApplication app;
	BoardPanel panel;
	JLabel label;
	
	public TileController(LevelModel model, BoardPanel panel, JLabel label) { 		//, LevelBuilderApplication app) {
		this.model = model;
		this.panel = panel;
		this.label = label;
		//this.app = app;
	}
	
	/**
	 * Whenever mouse is pressed (left button), set the current view to the MenuPanel.
	 * This is a GUI controller.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		Point point = panel.contains(label);
		
		if (point != null) {
			System.out.println("Clicked on label: " + label.getName());
			model.setSelectedTile(point.x, point.y);
			model.modifyTile(point.x, point.y);
			panel.repaint();
		}
		else {
			System.out.println("NO IT DID NOT WORK.");
		}
		
	}
}
