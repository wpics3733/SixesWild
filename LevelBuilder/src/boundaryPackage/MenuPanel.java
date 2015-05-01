package boundaryPackage;
import javax.swing.*;

import controllerPackage.NewLevelButtonController;
import entityPackage.LevelModel;
import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.LevelEditorPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//test

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//JFrame menuFrame;
	
	JButton previousButton;
	JButton nextButton;
	JButton newLevelButton;
	private LevelBuilderApplication parentApplication;
	LevelModel model;
	
	//LevelItems levelItems				don't need for GUI demo?
	//JButton quitButton				don't need?  can just exit app via "X" (upper right corner)
	//LevelItemPanel levelItemsView		don't need for GUI demo?
	
	public LevelBuilderApplication getParentApplication() {
		return parentApplication;
	}


	// TODO WARNING model should not be final!!!!!
	public MenuPanel(LevelBuilderApplication parent, final LevelModel model) { // The constructor should also take in a "LevelModel" object as an argument, but omitted for GUI demo
		// menuFrame - This is only here so that I could run the MenuPanel on its own.
		// It should really go into the LevelEditorApplicationPanel class (see the UML diagram).
		/*
		menuFrame = new JFrame("Menu");
		menuFrame.setSize(1024, 768);
		menuFrame.setLocation(300,200);
		menuFrame.getContentPane().setLayout(null);
		*/
		
		
		parentApplication = parent;
		this.model = model;

		 
		// menuPanel
		this.setSize(1024, 768);
		this.setBounds(10, 11, 988, 483);
		//menuFrame.getContentPane().add(menuPanel);
		this.setLayout(null);
		 
		// lblNoBuiltLevels - Informs the user that no levels were found (on disk, etc.) so they can only create new levels
		JLabel lblNoBuiltLevels = new JLabel("No built levels found.  Create a new level!");
		lblNoBuiltLevels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoBuiltLevels.setBounds(284, 300, 382, 86);
		this.add(lblNoBuiltLevels);
		  
		// previousButton
		previousButton = new JButton("<");
		previousButton.setEnabled(false);
		previousButton.setToolTipText("Previous");
		previousButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		previousButton.setBounds(38, 316, 75, 75);
		this.add(previousButton);
		  
		// nextButton
		nextButton = new JButton(">");
		nextButton.setEnabled(false);
		nextButton.setToolTipText("Next");
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		nextButton.setBounds(875, 316, 75, 75);
		this.add(nextButton);
		 
		// newLevelButton
		newLevelButton = new JButton("+ New Level");
		newLevelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		newLevelButton.setBounds(841, 11, 137, 37);
		
		this.add(newLevelButton);
		
		this.repaint();

		newLevelButton.addMouseListener(new NewLevelButtonController(parent, model));
	}
	
	
	// This getter method is not needed for the GUI demo, but should be implemented in the future
	/*
	LevelItemPanel getLevelItemsView() {
		return levelItemsView;
	}
	*/
	
	public void PaintComponent(Graphics g){
		super.paintComponent(g);
		
	}


	public JButton getNewLevelButton() {
		return newLevelButton;
	}
	
	
	
	
	
}
