package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PlayPastLevelController;
import controller.ResetProgressController;
import controller.ReturnToMenuController;
import model.LevelState;
import model.EliminationLevel;
import model.Level;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;

/**
 * The panel that loads when the user clicks the "Levels" button in the main menu
 * It shows all levels, locked or unlocked, each unlocked level is a button that
 * takes you to that level when clicked
 * @author jesse
 *
 */
public class PastLevelPanel extends JPanel{
	ArrayList<Level> levels;
	Level selectedLevel;
	ArrayList<PastLevelButton> pastLevels;
	Application parent;

	public PastLevelPanel(Application parent) {
		super(new BorderLayout(0,0));
		this.parent = parent;
		this.levels = new ArrayList<Level>();

		try{
			File dir = new File("../LevelBuilder/Levels");
			File[] directoryListing = dir.listFiles();
			if(directoryListing != null){  // Use default level directory to create buttons
				for(File child : directoryListing){
					LevelState tmp = new LevelState();
					tmp.loadState(child.getName());
					String levelType = tmp.getLevelType();
					if(levelType != null){
						Level newLevel = null;
						if(levelType.equals("Puzzle")){
							newLevel = new PuzzleLevel(tmp);
						} else if(levelType.equals("Lightning")) {
							newLevel = new LightningLevel(tmp);
						} else if(levelType.equals("Release")) {
							newLevel = new ReleaseLevel(tmp);
						} else{
							newLevel = new EliminationLevel(tmp);
						}
						levels.add(newLevel);
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		//		Main panel
		this.setBackground(new Color(249,246,242));
		this.setPreferredSize(new Dimension(1024, 768));

		JPanel levelGrid = new JPanel(new GridLayout(4,4,4,4));
		int i;
		pastLevels = new ArrayList<PastLevelButton>();
		levels.get(0).getLevelState().setUnlocked(true);
		for(i = 0; i < levels.size(); i++) {
			PastLevelButton levelButton = new PastLevelButton(levels.get(i), i);
			if(levels.get(i).getLevelState().isUnlocked()) {
				if(i < levels.size() - 1) {
					levelButton.setController(new PlayPastLevelController(parent, levels.get(i), levels.get(i+1)));
				} else {
					levelButton.setController(new PlayPastLevelController(parent, levels.get(i), null));
				}
			}
			pastLevels.add(levelButton);
			levelGrid.add(levelButton);
		}

		for( i = i; i < 16; i++) {
			JButton levelButton = new JButton("");
			levelButton.setPreferredSize(new Dimension(180, 120));
			levelButton.setEnabled(false);
			levelGrid.add(levelButton);
		}


		//		Menubar
		JPanel menuBar= new JPanel(new FlowLayout(FlowLayout.LEFT,23,12));
		menuBar.setPreferredSize(new Dimension(1024, 58));
		menuBar.setBackground(new Color(112,147,113));

		JLabel titleLabel = new JLabel("Levels");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("AvenyyirNext,", Font.PLAIN, 24));

		JButton quit = new JButton("Quit");
		quit.addMouseListener(new ReturnToMenuController(parent));


		JButton reset = new JButton("Reset Progress");
		reset.addMouseListener(new ResetProgressController(levels, this, pastLevels));

		menuBar.add(quit);
		menuBar.add(reset);
		menuBar.add(titleLabel);

		//		Main content
		JPanel mainContent = new JPanel(new BorderLayout());


		//		Level button grid

		JPanel gridContainer = new JPanel(new FlowLayout());
		gridContainer.add(levelGrid);

		mainContent.add(gridContainer, BorderLayout.CENTER);

		//		Level introduction
		JPanel introductionBar= new JPanel();
		introductionBar.setLayout(new BoxLayout(introductionBar, BoxLayout.X_AXIS));
		introductionBar.setPreferredSize(new Dimension(1024, 155));
		introductionBar.setBackground(new Color(90,127,92));

		JLabel levelNameLabel = new JLabel("<html><center>Sixes<br>Wild</center></html>");
		levelNameLabel.setForeground(Color.WHITE);
		levelNameLabel.setFont(new Font("AvenirNext,", Font.PLAIN, 48));

		levelNameLabel.setBorder(new EmptyBorder(0, 36, 0, 0) );

		introductionBar.add(levelNameLabel);

		JLabel levelRuleLabel = new JLabel(
				"<html><ul>" +
						"<li>Puzzle: You have a given number of moves to achieve certain score</li>" +
						"<li>Elimination: Use every square on the board to win</li>" +
						"<li>Lightning: Get the highest score that you can in 60 seconds</li>" +
						"<li>Release: Fill all of the buckets with 6's</li>" +
				"</ul></html>");

		levelRuleLabel.setForeground(Color.WHITE);
		levelRuleLabel.setFont(new Font("AvenirNext,", Font.PLAIN, 20));

		introductionBar.add(levelRuleLabel);



		this.add(menuBar,BorderLayout.NORTH);
		this.add(mainContent,BorderLayout.CENTER);
		this.add(introductionBar,BorderLayout.SOUTH);
	}
}
