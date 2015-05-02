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
	 * Whenever mouse is pressed (left button) on a Tile (which is located on the BoardPanel),
	 * set the currently selected tile (via model.setSelectedTile() )
	 * and make any necessary modifications to the tile (via model.modifyTile() )
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		Point point = panel.contains(label);
		
		if (point != null) {
			System.out.println("TileController::Clicked on label: " + label.getName());
			model.setSelectedTile(point.x, point.y);
			model.modifyTile(point.x, point.y);
			/*
			System.out.println("TileController::Tile (" + point.y + ", " + point.x + ") multiplier is currently set to: " +
					model.getBoard()[point.x][point.y].getMultiplier());
			*/
			panel.repaint();
		}
		else {
			System.out.println("TileController::The JLabel which was clicked on could not be found within the BoardPanel.");
		}
		
	}
}
