import model.*;
import view.*;

public class Main {
	
	public static void main( String args[]) {
		
		Level l = new Level();
		Application a = new Application(l);
		a.getFrame().setVisible(true);		
		
	}
}
