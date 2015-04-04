
package view;
import javax.swing.*;
import model.*;
import java.awt.*;

public class SixesWild {

		static final long serialVersionUID = 1;

		public SixesGridModel m;
		public JFrame frame;
		public SixesGridView v;
		JPanel contentPane;
		
		public SixesWild(SixesGridModel m) {
			super();
			this.frame = new JFrame();
			this.m = m;
			this.contentPane = new JPanel();
			this.v = new SixesGridView(m);

			initialize();
		}
		
		void initialize() {
			frame.setTitle("Ready?");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setBounds(100, 100, 450, 100);
			frame.setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout());
			v = new SixesGridView(m);
			contentPane.add(v, BorderLayout.CENTER);
		}
	}
