package SixesWild.Views.Screens.AboutScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Utilities;
import SixesWild.Views.Application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by harryliu on 5/2/15.
 */
public class DeveloperIntroPicture extends Canvas {

    Image teamIntroductionImage;
    Image bufferedImage;
    Graphics2D graphics2D;

    public DeveloperIntroPicture() {
        try {
            this.teamIntroductionImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.TEAM_INTRODUCTION_IMAGE));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {

        if (g == null) {
            return;
        }

        Utilities.setHighQuality(g);
        g.drawImage(bufferedImage, 0, 0,
                (int) getPreferredSize().getWidth(),
                (int) getPreferredSize().getHeight(), this);
    }

    void ensureImageAvaliable() {
        if (bufferedImage == null) {
            bufferedImage = this.createImage(
                    (int) getPreferredSize().getWidth(),
                    (int) getPreferredSize().getHeight()
            );

            graphics2D = (Graphics2D) bufferedImage.getGraphics();
        }
    }

    void redrawState() {
        ensureImageAvaliable();
        int imageWidth = teamIntroductionImage.getWidth(this);
        int imageHeight = teamIntroductionImage.getHeight(this);

        int padddingLeft = ((int) getPreferredSize().getWidth() - imageWidth) / 2;
        int padddingTop = ((int) getPreferredSize().getHeight() - imageHeight) / 2;

        Utilities.setHighQuality(graphics2D);

        graphics2D.drawImage(teamIntroductionImage, padddingLeft, padddingTop, imageWidth, imageHeight, this);
    }

    @Override
    public void repaint() {
        redrawState();
        super.repaint();
    }
}
