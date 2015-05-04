package SixesWild.Controllers.MenuScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/3/15.
 */
public class AchievementButtonController extends ButtonController {
    Application app;
    public AchievementButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.switchTo(app.getBadgesScreen());
    }
}
