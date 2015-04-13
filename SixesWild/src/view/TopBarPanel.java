package view;

import model.Level;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TopBarPanel extends JPanel {
	private JButton clear;
	private JButton swap;
	private JButton quit;
	private JButton rearrange;
	private JLabel score;
	
	public TopBarPanel(Level l) {
		
		clear = new JButton("Clear");
		swap = new JButton("Swap");
		rearrange = new JButton("Rearrange");
		
		quit = new JButton("Quit");
		score = new JLabel("Score: " + 20);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(quit)
							.addComponent(score)
							.addPreferredGap(ComponentPlacement.RELATED, 1444, Short.MAX_VALUE)
							.addComponent(rearrange)
							.addComponent(swap)
							.addComponent(clear))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rearrange)
						.addComponent(swap)
						.addComponent(score)
						.addComponent(clear)
						.addComponent(quit)))
		);
		setLayout(groupLayout);

	}
}