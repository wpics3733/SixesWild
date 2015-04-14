package sixesWild;

import javax.swing.JFrame;

import sixesWild.view.Application;

public class Main {
	public static void main(String[] args) {
		Application app = new Application();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
