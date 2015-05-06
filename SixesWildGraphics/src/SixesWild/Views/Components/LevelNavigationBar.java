package SixesWild.Views.Components;

import SixesWild.Contracts.TextContact;
import SixesWild.Models.Score;
import SixesWild.Models.SpecialMoveLeft;
import SixesWild.Models.Value;
import SixesWild.Views.Application;
import SixesWild.Views.IModelUpdated;

import java.awt.*;

/**
 * Created by harryliu on 5/5/15.
 */
public class LevelNavigationBar extends NumberRemainNavigationBar implements IModelUpdated{
    //    Level view text width
    final int LEVEL_VIEW_TEXT_WIDTH = 80;
    //    Level view size
    final Dimension LEVEL_VIEW_SIZE = new Dimension(200, 58);
    //    Level view font size
    final float LEVEL_VIEW_FONT_SIZE = 22l;
    //    Level view integer underline thickness
    final int LEVEL_VIEW_UNDERLINE_THICKNESS = 2;

    //    Level view bounds
    final Rectangle LEVEL_VIEW_BOUNDS = new Rectangle(560, 0, 200, 58);

    IntegerLabelView LevelNumberView;
    Value levelNumber;

    public LevelNavigationBar(Application app, SpecialMoveLeft specialMoveLeft, Score score, Value numberLeft, String numberLabelText, Value levelNumber) {
        super(app, specialMoveLeft, score, numberLeft, numberLabelText);
        this.levelNumber = levelNumber;

        add(getLevelNumberView());
        getLevelNumberView().initialize();
    }

    public IntegerLabelView getLevelNumberView() {
        if (LevelNumberView == null) {
            LevelNumberView = new IntegerLabelView(
                    TextContact.LEVEL_ID,
                    levelNumber,
                    LEVEL_VIEW_UNDERLINE_THICKNESS,
                    LEVEL_VIEW_FONT_SIZE,
                    Color.WHITE,
                    LEFT_ALIGN,
                    LEVEL_VIEW_TEXT_WIDTH
            );

            LevelNumberView.setPreferredSize(LEVEL_VIEW_SIZE);
            LevelNumberView.setMaximumSize(LEVEL_VIEW_SIZE);
            LevelNumberView.setMinimumSize(LEVEL_VIEW_SIZE);

            LevelNumberView.setBounds(LEVEL_VIEW_BOUNDS);
        }
        return LevelNumberView;
    }

    @Override
    public void modelChanged() {
        super.modelChanged();
        getLevelNumberView().modelChanged();
    }
}
