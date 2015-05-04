package SixesWild.Controllers;

import SixesWild.Views.Components.ListPanel;
import SixesWild.Views.Components.LockableButton;
import SixesWild.Views.Components.LockableButtonView;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/3/15.
 */
public class LockableButtonController extends ButtonController {

    ListPanel listPanel;
    LockableButtonView lockableButtonView;

    public LockableButtonController(LockableButton button, ListPanel listPanel, LockableButtonView lockableButtonView) {
        super(button);
        this.listPanel = listPanel;
        this.lockableButtonView = lockableButtonView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        LockableButtonView activeView = listPanel.getActiveView();
        if (activeView != null) {
            listPanel.getActiveView().getButton().inactive();
            listPanel.getActiveView().getButton().normal();
        }

        listPanel.setActiveView(lockableButtonView);
        button.actived();
    }
}
