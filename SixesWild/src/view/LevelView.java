
package view;
import javax.swing.*;
import model.*;
import java.awt.*;

public class LevelView {

		static final long serialVersionUID = 1;

		public Board b;
		public JFrame frame;
		public BoardView bv;
		JPanel contentPane;
		
		public LevelView(Board b) {
			super();
			this.frame = new JFrame();
			this.b = b;
			this.contentPane = new JPanel();
			this.bv = new BoardView(b);

			initialize();
		}
		
		void initialize() {
			frame.setTitle("Ready?");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setBounds(100, 100, 450, 100);
			frame.setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout());
			bv = new BoardView(b);
			contentPane.add(bv, BorderLayout.CENTER);
		}
	}
