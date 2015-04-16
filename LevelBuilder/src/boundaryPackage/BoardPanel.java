package boundaryPackage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;

public class BoardPanel extends JPanel {

	private JButton tileButtons[][];
	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(9, 9, 0, 0));
		ImageIcon myIcon = new ImageIcon(this.getClass().getResource("/Images/Number3.png"));
		//JButton btnNewButton_1 = new JButton("New button");
		//btnNewButton_1.setIcon(myIcon);
		//add(btnNewButton_1);
		
		tileButtons = new JButton[9][9];
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				JLabel label_1Tile = new JLabel(myIcon);
				//JButton btnNewButton = new JButton(myIcon);
				//btnNewButton.setIcon(myIcon);
				//add(btnNewButton);
				add(label_1Tile);
				//tileButtons[i][j] = btnNewButton;
			}
		}
		

	}

	public void PaintComponent(Graphics g){
		super.paintComponent(g);
		
	}
	
}
