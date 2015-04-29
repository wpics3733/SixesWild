package controllerPackage;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import boundaryPackage.PalettePanel;
import entityPackage.LevelModel;

public class PaletteController extends MouseAdapter{
	LevelModel model;
	PalettePanel panel;
	JLabel label;

	public PaletteController(LevelModel model, PalettePanel panel, JLabel label) { 		// LevelBuilderApplication app)
		this.model = model;
		this.panel = panel;
		this.label = label;
	}
	@Override
	public void mousePressed(MouseEvent me) {
//		Point point = panel.contains(label);
//		
//		if (point != null) {
//			System.out.println("Clicked on label: " + label.getName());
//			model.setSelectedTile(point.x, point.y);
//			panel.redraw();
//		}
//		else {
//			System.out.println("NO IT DID NOT WORK.");
//		}
		return;
		
	}
}
