package boundaryPackage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;

import controllerPackage.TileModifierController;
import entityPackage.LevelModel;
import entityPackage.MultiplierModifier;
import entityPackage.ValueModifier;

/** 
 * Create the palette panel for level builder
 * 
 * @author Dean & Dabai
 */
public class PalettePanel extends JPanel {

	/** A reference to the parent panel*/
	LevelEditorPanel lep;
	
	/** A reference to the application's model */
	LevelModel lm;
	
	/**
	 * Constructor for a PalettePanel.
	 * @param lep a reference to the level editor panel, which is the parent panel
	 * @param lm a reference to the application's model
	 */
	public PalettePanel(LevelEditorPanel lep, LevelModel lm) {
		this.lep = lep;
		this.lm = lm;
		this.setBackground(Color.GRAY);
		
		JLabel lblNewLabel = new JLabel("Tile Modifiers");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_1Tile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Number1.png")));
		JLabel label_2Tile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Number2.png")));
		JLabel label_3Tile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Number3.png")));
		JLabel label_4Tile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Number4.png")));
		JLabel label_5Tile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Number5.png")));
		JLabel label_6Tile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Number6.png")));
		JLabel label_1Mult = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Mult1.png")));
		JLabel label_2Mult = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Mult2.png")));
		JLabel label_3Mult = new JLabel(new ImageIcon(this.getClass().getResource("/Images/Mult3.png")));
		JLabel label_BlockedTile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/BlockedTile.png")));
		JLabel label_RandomTile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/UnmodifiedTile.png")));
		JLabel label_BucketTile = new JLabel(new ImageIcon(this.getClass().getResource("/Images/BucketTile.png")));
		
		label_1Tile.addMouseListener(new TileModifierController(lm,new ValueModifier(1),this));
		label_2Tile.addMouseListener(new TileModifierController(lm,new ValueModifier(2),this));
		label_3Tile.addMouseListener(new TileModifierController(lm,new ValueModifier(3),this));
		label_4Tile.addMouseListener(new TileModifierController(lm,new ValueModifier(4),this));
		label_5Tile.addMouseListener(new TileModifierController(lm,new ValueModifier(5),this));
		label_6Tile.addMouseListener(new TileModifierController(lm,new ValueModifier(6),this));
		label_1Mult.addMouseListener(new TileModifierController(lm,new MultiplierModifier(1),this));
		label_2Mult.addMouseListener(new TileModifierController(lm,new MultiplierModifier(2),this));
		label_3Mult.addMouseListener(new TileModifierController(lm,new MultiplierModifier(3),this));
		label_BlockedTile.addMouseListener(new TileModifierController(lm,new ValueModifier(-1),this));
		label_RandomTile.addMouseListener(new TileModifierController(lm, new ValueModifier(0),this));
		label_BucketTile.addMouseListener(new TileModifierController(lm,new ValueModifier(-2),this));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1Tile)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_2Tile)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3Tile))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4Tile, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1Mult))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2Mult)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_3Mult))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_5Tile)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_6Tile))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_BlockedTile)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_RandomTile)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_BucketTile)))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3Tile)
						.addComponent(label_1Tile)
						.addComponent(label_2Tile))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4Tile, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5Tile)
						.addComponent(label_6Tile))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2Mult)
						.addComponent(label_1Mult)
						.addComponent(label_3Mult))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_BlockedTile)
						.addComponent(label_RandomTile)
						.addComponent(label_BucketTile))
					.addGap(95))
		);
		setLayout(groupLayout);

	}
}
