package SixesWild.Views.Screens.AboutScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Components.BufferedCanvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by harryliu on 5/2/15.
 */
public class DeveloperIntroPicture extends BufferedCanvas {

    Image teamIntroductionImage;

    public DeveloperIntroPicture() {
        try {
            this.teamIntroductionImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.TEAM_INTRODUCTION_IMAGE));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    protected void redrawState() {

        super.redrawState();

        int imageWidth = teamIntroductionImage.getWidth(this);
        int imageHeight = teamIntroductionImage.getHeight(this);

        int padddingLeft = ((int) getPreferredSize().getWidth() - imageWidth) / 2;
        int padddingTop = ((int) getPreferredSize().getHeight() - imageHeight) / 2;

        graphics2D.drawImage(teamIntroductionImage, padddingLeft, padddingTop, imageWidth, imageHeight, this);
    }
}
