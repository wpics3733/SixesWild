package SixesWild.Controllers.FlipScreen;

import SixesWild.Views.Components.FlipPagePanel;
import SixesWild.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class NextPageButtonController extends FlipPageButtonController {
    public NextPageButtonController(StyledButton button, FlipPagePanel flipPagePanel) {
        super(button, flipPagePanel);
        if(flipPagePanel.getListPanel().isAtListEnd()){
            button.disabled();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!flipPagePanel.getListPanel().isAtListEnd()){
            flipPagePanel.nextPage();

            if(flipPagePanel.getListPanel().isAtListEnd()){
                if(!flipPagePanel.getListPanel().isAtListHead()) {
                    flipPagePanel.getLastPageButton().enabled();
                }
                button.disabled();
            } else {
                button.enabled();
            }
        }
    }
}