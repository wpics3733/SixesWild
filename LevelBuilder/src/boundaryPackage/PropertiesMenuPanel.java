package boundaryPackage;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controllerPackage.PropertiesMenuPanelController;
import entityPackage.LevelModel;

/**
 * Create the properties panel for the level builder
 * 
 * @author Dean, Tom, Dabai
 */
public class PropertiesMenuPanel extends JPanel {
	
	/** Header label for the level types. */
	private JLabel lblLevelType;
	
	/** Drop down box for the available level types. */
	private JComboBox<String> comboBox;
	
	/** Header label for special moves. */
	private JLabel lblOfSpecial;
	
	/** Header label for the rearrange special move. */
	private JLabel rearrangeSpecialLabel;
	
	/** Header label for the swap special move. */
	private JLabel swapSpecialLabel;
	
	/** Header label for the clear special move. */
	private JLabel clearSpeicalLabel;
	
	/** Text field for the rearrange special move. */
	private JTextField rearrangeSpecialTextField;
	
	/** Text field for the swap special move. */
	private JTextField swapSpecialTextField;
	
	/** Text field for the clear special move. */
	private JTextField clearSpecialTextField;
	
	/** Header label for the tile appearance probabilities. */
	private JLabel lblTileAppearenceProbabilities;
	
	/** Header label for the 1 tile probability appearance. */ 
	private JLabel label;
	
	/** Text field for the 1 tile probability appearance. */ 
	private JTextField tileProbabilityTextField1;
	
	/** Header label for the 2 tile probability appearance. */ 
	private JLabel label_1;
	
	/** Text field for the 2 tile probability appearance. */ 
	private JTextField tileProbabilityTextField2;
	
	/** Header label for the 3 tile probability appearance. */ 
	private JLabel label_2;
	
	/** Text field for the 3 tile probability appearance. */ 
	private JTextField tileProbabilityTextField3;
	
	/** Header label for the 4 tile probability appearance. */ 
	private JLabel label_3;
	
	/** Text field for the 4 tile probability appearance. */ 
	private JTextField tileProbabilityTextField4;
	
	/** Header label for the 5 tile probability appearance. */ 
	private JLabel label_4;
	
	/** Text field for the 5 tile probability appearance. */ 
	private JTextField tileProbabilityTextField5;
	
	/** Header label for the 6 tile probability appearance. */ 
	private JLabel label_5;
	
	/** Text field for the 6 tile probability appearance. */ 
	private JTextField tileProbabilityTextField6;
	
	/** Header label for the tile multiplier probabilities. */
	private JLabel lblMultiplierAppearenceProbabilities;
	
	/** Header label for the 1 tile multiplier appearance. */ 
	private JLabel label_6;
	
	/** Text field for the 1 tile multiplier probability. */
	private JTextField multiplierProbability1;
	
	/** Header label for the 2 tile multiplier appearance. */ 
	private JLabel label_7;
	
	/** Text field for the 2 tile multiplier probability. */
	private JTextField multiplierProbability2;
	
	/** Header label for the 3 tile multiplier appearance. */ 
	private JLabel label_8;
	
	/** Text field for the 3 tile multiplier probability. */
	private JTextField multiplierProbability3;
	
	/** Header label for the number of moves allowed. */
	private JLabel lblMoveLimit;
	
	/** Text field for the number of moves allowed. */
	private JTextField moveLimitTextField;
	
	/** Header label for the time allowed for a given level. */
	private JLabel lblTimeLimit;
	
	/** Text field for for the time allowed for a given level. */
	private JTextField timeLimitTextField;
	
	/** Header label for the star milestones. */
	private JLabel lblStarLevels;
	
	/** Header label for the 1 star milestone. */
	private JLabel lblOneStar;
	
	/** Text field for the 1 star milestone. */
	private JTextField starLevelTextField1;
	
	/** Header label for the 2 star milestone. */
	private JLabel lblTwoStars;
	
	/** Text field for the 2 star milestone. */
	private JTextField starLevelTextField2;
	
	/** Header label for the 3 star milestone. */
	private JLabel lblThreeStars;
	
	/** Text field for the 3 star milestone. */
	private JTextField starLevelTextField3;
	
	/** Header label for the level name. */
	private JLabel levelNameLabel;
	
	/** Text field for the level name. */
	private JTextField levelNameText;
	
	/** A button to apply the changes made within the properties panel. */
	private JButton btnApply;

	/** A reference to the application. */
	LevelBuilderApplication app;
	
	/** A reference to the application's model. */
	LevelModel model;
	
