package SixesWild.Controllers.ViewLevelScreen;

import SixesWild.Controllers.LockableButtonController;
import SixesWild.Models.Level;
import SixesWild.Views.Components.LockableButton;
import SixesWild.Views.Screens.LevelScreenPackage.LevelDetailPanel;
import SixesWild.Views.Screens.LevelScreenPackage.LevelListPanel;
import SixesWild.Views.Components.LockableButtonView;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/3/15.
 */
public class LevelButtonController extends LockableButtonController {
    Level level;
    LevelDetailPanel levelDetailPanel;


    public LevelButtonController(
            LockableButton button,
            LevelListPanel levelListPanel,
            LockableButtonView lockableButtonView,
            Level level,
            LevelDetailPanel levelDetailPanel) {

        super(button, levelListPanel, lockableButtonView);
        this.level = level;
        this.levelDetailPanel = levelDetailPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }
}
