package sixesWild.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PastLevelPanel extends JPanel{
	
	public PastLevelPanel() {
		
//		Main panel
		super(new BorderLayout(0,0));
		this.setBackground(new Color(249,246,242));
		this.setPreferredSize(new Dimension(1024, 768));
		
//		Menubar
		JPanel menuBar= new JPanel(new FlowLayout(FlowLayout.LEFT,23,12));
		menuBar.setPreferredSize(new Dimension(1024, 58));
		menuBar.setBackground(new Color(112,147,113));
		
		JLabel titleLabel = new JLabel("Levels");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("AvenirNext,", Font.PLAIN, 24));
		
		menuBar.add(new JButton("←"));
		menuBar.add(titleLabel);
		
//		Main content
		JPanel mainContent = new JPanel(new BorderLayout());
		
//		Last page button
		JButton lastPageButton = new JButton("←");
		lastPageButton.setPreferredSize(new Dimension(80, 80));
		JPanel lastPagePanel = new JPanel(new FlowLayout());
		lastPagePanel.add(lastPageButton);
		
//		Next page button
		JButton nextPageButton = new JButton("➝");
		nextPageButton.setPreferredSize(new Dimension(80, 80));
		JPanel nextPagePanel = new JPanel(new FlowLayout());
		nextPagePanel.add(nextPageButton);
		
//		Add button into panel
		mainContent.add(lastPagePanel, BorderLayout.WEST);
		mainContent.add(nextPagePanel, BorderLayout.EAST);
		
//		Level button grid
		JPanel levelGrid = new JPanel(new GridLayout(3,5,5,5));
		
		JButton levelOneButton = new JButton("1");
		levelOneButton.setPreferredSize(new Dimension(80, 80));
		levelOneButton.setBackground(Color.BLACK);
		levelGrid.add(levelOneButton);
		
		for(int i=0; i<15; i++) {
			JButton levelButton = new JButton("Locked");
			levelButton.setPreferredSize(new Dimension(80, 80));
			levelButton.setEnabled(false);
			levelGrid.add(levelButton);
		}
		
		JPanel gridContainer = new JPanel(new FlowLayout());
		gridContainer.add(levelGrid);
		
		mainContent.add(gridContainer, BorderLayout.CENTER);
		
//		Level introduction
		JPanel introductionBar= new JPanel();
		introductionBar.setLayout(new BoxLayout(introductionBar, BoxLayout.X_AXIS));
		introductionBar.setPreferredSize(new Dimension(1024, 155));
		introductionBar.setBackground(new Color(90,127,92));
		
		JLabel levelNameLabel = new JLabel("Level 1");
		levelNameLabel.setForeground(Color.WHITE);
		levelNameLabel.setFont(new Font("AvenirNext,", Font.PLAIN, 36));
		
		JLabel levelTypeLabel = new JLabel("Puzzle");
		levelTypeLabel.setForeground(Color.WHITE);
		levelTypeLabel.setFont(new Font("AvenirNext,", Font.PLAIN, 24));
		
		JPanel levelTypePanel= new JPanel();
		levelTypePanel.setLayout(new BoxLayout(levelTypePanel, BoxLayout.Y_AXIS));
		levelTypePanel.add(levelNameLabel);
		levelTypePanel.add(levelTypeLabel);
		levelTypePanel.setOpaque(false);
		levelTypePanel.setBorder(new EmptyBorder(0, 36, 0, 24) );
		
		introductionBar.add(levelTypePanel);
		
		
		
		JLabel levelRuleLabel = new JLabel("<html><ul><li>Each move removes squares from grid</li><li>Contents repopulated by shifting downward to fill in holes, with new squares appearing at top</ul></html>");
		levelRuleLabel.setForeground(Color.WHITE);
		levelRuleLabel.setFont(new Font("AvenirNext,", Font.PLAIN, 20));
		
		introductionBar.add(levelRuleLabel);
		
		
		JButton startLevelButton = new JButton("Start level");
		introductionBar.add(startLevelButton);
		
		this.add(menuBar,BorderLayout.NORTH);
		this.add(mainContent,BorderLayout.CENTER);
		this.add(introductionBar,BorderLayout.SOUTH);
	}
}
