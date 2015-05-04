package SixesWild.Controllers.FlipScreen;

import SixesWild.Views.Components.FlipPagePanel;
import SixesWild.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class LastPageButtonController extends FlipPageButtonController {

    public LastPageButtonController(StyledButton button, FlipPagePanel flipPagePanel) {
        super(button, flipPagePanel);
        if(flipPagePanel.getListPanel().isAtListHead()){
            button.disabled();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(!flipPagePanel.getListPanel().isAtListHead()){
            flipPagePanel.lastPage();

            if(flipPagePanel.getListPanel().isAtListHead()){
                if(!flipPagePanel.getListPanel().isAtListEnd()) {
                    flipPagePanel.getNextPageButton().enabled();
                }
                button.disabled();
            } else {
                button.enabled();
            }
        }
    }
}