package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Value;
import SixesWild.Views.Components.BufferedCanvas;
import SixesWild.Views.IModelUpdated;
import SixesWild.Views.Screens.Screen;

import java.awt.*;

/**
 * Created by harryliu on 5/4/15.
 */
public class ScoreProgressBar extends BufferedCanvas implements IModelUpdated{

    //    Score progress bar size
    public static final Dimension SCORE_PROGRESS_BAR_SIZE = new Dimension(15, 526);
    //    Colors
    final Color TRANSPARENT_DARK = new Color(0, 0, 0, 80);
    final Color PROGRESS_RED = new Color(208, 102, 102);

    //    Milestone label bar height
    public static final int MILESTONE_LABEL_HEIGHT = 4;

    Value current;

    Value oneStarScore;
    Value twoStarScore;
    Value threeStarScore;

    public ScoreProgressBar(Value current, Value oneStarScore, Value twoStarScore, Value threeStarScore) {
        this.current = current;
        this.oneStarScore = oneStarScore;
        this.twoStarScore = twoStarScore;
        this.threeStarScore = threeStarScore;
    }

    @Override
    protected void redrawState() {
        super.redrawState();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(PADDING_LEFT, PADDING_TOP, (int) SCORE_PROGRESS_BAR_SIZE.getWidth(), (int) SCORE_PROGRESS_BAR_SIZE.getHeight());

//        Draw progress bar
        double marginTop = getMinimumSize().getHeight() * (1.0 - ((double) current.getValue() / (double) threeStarScore.getValue()));
        graphics2D.setColor(PROGRESS_RED);
        graphics2D.fillRect(PADDING_LEFT, (int) marginTop, (int) getMinimumSize().getWidth(), (int) (getMinimumSize().getHeight() - marginTop));

//        Draw first milestone label
        marginTop = getMinimumSize().getHeight() * (1.0 - ((double) oneStarScore.getValue() / (double) threeStarScore.getValue()));
        graphics2D.setColor(TRANSPARENT_DARK);
        graphics2D.fillRect(PADDING_LEFT, (int) marginTop, (int) SCORE_PROGRESS_BAR_SIZE.getWidth(), MILESTONE_LABEL_HEIGHT);

//        Draw second milestone label
        marginTop = getMinimumSize().getHeight() * (1.0 - ((double) twoStarScore.getValue() / (double) threeStarScore.getValue()));
        graphics2D.setColor(TRANSPARENT_DARK);
        graphics2D.fillRect(PADDING_LEFT, (int) marginTop, (int) SCORE_PROGRESS_BAR_SIZE.getWidth(), MILESTONE_LABEL_HEIGHT);

//        Draw border line
        graphics2D.setColor(Screen.BORDER_COLOR);
        graphics2D.drawRect(PADDING_LEFT, PADDING_TOP, (int) SCORE_PROGRESS_BAR_SIZE.getWidth() - 1, (int) SCORE_PROGRESS_BAR_SIZE.getHeight() - 1);

    }

    @Override
    public void modelChanged() {
        repaint();
    }
}