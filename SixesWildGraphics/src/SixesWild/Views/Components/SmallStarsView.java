package SixesWild.Views.Components;

/**
 * Created by harryliu on 5/2/15.
 */

import SixesWild.Contracts.ImageContract;
import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Screens.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 *
 */
public class SmallStarsView extends StarsView {

    //    Distance between stars
    final int GAP_BETWEEN_STARS = 6;


    public SmallStarsView(int star) {
        super(star);

        try {
            starActiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_SMALL_ACTIVE_IMAGE));
            starInactiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_SMALL_INACTIVE_IMAGE));
            gapBetweenStars = GAP_BETWEEN_STARS;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    void redrawState() {
        ensureImageAvaliable();
        Utilities.setHighQuality(graphics2D);

        graphics2D.setColor(Screen.SCREEN_BACK_COLOR);

        graphics2D.fillRect(
                PADDING_LEFT,
                PADDING_TOP,
                (int) getPreferredSize().getWidth(),
                (int) getPreferredSize().getHeight()
        );

        super.redrawState();
    }
}
