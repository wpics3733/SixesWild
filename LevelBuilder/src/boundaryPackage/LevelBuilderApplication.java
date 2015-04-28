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


//test
//import com.jgoodies.forms.layout.FormSpecs;

public class LevelBuilderApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel currentView;

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
		
		currentView = new SplashScreenPanel(this);
		//currentView = new MenuPanel(this);
		currentView.setBounds(0, 0, 1024, 768);
		contentPane.add(currentView);
		
		
		this.pack();
	}
	
	public void setCurrentView(JPanel newPanel, JPanel oldPanel){
		this.getContentPane().remove(oldPanel);
		newPanel.setBounds(0, 0, 1024, 768);
		//currentView.setVisible(true);
		this.getContentPane().add(newPanel);
		this.pack();
		this.repaint();
	}
}
