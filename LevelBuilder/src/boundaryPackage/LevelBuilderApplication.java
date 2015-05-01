package boundaryPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import entityPackage.LevelModel;

//test
//import com.jgoodies.forms.layout.FormSpecs;

public class LevelBuilderApplication extends JFrame {

	private JPanel contentPane;
	private JPanel currentView;
	LevelModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderApplication frame = new LevelBuilderApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelBuilderApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setPreferredSize(new Dimension(1024,768));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Initialize model
		this.model = new LevelModel();
		
		setCurrentView(new SplashScreenPanel(this, model));
		//currentView = new MenuPanel(this);
		currentView.setBounds(0, 0, 1024, 768);
		this.add(currentView);
		
		
		this.pack();
	}
	
	/**
	 * Set the current view.
	 * NOTE:  THIS METHOD IS DEPRECIATED.  USE THE METHOD BELOW.
	 * @param newPanel
	 * @param oldPanel
	 * 
	 * @author Dean
	 */
	public void setCurrentView(JPanel newPanel, JPanel oldPanel){
		this.getContentPane().remove(oldPanel);
		newPanel.setBounds(0, 0, 1024, 768);
		//currentView.setVisible(true);
		this.getContentPane().add(newPanel);
		this.pack();
		this.repaint();
	}
	
	/**
	 * Set the current view
	 * @param newPanel the panel which the view should be changed to
	 * 
	 * @author Tom
	 */
	public void setCurrentView(JPanel newPanel) {
		this.getContentPane().removeAll();
		//newPanel.setBounds(0, 0, 1025, 769);			// not needed if all panel sizes are explicitly set
		currentView = newPanel;
		this.getContentPane().add(currentView);
		this.validate();
		//this.pack();									// not needed if all panel sizes are explicitly set
		this.repaint();
		
	}
	
	/**
	 * Returns the current view
	 * @return the current panel
	 * 
	 * @author Tom
	 */
	public JPanel getCurrentView() {
		return this.currentView;
	}
}
