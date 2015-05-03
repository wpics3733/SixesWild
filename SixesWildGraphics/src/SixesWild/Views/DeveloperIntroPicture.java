package SixesWild.Views;

import SixesWild.Contracts.ImageContract;
import SixesWild.Utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by harryliu on 5/2/15.
 */
public class DeveloperIntroPicture extends Canvas {

    Image teamIntroductionImage;

    public DeveloperIntroPicture() {
        try {
            this.teamIntroductionImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.TEAM_INTRODUCTION_IMAGE));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {

        int imageWidth = teamIntroductionImage.getWidth(this);
        int imageHeight = teamIntroductionImage.getHeight(this);

        int padddingLeft = ((int) getPreferredSize().getWidth() - imageWidth) / 2;
        int padddingTop = ((int) getPreferredSize().getHeight() - imageHeight) / 2;

        Utilities.setHighQuality(g);

        g.drawImage(teamIntroductionImage, padddingLeft, padddingTop, imageWidth, imageHeight, this);
    }
}
