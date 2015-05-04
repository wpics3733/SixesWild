package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Models.Badge;
import SixesWild.Utilities;
import SixesWild.Views.Application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 */
public class BadgeCanvas extends Canvas {

//    Paddings
    final int PADDING_LEFT = 0;
    final int PADDING_TOP = 0;

    Image badgeImage;

    BufferedImage bufferedImage;
    Graphics2D graphics2D;

    public BadgeCanvas(String badgeImage) {
        try {

//            badgeImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.BADGE_IMAGE_LIST[badge.getId()]));

            this.badgeImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + badgeImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void repaint() {
        redrawState();
        super.repaint();
    }

    void ensureImageAvailable() {
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(
                    (int) this.getMinimumSize().getWidth(),
                    (int) this.getMinimumSize().getHeight(),
                    BufferedImage.TYPE_4BYTE_ABGR
            );

            graphics2D = (Graphics2D) bufferedImage.getGraphics();
        }
    }

    void redrawState() {
        ensureImageAvailable();

        int containerWidth = (int) getPreferredSize().getWidth();
        int containerHeight = (int) getPreferredSize().getHeight();
        int imageWidth = badgeImage.getWidth(this);
        int imageHeight = badgeImage.getHeight(this);

        int imagePaddingTop = (containerHeight - imageHeight) / 2;
        int imagePaddingLeft = (containerWidth - imageWidth) / 2;
        Utilities.setHighQuality(graphics2D);

        graphics2D.drawImage(badgeImage, imagePaddingLeft, imagePaddingTop, imageWidth, imageHeight, this);
    }

    @Override
    public void paint(Graphics g) {
        if(g == null) {
            return;
        }

        g.drawImage(bufferedImage,PADDING_LEFT,PADDING_TOP,(int)bufferedImage.getWidth(),(int)bufferedImage.getHeight(), this);
    }
}