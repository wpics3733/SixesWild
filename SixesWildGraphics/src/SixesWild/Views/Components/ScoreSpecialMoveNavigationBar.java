package SixesWild.Views.Components;

import SixesWild.Contracts.TextContact;
import SixesWild.Views.Application;

import java.awt.*;

/**
 *
 */
public class ScoreSpecialMoveNavigationBar extends SpecialMoveNavigationBar {

    //    Score view text width
    final int SCORE_VIEW_TEXT_WIDTH = 80;
    //    Score view size
    final Dimension SCORE_VIEW_SIZE = new Dimension(200, 58);
    //    Score view font size
    final float SCORE_VIEW_FONT_SIZE = 22l;
    //    Score view integer underline thickness
    final int SCORE_VIEW_UNDERLINE_THICKNESS = 2;
    //    Left align
    final boolean LEFT_ALIGN = true;
    //    Initial score
    final int INITIAL_SCORE = 0;
    //    Score view bounds
    final Rectangle SCORE_VIEW_BOUNDS = new Rectangle(78, 0, 200, 58);


    IntegerLabelView scoreView;

    public ScoreSpecialMoveNavigationBar(Application app, int swapSquareSpecialMoveLeft, int resetBoardSpecialMoveLeft, int removeTileSpecialMoveLeft) {
        super(app, swapSquareSpecialMoveLeft, resetBoardSpecialMoveLeft, removeTileSpecialMoveLeft);

        add(getScoreView());
        scoreView.initialize();
    }

    public IntegerLabelView getScoreView() {
        if (scoreView == null) {
            scoreView = new IntegerLabelView(
                    TextContact.SCORE_LABEL_TEXT,
                    INITIAL_SCORE,
                    SCORE_VIEW_UNDERLINE_THICKNESS,
                    SCORE_VIEW_FONT_SIZE,
                    Color.WHITE,
                    LEFT_ALIGN,
                    SCORE_VIEW_TEXT_WIDTH
            );

            scoreView.setPreferredSize(SCORE_VIEW_SIZE);
            scoreView.setMaximumSize(SCORE_VIEW_SIZE);
            scoreView.setMinimumSize(SCORE_VIEW_SIZE);

            scoreView.setBounds(SCORE_VIEW_BOUNDS);
        }
        return scoreView;
    }
}