package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Utilities;
import SixesWild.Views.Components.LargeStarsView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/4/15.
 */
public class ScoreProgressView extends JPanel {

    //    Padding top
    protected final int PADDING_TOP = 0;
    //    Padding left
    protected final int PADDING_LEFT = 0;

    //    Star score label font color
    protected final Color STAR_SCORE_LABEL_FONT_COLOR = new Color(149, 136, 118);
//    public

    //    Space between score label and star view
    protected final int GAP_SCORE_STAR_VIEWS = 0;

    //    Large star view number of stars
    final int THREE_STARS = 3;
    final int TWO_STARS = 2;
    final int ONE_STAR = 1;

    //    Star view size
    final Dimension STAR_VIEW_SIZE = new Dimension(96, 28);

    ScoreProgressBar scoreProgressBar;
    LargeStarsView largeStarsViewThreeStar;
    LargeStarsView largeStarsViewTwoStar;
    LargeStarsView largeStarsViewOneStar;

    int current;

    int oneStarScore;
    int twoStarScore;
    int threeStarScore;

    public ScoreProgressView(int current, int oneStarScore, int twoStarScore, int threeStarScore) {
        this.current = current;
        this.oneStarScore = oneStarScore;
        this.twoStarScore = twoStarScore;
        this.threeStarScore = threeStarScore;

        setPreferredSize(GameScreen.SCORE_PROGRESS_VIEW_SIZE);
        setMaximumSize(GameScreen.SCORE_PROGRESS_VIEW_SIZE);
        setMinimumSize(GameScreen.SCORE_PROGRESS_VIEW_SIZE);
    }

    public void initialize() {

        setLayout(null);
        setBackground(getParent().getBackground());

        //        Setup three stars view
        getLargeStarsViewThreeStar().setBounds(PADDING_LEFT, PADDING_TOP, (int) STAR_VIEW_SIZE.getWidth(), (int) STAR_VIEW_SIZE.getHeight());
        add(getLargeStarsViewThreeStar());
        getLargeStarsViewThreeStar().repaint();

        JLabel threeStarLabel = new JLabel(
                new Integer(threeStarScore).toString(),
                SwingConstants.RIGHT
        );
        threeStarLabel.setForeground(STAR_SCORE_LABEL_FONT_COLOR);
        threeStarLabel.setOpaque(false);
        threeStarLabel.setFont(Utilities.normalFont);

        add(threeStarLabel);

        threeStarLabel.setBounds(
                (int) (STAR_VIEW_SIZE.getWidth() - threeStarLabel.getMaximumSize().getWidth()),
        PADDING_TOP + (int) STAR_VIEW_SIZE.getHeight() + GAP_SCORE_STAR_VIEWS,
                (int) STAR_VIEW_SIZE.getWidth(),
                (int) STAR_VIEW_SIZE.getHeight()
        );

        //        Setup two stars view
        double marginTop = getMinimumSize().getHeight()
                - getMinimumSize().getHeight() * ((double) twoStarScore / (double) threeStarScore)
                - (int) STAR_VIEW_SIZE.getHeight() / 2
                - ScoreProgressBar.MILESTONE_LABEL_HEIGHT / 2;

        getLargeStarsViewTwoStar().setBounds(PADDING_LEFT, (int) marginTop, (int) STAR_VIEW_SIZE.getWidth(), (int) STAR_VIEW_SIZE.getHeight());
        add(getLargeStarsViewTwoStar());
        getLargeStarsViewTwoStar().repaint();

        JLabel twoStarLabel = new JLabel(
                new Integer(twoStarScore).toString(),
                SwingConstants.RIGHT
        );
        twoStarLabel.setForeground(STAR_SCORE_LABEL_FONT_COLOR);
        twoStarLabel.setOpaque(false);
        twoStarLabel.setFont(Utilities.normalFont);
        twoStarLabel.setBounds(
                PADDING_LEFT,
                (int) marginTop + (int) STAR_VIEW_SIZE.getHeight() + GAP_SCORE_STAR_VIEWS,
                (int) STAR_VIEW_SIZE.getWidth(),
                (int) STAR_VIEW_SIZE.getHeight()
        );
        add(twoStarLabel);

        //        Setup one stars view
        marginTop = getMinimumSize().getHeight()
                * (1.0 - ((double) oneStarScore / (double) threeStarScore))
                - (int) STAR_VIEW_SIZE.getHeight() + ScoreProgressBar.MILESTONE_LABEL_HEIGHT / 2;

        getLargeStarsViewOneStar().setBounds(PADDING_LEFT, (int) marginTop, (int) STAR_VIEW_SIZE.getWidth(), (int) STAR_VIEW_SIZE.getHeight());
        add(getLargeStarsViewOneStar());
        getLargeStarsViewOneStar().repaint();

        JLabel oneStarLabel = new JLabel(
                new Integer(oneStarScore).toString(),
                SwingConstants.RIGHT
        );
        oneStarLabel.setForeground(STAR_SCORE_LABEL_FONT_COLOR);
        oneStarLabel.setOpaque(false);
        oneStarLabel.setFont(Utilities.normalFont);
        oneStarLabel.setBounds(
                PADDING_LEFT,
                (int) marginTop + (int) STAR_VIEW_SIZE.getHeight() + GAP_SCORE_STAR_VIEWS,
                (int) STAR_VIEW_SIZE.getWidth(),
                (int) STAR_VIEW_SIZE.getHeight()
        );
        add(oneStarLabel);

        //        Setup progress bar
        getScoreProgressBar().setBounds((int) (
                        getMinimumSize().getWidth() - ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth()),
                PADDING_TOP + (int) STAR_VIEW_SIZE.getHeight() / 2,
                (int) ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth(),
                (int) ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getHeight());
        add(getScoreProgressBar());
        getScoreProgressBar().repaint();
    }

