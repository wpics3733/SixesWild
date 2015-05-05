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

import controllerPackage.DeleteLevelButtonController;
import controllerPackage.QuitButtonController;
import controllerPackage.RedoButtonController;
import controllerPackage.SaveLevelButtonController;
import controllerPackage.UndoButtonController;
import entityPackage.LevelModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * LevelEditorPanel contains all the boundary objects used when editing a level.
 * @author Dean Kiourtsis
 *
 */
public class LevelEditorPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private LevelBuilderApplication parentApplication;
	LevelModel model;
	BoardPanel boardPanel;
	PalettePanel palettePanel;
	PropertiesMenuPanel propertiesMenuPanel;
	
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

		
		JPanel boardPanel = new BoardPanel(model);
		boardPanel.setPreferredSize(new Dimension(630,630));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel palettePanel = new PalettePanel(this, model);
		palettePanel.setBackground(Color.WHITE);
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
		
		JButton btnDeleteLevel = new JButton("Delete Level");
		btnDeleteLevel.addMouseListener(new DeleteLevelButtonController(model.getName(), model.isGeneratedByLevelModel(), parent));
		if (!model.isGeneratedByLevelModel()) {
			btnDeleteLevel.setEnabled(false);
		}
		
		JButton btnNewButton = new JButton("Save Level");
		btnNewButton.addActionListener(new SaveLevelButtonController(this, model));
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new RedoButtonController(this, model));
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new UndoButtonController(this, model));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(palettePanel, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 712, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnUndo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRedo)
							.addGap(18)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnDeleteLevel)
							.addGap(18)
							.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(palettePanel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteLevel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRedo)
						.addComponent(btnUndo))
					.addGap(18)
					.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		
		JPanel propertiesMenuPanel = new PropertiesMenuPanel(model, parent);
		propertiesMenuPanel.setBackground(Color.WHITE);
		propertiesMenuPanel.setPreferredSize(new Dimension(250,650));
		scrollPane.setViewportView(propertiesMenuPanel);
		setLayout(groupLayout);
		
		boardPanel.setVisible(true);
		palettePanel.setVisible(true);
		
		this.boardPanel = (BoardPanel) boardPanel;
		this.palettePanel = (PalettePanel) palettePanel;
		this.propertiesMenuPanel = (PropertiesMenuPanel) propertiesMenuPanel;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}

	/**
	 * @return BoardPanel
	 */
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	/**
	 * @return PalettePanel
	 */
	public PalettePanel getPalettePanel() {
		return palettePanel;
	}

	/**
	 * @return PropertiesMenuPanel
	 */
	public PropertiesMenuPanel getPropertiesMenuPanel() {
		return propertiesMenuPanel;
	}
	
	
	
}
