package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Score;
import SixesWild.Models.Value;
import SixesWild.Utilities;
import SixesWild.Views.Components.LargeStarsView;
import SixesWild.Views.IModelUpdated;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/4/15.
 */
public class ScoreProgressView extends JPanel implements IModelUpdated {

    //    Star label font size
    protected final float STAR_LABEL_FONT_SIZE = 14l;
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

    //    Star label size
    protected final Dimension STAR_LABEL_VIEW_SIZE = new Dimension(
            (int) (STAR_VIEW_SIZE.getWidth()
                    - ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth()),
            30
    );

    ScoreProgressBar scoreProgressBar;
    LargeStarsView largeStarsViewThreeStar;
    LargeStarsView largeStarsViewTwoStar;
    LargeStarsView largeStarsViewOneStar;

    JLabel threeStarLabel;
    JLabel twoStarLabel;
    JLabel oneStarLabel;

    Value current;

    Value oneStarScore;
    Value twoStarScore;
    Value threeStarScore;

    public ScoreProgressView(Score score) {
        this.current = score.getCurrentScore();
        this.oneStarScore = score.getOneStarScore();
        this.twoStarScore = score.getTwoStarScore();
        this.threeStarScore = score.getThreeStarScore();

        setPreferredSize(GameScreen.SCORE_PROGRESS_VIEW_SIZE);
        setMaximumSize(GameScreen.SCORE_PROGRESS_VIEW_SIZE);
        setMinimumSize(GameScreen.SCORE_PROGRESS_VIEW_SIZE);
    }

    public void initialize() {

        setLayout(null);
        setBackground(getParent().getBackground());

        Utilities.normalFont = Utilities.normalFont.deriveFont(STAR_LABEL_FONT_SIZE);

        //        Setup three stars view

        add(getLargeStarsViewThreeStar());
        getLargeStarsViewThreeStar().repaint();

        threeStarLabel = new JLabel(
                threeStarScore.toString(),
                SwingConstants.RIGHT
        );

        threeStarLabel.setForeground(STAR_SCORE_LABEL_FONT_COLOR);
        threeStarLabel.setOpaque(false);
        threeStarLabel.setFont(Utilities.normalFont);

        threeStarLabel.setPreferredSize(STAR_LABEL_VIEW_SIZE);
        threeStarLabel.setMaximumSize(STAR_LABEL_VIEW_SIZE);
        threeStarLabel.setMinimumSize(STAR_LABEL_VIEW_SIZE);


        add(threeStarLabel);

        //        Setup two stars view


        add(getLargeStarsViewTwoStar());
        getLargeStarsViewTwoStar().repaint();

        twoStarLabel = new JLabel(
                twoStarScore.toString(),
                SwingConstants.RIGHT
        );

        twoStarLabel.setForeground(STAR_SCORE_LABEL_FONT_COLOR);
        twoStarLabel.setOpaque(false);

        twoStarLabel.setFont(Utilities.normalFont);

        twoStarLabel.setPreferredSize(STAR_LABEL_VIEW_SIZE);
        twoStarLabel.setMaximumSize(STAR_LABEL_VIEW_SIZE);
        twoStarLabel.setMinimumSize(STAR_LABEL_VIEW_SIZE);

        add(twoStarLabel);

        //        Setup one stars view

        add(getLargeStarsViewOneStar());
        getLargeStarsViewOneStar().repaint();

        oneStarLabel = new JLabel(
                oneStarScore.toString(),
                SwingConstants.RIGHT
        );
        oneStarLabel.setForeground(STAR_SCORE_LABEL_FONT_COLOR);
        oneStarLabel.setOpaque(false);
        oneStarLabel.setFont(Utilities.normalFont);

        oneStarLabel.setPreferredSize(STAR_LABEL_VIEW_SIZE);
        oneStarLabel.setMaximumSize(STAR_LABEL_VIEW_SIZE);
        oneStarLabel.setMinimumSize(STAR_LABEL_VIEW_SIZE);

        add(oneStarLabel);

        //        Setup progress bar
        getScoreProgressBar().setBounds((int) (
                        getMinimumSize().getWidth() - ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth()),
                PADDING_TOP + (int) STAR_VIEW_SIZE.getHeight() / 2,
                (int) ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth(),
                (int) ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getHeight());
        add(getScoreProgressBar());

        getLargeStarsViewThreeStar().setBounds(PADDING_LEFT, PADDING_TOP, (int) STAR_VIEW_SIZE.getWidth(), (int) STAR_VIEW_SIZE.getHeight());
        threeStarLabel.setBounds(
                (int) (STAR_VIEW_SIZE.getWidth()
                        - threeStarLabel.getMaximumSize().getWidth()
                        - ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth()),
                PADDING_TOP + (int) STAR_VIEW_SIZE.getHeight() + GAP_SCORE_STAR_VIEWS,
                (int) STAR_VIEW_SIZE.getWidth(),
                (int) STAR_VIEW_SIZE.getHeight()
        );

        double marginTop = getScoreProgressBar().getMinimumSize().getHeight()
                * (1.0 - ((double) twoStarScore.getValue() / (double) threeStarScore.getValue()));
        getLargeStarsViewTwoStar().setBounds(PADDING_LEFT, (int) marginTop, (int) STAR_VIEW_SIZE.getWidth(), (int) STAR_VIEW_SIZE.getHeight());
        twoStarLabel.setBounds(
                (int) (STAR_VIEW_SIZE.getWidth()
                        - threeStarLabel.getMaximumSize().getWidth()
                        - ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth()),
                (int) marginTop + (int) STAR_VIEW_SIZE.getHeight() + GAP_SCORE_STAR_VIEWS,
                (int) STAR_VIEW_SIZE.getWidth(),
                (int) STAR_VIEW_SIZE.getHeight()
        );

        marginTop = getScoreProgressBar().getMinimumSize().getHeight()
                * (1.0 - ((double) oneStarScore.getValue() / (double) threeStarScore.getValue()));

        getLargeStarsViewOneStar().setBounds(PADDING_LEFT, (int) marginTop, (int) STAR_VIEW_SIZE.getWidth(), (int) STAR_VIEW_SIZE.getHeight());
        oneStarLabel.setBounds(
                (int) (STAR_VIEW_SIZE.getWidth()
                        - threeStarLabel.getMaximumSize().getWidth()
                        - ScoreProgressBar.SCORE_PROGRESS_BAR_SIZE.getWidth()),
                (int) marginTop + (int) STAR_VIEW_SIZE.getHeight() + GAP_SCORE_STAR_VIEWS,
                (int) STAR_VIEW_SIZE.getWidth(),
                (int) STAR_VIEW_SIZE.getHeight()
        );

        getScoreProgressBar().modelChanged();
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

    @Override
    public void modelChanged() {

        getScoreProgressBar().modelChanged();
    }
}
