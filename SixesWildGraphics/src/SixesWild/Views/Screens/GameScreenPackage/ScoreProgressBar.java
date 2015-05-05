package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Views.Components.BufferedCanvas;
import SixesWild.Views.Screens.Screen;

import java.awt.*;

/**
 * Created by harryliu on 5/4/15.
 */
public class ScoreProgressBar extends BufferedCanvas {

    //    Score progress bar size
    public static final Dimension SCORE_PROGRESS_BAR_SIZE = new Dimension(15, 526);
    //    Colors
    final Color TRANSPARENT_DARK = new Color(0, 0, 0, 80);
    final Color PROGRESS_RED = new Color(208, 102, 102);

    //    Milestone label bar height
    public static final int MILESTONE_LABEL_HEIGHT = 4;

    int current;

    int oneStarScore;
    int twoStarScore;
    int threeStarScore;

    public ScoreProgressBar(int current, int oneStarScore, int twoStarScore, int threeStarScore) {
        this.current = current;
        this.oneStarScore = oneStarScore;
        this.twoStarScore = twoStarScore;
        this.threeStarScore = threeStarScore;

        setPreferredSize(SCORE_PROGRESS_BAR_SIZE);
        setMinimumSize(SCORE_PROGRESS_BAR_SIZE);
        setMaximumSize(SCORE_PROGRESS_BAR_SIZE);
    }

    @Override
    protected void redrawState() {
        super.redrawState();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(PADDING_LEFT, PADDING_TOP, (int) SCORE_PROGRESS_BAR_SIZE.getWidth(), (int) SCORE_PROGRESS_BAR_SIZE.getHeight());

//        Draw progress bar
        double marginTop = getMinimumSize().getHeight() * (1.0 - ((double) current / (double) threeStarScore));
        graphics2D.setColor(PROGRESS_RED);
        graphics2D.fillRect(PADDING_LEFT, (int) marginTop, (int) getMinimumSize().getWidth(), (int) (getMinimumSize().getHeight() - marginTop));

//        Draw first milestone label
        marginTop = getMinimumSize().getHeight() * (1.0 - ((double) oneStarScore / (double) threeStarScore));
        graphics2D.setColor(TRANSPARENT_DARK);
        graphics2D.fillRect(PADDING_LEFT, (int) marginTop, (int) SCORE_PROGRESS_BAR_SIZE.getWidth(), MILESTONE_LABEL_HEIGHT);

//        Draw second milestone label
        marginTop = getMinimumSize().getHeight() * (1.0 - ((double) twoStarScore / (double) threeStarScore));
        graphics2D.setColor(TRANSPARENT_DARK);
        graphics2D.fillRect(PADDING_LEFT, (int) marginTop, (int) SCORE_PROGRESS_BAR_SIZE.getWidth(), MILESTONE_LABEL_HEIGHT);

//        Draw border line
        graphics2D.setColor(Screen.BORDER_COLOR);
        graphics2D.drawRect(PADDING_LEFT, PADDING_TOP, (int) SCORE_PROGRESS_BAR_SIZE.getWidth() - 1, (int) SCORE_PROGRESS_BAR_SIZE.getHeight() - 1);

    }

    public void updateScore(int score) {
        current += score;
    }
}