    public ScoreProgressBar getScoreProgressBar() {
        if (scoreProgressBar == null) {
            scoreProgressBar = new ScoreProgressBar(
                    current,
                    oneStarScore,
                    twoStarScore,
                    threeStarScore
            );
        }
        return scoreProgressBar;
    }

    public LargeStarsView getLargeStarsViewThreeStar() {
        if (largeStarsViewThreeStar == null) {
            largeStarsViewThreeStar = new LargeStarsView(THREE_STARS);

            largeStarsViewThreeStar.setPreferredSize(STAR_VIEW_SIZE);
            largeStarsViewThreeStar.setMaximumSize(STAR_VIEW_SIZE);
            largeStarsViewThreeStar.setMinimumSize(STAR_VIEW_SIZE);
        }
        return largeStarsViewThreeStar;
    }

    public LargeStarsView getLargeStarsViewTwoStar() {
        if (largeStarsViewTwoStar == null) {
            largeStarsViewTwoStar = new LargeStarsView(TWO_STARS);

            largeStarsViewTwoStar.setPreferredSize(STAR_VIEW_SIZE);
            largeStarsViewTwoStar.setMaximumSize(STAR_VIEW_SIZE);
            largeStarsViewTwoStar.setMinimumSize(STAR_VIEW_SIZE);
        }
        return largeStarsViewTwoStar;
    }

    public LargeStarsView getLargeStarsViewOneStar() {
        if (largeStarsViewOneStar == null) {
            largeStarsViewOneStar = new LargeStarsView(ONE_STAR);

            largeStarsViewOneStar.setPreferredSize(STAR_VIEW_SIZE);
            largeStarsViewOneStar.setMaximumSize(STAR_VIEW_SIZE);
            largeStarsViewOneStar.setMinimumSize(STAR_VIEW_SIZE);
        }
        return largeStarsViewOneStar;
    }

    public void updateScore(int score) {
        this.current += score;
        getScoreProgressBar().updateScore(score);
    }
}
