package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Level;

public class GameWestPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	
	JPanel star1, star2, star3;
	JProgressBar bar1, bar2, bar3;
	JButton restart;
	
	Level l;
	
	public GameWestPanel(Level l) {
		this.l = l;

		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		bar1.setValue(0);
		bar2.setValue(0);
		bar3.setValue(0);
		
		restart = new JButton("<html><center>Restart<br>Level<center></html>");

		bar1.setOrientation(SwingConstants.VERTICAL);
		bar2.setOrientation(SwingConstants.VERTICAL);
		bar3.setOrientation(SwingConstants.VERTICAL);

		JLabel threeStar = new JLabel("3 Stars");

		JLabel twoStar = new JLabel("2 Stars");

		JLabel oneStar = new JLabel("1 Star");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bar1, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bar2, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bar3, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(twoStar)
						.addComponent(threeStar)
						.addComponent(oneStar)
						.addComponent(restart)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(threeStar, Alignment.LEADING)
						.addComponent(bar3, 0, 1, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bar2, 0, 1, Short.MAX_VALUE)
						.addComponent(twoStar))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(oneStar)
						.addComponent(bar1, 0, 1, Short.MAX_VALUE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGap(0,0, Short.MAX_VALUE)
							.addComponent(restart))
		);
		setLayout(groupLayout);

	}
}
