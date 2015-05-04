package SixesWild.Views.Components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 */
public abstract class ListPanel extends JPanel {

    //  List panel size
    public static final Dimension LIST_PANEL_SIZE = new Dimension(632, 228);

    //  List panel bounds
    public static final Rectangle LIST_PANEL_BOUNDS = new Rectangle(196, 150, 632, 228);

    //    View size
    public static final Dimension VIEW_SIZE = new Dimension(72, 92);

    //    Number of line on each page
    public static final int NUMBER_LINE_EACH_PAGE = 2;

    //    Number of views on each line
    public static final int NUMBER_VIEWS_EACH_LINE = 6;

    //    Space between line
    final int LINE_SPACE = 40;

    //    Space between each views
    final int VIEW_SPACE = 38;

    ArrayList<LockableButtonView> views;

    LockableButtonView activeView;
    DetailPanel detailPanel;
    int currentPage;

    public ListPanel(DetailPanel detailPanel) {
        this.detailPanel = detailPanel;

        this.activeView = null;
        this.currentPage = 0;

        views = new ArrayList<LockableButtonView>();

        setOpaque(false);
        setLayout(null);

        setUpViews();
        showViews();
    }

    /**
     * Show list of views in current page
     */
    public void showViews() {
        int totalViews = views.size();

        for (int line = 0; line < NUMBER_LINE_EACH_PAGE; line++) {
            for (int viewNum = 0; viewNum < NUMBER_VIEWS_EACH_LINE; viewNum++) {

                int currentView = currentPage * NUMBER_LINE_EACH_PAGE * NUMBER_VIEWS_EACH_LINE
                        + line * NUMBER_VIEWS_EACH_LINE
                        + viewNum;
                if (currentView + 1 < totalViews) {

                    views.get(currentView).setBounds(
                            viewNum * ((int) VIEW_SIZE.getWidth() + VIEW_SPACE),
                            line * ((int) VIEW_SIZE.getHeight() + LINE_SPACE),
                            (int) VIEW_SIZE.getWidth(),
                            (int) VIEW_SIZE.getHeight()
                    );

                    add(views.get(currentView));
                } else {
                    break;
                }
            }
        }
    }

    public void nextPage() {
        if (!isAtListEnd()) {
            currentPage++;
            removeAll();
            showViews();
        }
    }

    public void lastPage() {
        if (!isAtListHead()) {
            currentPage--;
            removeAll();
            showViews();
        }
    }

    public boolean isAtListEnd() {
        return (currentPage + 1) * NUMBER_LINE_EACH_PAGE * NUMBER_VIEWS_EACH_LINE >= views.size();
    }

    public boolean isAtListHead() {
        return currentPage <= 0;
    }

    abstract public void setUpViews();

    public ArrayList<LockableButtonView> getViews() {
        return views;
    }

    public void setViews(ArrayList<LockableButtonView> views) {
        this.views = views;
    }

    public LockableButtonView getActiveView() {
        return activeView;
    }

    public void setActiveView(LockableButtonView activeView) {
        this.activeView = activeView;
    }

    public int getCurrentPage() {
        return currentPage;
    }


}