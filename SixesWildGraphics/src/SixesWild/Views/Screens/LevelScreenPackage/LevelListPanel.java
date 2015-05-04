package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Models.Levels.Level;
import SixesWild.Views.Components.ListPanel;

import java.util.ArrayList;

/**
 *
 */
public class LevelListPanel extends ListPanel {

    ArrayList<Level> levels;

    LevelDetailPanel levelDetailPanel;

    public LevelListPanel(ArrayList<Level> levels, LevelDetailPanel levelDetailPanel) {
        super(levelDetailPanel);
        this.levels = levels;

        setPreferredSize(LIST_PANEL_SIZE);
    }

    @Override
    public void setUpViews() {
//        for (Iterator<Level> level = levels.iterator(); level.hasNext();) {
//            LevelView levelView = new LevelView(level.next(), levelDetailPanel);
//            levelView.setPreferredSize(ListPanel.VIEW_SIZE);
//
//            getViews().add(levelView);
//        }

        for (int i = 0; i < 16; i++) {

            LevelView levelView = new LevelView(null, this,levelDetailPanel);

            levelView.setPreferredSize(ListPanel.VIEW_SIZE);
            levelView.setMinimumSize(ListPanel.VIEW_SIZE);
            levelView.setMaximumSize(ListPanel.VIEW_SIZE);

            if(i % 2 == 0) {
                levelView.getLevelButton().unlock();
            }

            getViews().add(levelView);
        }
    }
}