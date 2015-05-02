package boundaryPackage;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

import controllerPackage.QuitButtonController;
import controllerPackage.SaveLevelButtonController;
import entityPackage.LevelModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelEditorPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private LevelBuilderApplication parentApplication;
	LevelModel model;
	
	public LevelBuilderApplication getParentApplication() {
		return parentApplication;
	}

	public LevelEditorPanel(LevelBuilderApplication parent, LevelModel model) {
		this.parentApplication = parent;
		this.model = model;
		
		setBackground(Color.LIGHT_GRAY);
		
		// Being more explicit in setting the size, by using setSize().
		// If you use setPreferredSize(), then you must setBounds() and call pack() in the LevelBuilderApplication 
		//this.setPreferredSize(new Dimension(1024, 768));
		this.setSize(1024, 768);

		
		JPanel panel = new BoardPanel(model);
		panel.setPreferredSize(new Dimension(630,630));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_1 = new PalettePanel(this, model);
		panel_1.setBackground(Color.WHITE);
		//JButton btnQuit = new JButton(new ImageIcon(this.getClass().getResource("/Images/Number1.png")));
		JButton btnQuit = new JButton("Quit");
		
		btnQuit.addMouseListener(new QuitButtonController(model, parent));
		
		/*
		 * REMOVING OLD BUTTON MECHANISM
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LevelEditorPanel panel = (LevelEditorPanel) (((JButton) (e.getSource())).getParent());
				parentApplication.setCurrentView(new MenuPanel(panel.getParentApplication(), model), panel);
			}
		});
		*/
		
		JButton btnNewButton = new JButton("Save Level");
		btnNewButton.addActionListener(new SaveLevelButtonController(this, model));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 712, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		
		JPanel panel_2 = new PropertiesMenuPanel(model, parent);
		panel_2.setBackground(Color.WHITE);
		panel_2.setPreferredSize(new Dimension(250,650));
		scrollPane.setViewportView(panel_2);
		setLayout(groupLayout);
		
		panel.setVisible(true);
		panel_1.setVisible(true);

	}

	public void PaintComponent(Graphics g){
		super.paintComponent(g);
		
	}
}
