package controllerPackage;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import boundaryPackage.BoardPanel;
import boundaryPackage.LevelBuilderApplication;
import entityPackage.LevelModel;

/**
 * Controller that handles clicks on the board's tiles.
 * 
 * @author Tom & Dabai
 */
public class TileController extends MouseAdapter {
	/** A reference to the model. */
	LevelModel model;
	
	/** A reference to the parent panel. */
	BoardPanel panel;
	
	/** A reference to the tile label that was clicked on.  The tiles are represented as JLabels. */
	JLabel label;
	
	/**
	 * Constructor for a tile controllers.  Manages mouse clicks on a tile, which is represented as a JLabel.
	 * 
	 * @param model a reference to the model.
	 * @param panel a reference to the parent panel.
	 * @param label a reference to the JLabel that was clicked on.  Tiles are represented as JLabels.
	 */
	public TileController(LevelModel model, BoardPanel panel, JLabel label) { 		//, LevelBuilderApplication app) {
		this.model = model;
		this.panel = panel;
		this.label = label;
	}
	
	/**
	* Whenever mouse is pressed (left button) on a Tile (represented by a JLabel which is located on the BoardPanel),
	* set the currently selected tile (via model.setSelectedTile() )
	* and make any necessary modifications to the tile (via model.modifyTile() )
	* 
	* @param me the mouse event, a left click
	* 
	* @author Tom
	*/
	@Override
	public void mousePressed(MouseEvent me) {
		Point point = panel.contains(label);
		
		if (point != null) {
			System.out.println("TileController::Clicked on label: " + label.getName());
			model.setSelectedTile(point.x, point.y);
			//model.modifyTile(point.x, point.y);
			model.addMove(point.x, point.y);
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
