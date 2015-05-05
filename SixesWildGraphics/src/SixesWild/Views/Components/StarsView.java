package SixesWild.Views.Components;

import SixesWild.Utilities;
import SixesWild.Views.Screens.Screen;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class StarsView extends BufferedCanvas {

    //    Star view paddings
    final int PADDING_TOP = 0;
    final int PADDING_LEFT = 0;

    final int STAR_PADDING_TOP = 2;

    Image starActiveImage;
    Image starInactiveImage;

    //    Number of stars
    int star;
    //    Gap between stars
    int gapBetweenStars;

    public StarsView(int star) {
        this.star = star;
    }

    protected void redrawState() {
        super.redrawState();

        graphics2D.setColor(getParent().getBackground());

        graphics2D.fillRect(
                PADDING_LEFT,
                PADDING_TOP,
                (int) getPreferredSize().getWidth(),
                (int) getPreferredSize().getHeight()
        );

        switch (star) {
            case 1:
                drawOneStar();
                break;
            case 2:
                drawTwoStars();
                break;
            case 3:
                drawThreeStars();
                break;
        }
    }

    void drawOneStar() {
//        1st star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2
                - starActiveImage.getWidth(this)
                - gapBetweenStars;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

//        2nd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starInactiveImage.getWidth(this)) / 2;

        graphics2D.drawImage(
                starInactiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starInactiveImage.getWidth(this),
                starInactiveImage.getHeight(this),
                this);

//        3rd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                + starInactiveImage.getWidth(this)) / 2
                +gapBetweenStars;
        graphics2D.drawImage(
                starInactiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starInactiveImage.getWidth(this),
                starInactiveImage.getHeight(this),
                this);
    }

    void drawTwoStars() {
        //        1st star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2
                - starActiveImage.getWidth(this)
                - gapBetweenStars;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        2nd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        3rd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                + starInactiveImage.getWidth(this)) / 2
                +gapBetweenStars;
        graphics2D.drawImage(
                starInactiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starInactiveImage.getWidth(this),
                starInactiveImage.getHeight(this),
                this);
    }

    void drawThreeStars() {
        //        1st star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2
                - starActiveImage.getWidth(this)
                - gapBetweenStars;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        2nd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        3rd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                + starActiveImage.getWidth(this)) / 2
                +gapBetweenStars;
        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);
    }
}