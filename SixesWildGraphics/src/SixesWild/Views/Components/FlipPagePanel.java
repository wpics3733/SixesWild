package SixesWild.Views.Components;

import SixesWild.Contracts.ImageContract;
import SixesWild.Contracts.TipContract;
import SixesWild.Controllers.FlipScreen.LastPageButtonController;
import SixesWild.Controllers.FlipScreen.NextPageButtonController;
import SixesWild.Views.Application;
import SixesWild.Views.Screens.FlipPageScreen;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class FlipPagePanel extends JPanel {

    //    Panel back ground color
    public final Color PANEL_BACK_COLOR = new Color(249, 246, 242);
    //    Size of flip page buttons
    public final Dimension FLIP_PAGE_BUTTON_SIZE = new Dimension(76, 76);

    //    Flip page button padding
    public final int FLIP_PAGE_BUTTON_PADDING = 35;

    //    Last page button bounds
    public final Rectangle LAST_PAGE_BUTTON_BOUNDS = new Rectangle(
            FLIP_PAGE_BUTTON_PADDING,
            225,
            (int) FLIP_PAGE_BUTTON_SIZE.getWidth(),
            (int) FLIP_PAGE_BUTTON_SIZE.getHeight()
    );

    //    Next page button bounds
    public final Rectangle NEXT_PAGE_BUTTON_BONDS = new Rectangle(
            Application.WINDOW_WIDTH
                    - FLIP_PAGE_BUTTON_PADDING
                    - (int) FLIP_PAGE_BUTTON_SIZE.getWidth(),
            225,
            (int) FLIP_PAGE_BUTTON_SIZE.getWidth(),
            (int) FLIP_PAGE_BUTTON_SIZE.getHeight()
    );

    //   Page indicator size
    public final Dimension PAGE_INDICATOR_SIZE = new Dimension(500, 20);

    //    Page indicator bounds
    public final Rectangle PAGE_INDICATOR_BONDS = new Rectangle(
            (Application.WINDOW_WIDTH - 500) / 2,
            430,
            (int) PAGE_INDICATOR_SIZE.getWidth(),
            (int) PAGE_INDICATOR_SIZE.getHeight()
    );

    //    Flip page panel last page button
    ImageButton lastPageButton;
    //    Flip page panel next page button
    ImageButton nextPageButton;
    //    Flip page button list panel
    ListPanel listPanel;

    //    Flip page screen
    FlipPageScreen flipPageScreen;

    //    Flip page panel page indicator
    PageIndicator pageIndicator;

    public FlipPagePanel(FlipPageScreen flipPageScreen) {
        this.flipPageScreen = flipPageScreen;

        setLayout(null);
        setOpaque(true);

        setBackground(PANEL_BACK_COLOR);
    }

    public void initialize() {

        getLastPageButton().setPreferredSize(FLIP_PAGE_BUTTON_SIZE);
        getLastPageButton().setMaximumSize(FLIP_PAGE_BUTTON_SIZE);
        getLastPageButton().setMinimumSize(FLIP_PAGE_BUTTON_SIZE);

        getLastPageButton().setBounds(LAST_PAGE_BUTTON_BOUNDS);

        LastPageButtonController lastPageButtonController = new LastPageButtonController(
                getLastPageButton(),
                this
        );

        getLastPageButton().addMouseListener(lastPageButtonController);
        getLastPageButton().addMouseMotionListener(lastPageButtonController);
        getLastPageButton().setToolTipText(TipContract.LAST_PAGE_BUTTON_TIP);

        add(lastPageButton);

        lastPageButton.repaint();

        getNextPageButton().setPreferredSize(FLIP_PAGE_BUTTON_SIZE);
        getNextPageButton().setMinimumSize(FLIP_PAGE_BUTTON_SIZE);
        getNextPageButton().setMaximumSize(FLIP_PAGE_BUTTON_SIZE);

        getNextPageButton().setBounds(NEXT_PAGE_BUTTON_BONDS);

        NextPageButtonController nextPageButtonController = new NextPageButtonController(
                getNextPageButton(),
                this
        );

        getNextPageButton().addMouseListener(nextPageButtonController);
        getNextPageButton().addMouseMotionListener(nextPageButtonController);
        getNextPageButton().setToolTipText(TipContract.NEXT_PAGE_BUTTON_TIP);

        add(nextPageButton);

        nextPageButton.repaint();

        getPageIndicator().setPreferredSize(PAGE_INDICATOR_SIZE);
        getPageIndicator().setMinimumSize(PAGE_INDICATOR_SIZE);
        getPageIndicator().setMaximumSize(PAGE_INDICATOR_SIZE);

        getPageIndicator().setBounds(PAGE_INDICATOR_BONDS);

        add(getPageIndicator());

        getPageIndicator().repaint();
    }

    public ImageButton getLastPageButton() {
        if (lastPageButton == null) {

            lastPageButton = new ImageButton(
                    ImageContract.LAST_PAGE_BUTTON_IMAGE,
                    ImageContract.LAST_PAGE_BUTTON_HOVERED_IMAGE,
                    ImageContract.LAST_PAGE_BUTTON_HOVERED_IMAGE,
                    ImageContract.LAST_PAGE_BUTTON_DISABLED_IMAGE,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR
            );
        }

        return lastPageButton;
    }

    public ImageButton getNextPageButton() {
        if (nextPageButton == null) {

            nextPageButton = new ImageButton(
                    ImageContract.NEXT_PAGE_BUTTON_IMAGE,
                    ImageContract.NEXT_PAGE_BUTTON_HOVERED_IMAGE,
                    ImageContract.NEXT_PAGE_BUTTON_HOVERED_IMAGE,
                    ImageContract.NEXT_PAGE_BUTTON_DISABLED_IMAGE,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR
            );
        }

        return nextPageButton;
    }


    public void setListPanel(ListPanel listPanel) {
        this.listPanel = listPanel;
    }

    public PageIndicator getPageIndicator() {
        if (pageIndicator == null) {

            int totalPage = getListPanel().getViews().size() % (ListPanel.NUMBER_LINE_EACH_PAGE * ListPanel.NUMBER_VIEWS_EACH_LINE);

            if (totalPage != 0) {
                totalPage = getListPanel().getViews().size() / (ListPanel.NUMBER_LINE_EACH_PAGE * ListPanel.NUMBER_VIEWS_EACH_LINE) +1;
            } else {
                totalPage = getListPanel().getViews().size() / (ListPanel.NUMBER_LINE_EACH_PAGE * ListPanel.NUMBER_VIEWS_EACH_LINE);
            }

            pageIndicator = new PageIndicator(getListPanel().getCurrentPage(), totalPage);
        }
        return pageIndicator;
    }

    public void nextPage() {
        getListPanel().nextPage();
        getPageIndicator().nextPage();
        repaint();
    }

    public void lastPage() {
        getListPanel().lastPage();
        getPageIndicator().lastPage();
        repaint();
    }

    public void setPageIndicator(PageIndicator pageIndicator) {
        this.pageIndicator = pageIndicator;
    }

    public ListPanel getListPanel() {
        return listPanel;
    }

    public FlipPageScreen getFlipPageScreen() {
        return flipPageScreen;
    }
}