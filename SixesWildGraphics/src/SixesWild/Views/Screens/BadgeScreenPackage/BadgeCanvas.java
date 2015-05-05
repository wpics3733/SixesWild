package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Components.BufferedCanvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 *
 */
public class BadgeCanvas extends BufferedCanvas {

    Image badgeImage;

    public BadgeCanvas(String badgeImage) {
        try {

//            badgeImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.BADGE_IMAGE_LIST[badge.getId()]));

            this.badgeImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + badgeImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void redrawState() {
        super.redrawState();

        int containerWidth = (int) getPreferredSize().getWidth();
        int containerHeight = (int) getPreferredSize().getHeight();
        int imageWidth = badgeImage.getWidth(this);
        int imageHeight = badgeImage.getHeight(this);

        int imagePaddingTop = (containerHeight - imageHeight) / 2;
        int imagePaddingLeft = (containerWidth - imageWidth) / 2;
        Utilities.setHighQuality(graphics2D);

        graphics2D.drawImage(badgeImage, imagePaddingLeft, imagePaddingTop, imageWidth, imageHeight, this);
    }
}