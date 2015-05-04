package SixesWild.Controllers.ViewLevelScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Views.Components.FlipPagePanel;
import SixesWild.Views.Components.ListPanel;
import SixesWild.Views.Components.StyledButton;

/**
 * Created by harryliu on 5/4/15.
 */
public class FlipPageButtonController extends ButtonController {

    FlipPagePanel flipPagePanel;
    boolean reachListEnd;

    public FlipPageButtonController(StyledButton button, FlipPagePanel flipPagePanel) {
        super(button);
        this.flipPagePanel = flipPagePanel;
    }
}
