package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.Application;
import view.MainMenuView;
import model.Achievement;

public class ResetAchievementsController implements MouseListener {
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

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
