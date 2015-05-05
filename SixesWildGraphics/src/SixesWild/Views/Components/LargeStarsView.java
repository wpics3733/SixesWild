package SixesWild.Views.Components;

/**
 * Created by harryliu on 5/2/15.
 */

import SixesWild.Contracts.ImageContract;
import SixesWild.Utilities;
import SixesWild.Views.Application;

import javax.imageio.ImageIO;
import java.io.File;

/**
 *
 */
public class LargeStarsView extends StarsView {
    //    Distance between stars
    final int GAP_BETWEEN_STARS = 12;

    public LargeStarsView(int star) {
        super(star);

        try {
            starActiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_LARGE_ACTIVE_IMAGE));
            starInactiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_LARGE_INACTIVE_IMAGE));
            gapBetweenStars = GAP_BETWEEN_STARS;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    void drawOneStar() {

//        1rd star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
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

    @Override
    void drawTwoStars() {

        //        1nd star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        2rd star
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
