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

/**
 * The main menu for the application.
 * 
 * @author Tom, Dean
 */

public class MenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/** Button which allows the user to create a new level. */
	JButton newLevelButton;
	
	/** Button which allows the user to exit the application. */
	JButton quitButton;
	
	/** A reference to the application */
	protected LevelBuilderApplication parentApplication;
	
	/** A reference to the application's model. */
	LevelModel model;
	//JButton previousButton;
	//JButton nextButton;
	
	
	/** 
	 * Constructor for a MenuPanel.  Maintains a reference to the application and the model.
	 * 
	 * @param parent a reference to the application, which is the parent to this panel
	 * @param model a reference to the model
	 * 
	 * @author Tom, Dean
	 */
	public MenuPanel(LevelBuilderApplication parent, LevelModel model) {
		this.parentApplication = parent;
		this.model = model;
		
		this.setSize(1024, 768);;
		this.setLayout(new BorderLayout());
		
		JPanel topButtonPanel = new JPanel();
		topButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 
		// newLevelButton
		newLevelButton = new JButton("+ New Level");
		newLevelButton.addMouseListener(new NewLevelButtonController(parent, model));
		topButtonPanel.add(newLevelButton);
		
		// quitButton
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
	
	
	/**
	 * Required for Java Swing functionality.
	 * @param g
	 */
	public void PaintComponent(Graphics g){
		super.paintComponent(g);
	}

	
	// Getters

	public JButton getNewLevelButton() {
		return newLevelButton;
	}

	public LevelBuilderApplication getParentApplication() {
		return parentApplication;
	}
	
	
	
	
}
