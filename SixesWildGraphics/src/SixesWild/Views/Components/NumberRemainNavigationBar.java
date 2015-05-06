package SixesWild.Views.Components;

import SixesWild.Models.Levels.Level;
import SixesWild.Models.Score;
import SixesWild.Models.SpecialMoveLeft;
import SixesWild.Models.Value;
import SixesWild.Views.Application;
import SixesWild.Views.IModelUpdated;

import java.awt.*;

/**
 * Created by harryliu on 5/5/15.
 */
public class NumberRemainNavigationBar extends ScoreSpecialMoveNavigationBar implements IModelUpdated{
    //    Number  view text width
    final int NUM_VIEW_TEXT_WIDTH = 120;
    //    Number view size
    final Dimension NUM_VIEW_SIZE = new Dimension(200, 58);
    //    Number view font size
    final float NUM_VIEW_FONT_SIZE = 22l;
    //    Number view integer underline thickness
    final int NUM_VIEW_UNDERLINE_THICKNESS = 2;

    //    Number view bounds
    final Rectangle NUM_VIEW_BOUNDS = new Rectangle(320, 0, 200, 58);

    IntegerLabelView numberView;
    Value numberLeft;
    String numberLabelText;

    public NumberRemainNavigationBar(Application app, SpecialMoveLeft specialMoveLeft, Score score, Value numberLeft, String numberLabelText) {
        super(app, specialMoveLeft, score);
        this.numberLeft = numberLeft;
        this.numberLabelText = numberLabelText;

        add(getNumMoveLeftView());
        getNumMoveLeftView().initialize();
    }

    public IntegerLabelView getNumMoveLeftView() {
        if (numberView == null) {
            numberView = new IntegerLabelView(
                    numberLabelText,
                    numberLeft,
                    NUM_VIEW_UNDERLINE_THICKNESS,
                    NUM_VIEW_FONT_SIZE,
                    Color.WHITE,
                    LEFT_ALIGN,
                    NUM_VIEW_TEXT_WIDTH
            );

            numberView.setPreferredSize(NUM_VIEW_SIZE);
            numberView.setMaximumSize(NUM_VIEW_SIZE);
            numberView.setMinimumSize(NUM_VIEW_SIZE);

            numberView.setBounds(NUM_VIEW_BOUNDS);
        }
        return numberView;
    }

    @Override
    public void modelChanged() {
        numberView.modelChanged();
        super.modelChanged();
    }
}
