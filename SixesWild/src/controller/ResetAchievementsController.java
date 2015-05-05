package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.Application;
import view.MainMenuView;
import model.Achievement;

public class ResetAchievementsController extends MouseAdapter {
	Application parent;
	
	public ResetAchievementsController(Application parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (JOptionPane.showConfirmDialog(new JFrame(),
		        "Are you sure you want to reset the achievements?", "Reset All Achievements",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			File file = new File("achievements.sav");
			file.delete();
			Achievement.initializeAll();
			parent.changeView(new MainMenuView(parent));
		}
	}
}
