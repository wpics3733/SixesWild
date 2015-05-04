package boundaryPackage;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controllerPackage.NewLevelButtonController;
import controllerPackage.QuitGameController;
import entityPackage.LevelModel;
import boundaryPackage.LevelBuilderApplication;
import boundaryPackage.LevelEditorPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
	JButton quitButton;
	protected LevelBuilderApplication parentApplication;
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
		//menuFrame.getContentPane().add(menuPanel);
		this.setLayout(new BorderLayout());
		
		JPanel topButtonPanel = new JPanel();
		topButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 
		// newLevelButton
		newLevelButton = new JButton("+ New Level");
		newLevelButton.addMouseListener(new NewLevelButtonController(parent, model));
		topButtonPanel.add(newLevelButton);
		
		quitButton = new JButton("Quit");
		quitButton.addMouseListener(new QuitGameController(parent));
		topButtonPanel.add(quitButton);

		this.add(topButtonPanel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(new EmptyBorder(100, 100, 100, 100));
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel levelsView = new LevelsPanel(this);
		scrollPane.setViewportView(levelsView);
		
		this.repaint();

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
