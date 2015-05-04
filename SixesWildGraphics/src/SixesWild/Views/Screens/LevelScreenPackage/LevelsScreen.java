package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Models.Levels.Level;
import SixesWild.Views.Application;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Screens.FlipPageScreen;

import java.util.ArrayList;

/**
 *
 */
public class LevelsScreen extends FlipPageScreen {

    ArrayList<Level> levels;

    LevelFlipPagePanel levelFlipPagePanel;

    public LevelsScreen(String title, Application app, String navTitle) {

        super(title, app, navTitle);
        setUpLevelList();
    }

    void setUpLevelList() {

//        Read level files here, and add level into ArrayList<Level> levels


        levels = null;

        getLevelDetailPanel().setPreferredSize(DetailPanel.DETAIL_PANEL_SIZE);
        getLevelDetailPanel().setMinimumSize(DetailPanel.DETAIL_PANEL_SIZE);
        getLevelDetailPanel().setMaximumSize(DetailPanel.DETAIL_PANEL_SIZE);

        getLevelDetailPanel().setBounds(DETAIL_PANEL_BOUNDS);
        add(getLevelDetailPanel());

        getLevelFlipPagePanel().setPreferredSize(FLIP_PAGE_PANEL_SIZE);
        getLevelFlipPagePanel().setMinimumSize(FLIP_PAGE_PANEL_SIZE);
        getLevelFlipPagePanel().setMaximumSize(FLIP_PAGE_PANEL_SIZE);

        getLevelFlipPagePanel().setBounds(FLIP_PAGE_PANEL_BOUNDS);
        add(getLevelFlipPagePanel());

    }

    public LevelDetailPanel getLevelDetailPanel() {
        if (getDetailPanel() == null) {
            setDetailPanel(new LevelDetailPanel());
        }

        return (LevelDetailPanel) getDetailPanel();
    }

    public LevelFlipPagePanel getLevelFlipPagePanel() {
        if (levelFlipPagePanel == null) {
            levelFlipPagePanel = new LevelFlipPagePanel(this, levels);
        }

        return levelFlipPagePanel;
    }
}