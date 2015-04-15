package view;


import java.awt.BorderLayout;

import javax.swing.*;

import model.Level;


public class GameApplication {
	MainMenuView mv;
	LevelView lv;
	Level l;
	JFrame frame;
	
	static final long serialVersionUID = 1;

	JPanel contentPane;
	
	public GameApplication(Level l) {
		super();
		this.l = l;
		this.mv = new MainMenuView();
		this.lv = new LevelView(l);
		this.frame = new JFrame();
		this.contentPane = new JPanel();

		initialize();
	}
	
	void initialize() {
		frame.setTitle("Ready?");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(0, 0, 800, 600);
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(mv);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}