	/**
	 * Constructor for the PropertiesMenuPanel.  Create the panel and initializes text fields with data from the model.
	 * 
	 * @author Tom, Dean, Dabai
	 */
	public PropertiesMenuPanel(LevelModel model, LevelBuilderApplication app) {
		this.model = model;
		this.app = app;
		
		
		lblLevelType = new JLabel("Level Type");
		lblLevelType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		String[] levelTypes = {"Puzzle","Lightning","Release", "Elimination"}; 
		
		comboBox = new JComboBox<String>(levelTypes);
		comboBox.setSelectedItem(model.getMode());
		
		lblOfSpecial = new JLabel("# of Special Moves");
		lblOfSpecial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		rearrangeSpecialLabel = new JLabel("Rearrange:");
		
		swapSpecialLabel = new JLabel("Swap:");
		
		clearSpeicalLabel = new JLabel("Clear:");
		
		rearrangeSpecialTextField = new JTextField();
		rearrangeSpecialTextField.setText( ((Integer) model.getSpecialMovesAllowed()[0]).toString());
		rearrangeSpecialTextField.setColumns(10);
		
		swapSpecialTextField = new JTextField();
		swapSpecialTextField.setText(((Integer) model.getSpecialMovesAllowed()[1]).toString());
		swapSpecialTextField.setColumns(10);
		
		clearSpecialTextField = new JTextField();
		clearSpecialTextField.setText(((Integer) model.getSpecialMovesAllowed()[2]).toString());
		clearSpecialTextField.setColumns(10);
		
		lblTileAppearenceProbabilities = new JLabel("Tile Appearence Probabilities");
		lblTileAppearenceProbabilities.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		label = new JLabel("1:");
		
		tileProbabilityTextField1 = new JTextField();
		tileProbabilityTextField1.setText( ((Integer) model.getTileProbabilities()[0]).toString() );
		tileProbabilityTextField1.setColumns(10);
		
		label_1 = new JLabel("2:");
		
		tileProbabilityTextField2 = new JTextField();
		tileProbabilityTextField2.setText( ((Integer) model.getTileProbabilities()[1]).toString() );
		tileProbabilityTextField2.setColumns(10);
		
		label_2 = new JLabel("3:");
		
		tileProbabilityTextField3 = new JTextField();
		tileProbabilityTextField3.setText( ((Integer) model.getTileProbabilities()[2]).toString() );
		tileProbabilityTextField3.setColumns(10);
		
		label_3 = new JLabel("4:");
		
		tileProbabilityTextField4 = new JTextField();
		tileProbabilityTextField4.setText( ((Integer) model.getTileProbabilities()[3]).toString() );
		tileProbabilityTextField4.setColumns(10);
		
		label_4 = new JLabel("5:");
		
		tileProbabilityTextField5 = new JTextField();
		tileProbabilityTextField5.setText( ((Integer) model.getTileProbabilities()[4]).toString() );
		tileProbabilityTextField5.setColumns(10);
		
		label_5 = new JLabel("6:");
		
		tileProbabilityTextField6 = new JTextField();
		tileProbabilityTextField6.setText( ((Integer) model.getTileProbabilities()[5]).toString() );
		tileProbabilityTextField6.setColumns(10);
		
		lblMultiplierAppearenceProbabilities = new JLabel("Multiplier Probabilities");
		lblMultiplierAppearenceProbabilities.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		label_6 = new JLabel("1:");
		
		multiplierProbability1 = new JTextField();
		multiplierProbability1.setText( ((Integer) model.getMultiplierProbabilities()[0]).toString() );
		multiplierProbability1.setColumns(10);
		
		label_7 = new JLabel("2:");
		
		multiplierProbability2 = new JTextField();
		multiplierProbability2.setText( ((Integer) model.getMultiplierProbabilities()[1]).toString() );
		multiplierProbability2.setColumns(10);
		
		label_8 = new JLabel("3:");
		
		multiplierProbability3 = new JTextField();
		multiplierProbability3.setText( ((Integer) model.getMultiplierProbabilities()[2]).toString() );
		multiplierProbability3.setColumns(10);
		
		lblMoveLimit = new JLabel("Move Limit");
		lblMoveLimit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		moveLimitTextField = new JTextField();
		moveLimitTextField.setText( ((Integer) model.getMovesAllowed()).toString() );
		moveLimitTextField.setColumns(10);
		
		lblTimeLimit = new JLabel("Time Limit (seconds)");
		lblTimeLimit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		timeLimitTextField = new JTextField();
		timeLimitTextField.setText( ((Integer) model.getTimeAllowed()).toString() );
		timeLimitTextField.setColumns(10);
		
		lblStarLevels = new JLabel("Star Levels (points)");
		lblStarLevels.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblOneStar = new JLabel("One star:");
		
		starLevelTextField1 = new JTextField();
		starLevelTextField1.setText( ((Integer) model.getStarMilestones()[0]).toString() );
		starLevelTextField1.setColumns(10);
		
		lblTwoStars = new JLabel("Two stars:");
		
		starLevelTextField2 = new JTextField();
		starLevelTextField2.setText( ((Integer) model.getStarMilestones()[1]).toString() );
		starLevelTextField2.setColumns(10);
		
		lblThreeStars = new JLabel("Three stars:");
		
		starLevelTextField3 = new JTextField();
		starLevelTextField3.setText( ((Integer) model.getStarMilestones()[2]).toString() );
		starLevelTextField3.setColumns(10);
		
		btnApply = new JButton("Apply");
		btnApply.addMouseListener(new PropertiesMenuPanelController(model, app, this));
		
		levelNameLabel = new JLabel("Level Name:");
		
		levelNameText = new JTextField();
		levelNameText.setText(model.getName());
		levelNameText.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(timeLimitTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStarLevels, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblOneStar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTwoStars, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblThreeStars, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(starLevelTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(starLevelTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(starLevelTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(91))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTileAppearenceProbabilities, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tileProbabilityTextField4, 0, 0, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tileProbabilityTextField1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tileProbabilityTextField2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tileProbabilityTextField5, 0, 0, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tileProbabilityTextField3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tileProbabilityTextField6, 0, 0, Short.MAX_VALUE))))
								.addComponent(lblOfSpecial, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
								.addComponent(lblMultiplierAppearenceProbabilities, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
								.addComponent(lblLevelType, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(multiplierProbability1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(multiplierProbability2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(multiplierProbability3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblMoveLimit, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
								.addComponent(moveLimitTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTimeLimit, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(clearSpeicalLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(swapSpecialLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(rearrangeSpecialLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(swapSpecialTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(rearrangeSpecialTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(clearSpecialTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(46)))
							.addGap(109))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelNameLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(levelNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(291, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnApply)
							.addContainerGap(381, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLevelType)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblOfSpecial, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rearrangeSpecialLabel)
						.addComponent(rearrangeSpecialTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(swapSpecialLabel)
						.addComponent(swapSpecialTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(clearSpeicalLabel)
						.addComponent(clearSpecialTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblTileAppearenceProbabilities, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(tileProbabilityTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(tileProbabilityTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(tileProbabilityTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(tileProbabilityTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_3)
							.addComponent(label_4))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(tileProbabilityTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_5)
							.addComponent(tileProbabilityTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblMultiplierAppearenceProbabilities, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(multiplierProbability1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(multiplierProbability2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(multiplierProbability3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblMoveLimit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(moveLimitTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTimeLimit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timeLimitTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblStarLevels, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOneStar)
						.addComponent(starLevelTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTwoStars)
						.addComponent(starLevelTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblThreeStars)
						.addComponent(starLevelTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(levelNameLabel)
						.addComponent(levelNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnApply)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	// Getters
	
	public JComboBox<String> getComboBox(){
		return comboBox;
	}

	public JTextField getClearSpecialTextField() {
		return clearSpecialTextField;
	}

	public void setClearSpecialTextField(JTextField clearSpecialTextField) {
		this.clearSpecialTextField = clearSpecialTextField;
	}

	public JTextField getRearrangeSpecialTextField() {
		return rearrangeSpecialTextField;
	}

	public JTextField getSwapSpecialTextField() {
		return swapSpecialTextField;
	}

	public JTextField getTileProbabilityTextField1() {
		return tileProbabilityTextField1;
	}

	public JTextField getTileProbabilityTextField2() {
		return tileProbabilityTextField2;
	}

	public JTextField getTileProbabilityTextField3() {
		return tileProbabilityTextField3;
	}

	public JTextField getTileProbabilityTextField4() {
		return tileProbabilityTextField4;
	}

	public JTextField getTileProbabilityTextField5() {
		return tileProbabilityTextField5;
	}

	public JTextField getTileProbabilityTextField6() {
		return tileProbabilityTextField6;
	}

	public JTextField getMultiplierProbability1() {
		return multiplierProbability1;
	}

	public JTextField getMultiplierProbability2() {
		return multiplierProbability2;
	}

	public JTextField getMultiplierProbability3() {
		return multiplierProbability3;
	}

	public JTextField getMoveLimitTextField() {
		return moveLimitTextField;
	}

	public JTextField getTimeLimitTextField() {
		return timeLimitTextField;
	}

	public JTextField getStarLevelTextField1() {
		return starLevelTextField1;
	}

	public JTextField getStarLevelTextField2() {
		return starLevelTextField2;
	}

	public JTextField getStarLevelTextField3() {
		return starLevelTextField3;
	}
	
	public JTextField getLevelNameTextField(){
		return levelNameText;
	}

	public JButton getBtnApply() {
		return btnApply;
	}

	
	/**
	 * Required for Java Swing functionality.
	 * 
	 * @param g
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
}
