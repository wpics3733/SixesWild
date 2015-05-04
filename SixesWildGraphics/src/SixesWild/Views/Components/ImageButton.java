package SixesWild.Views.Components;

/**
 * Created by harryliu on 5/2/15.
 */

import SixesWild.Utilities;
import SixesWild.Views.Application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 *
 */
public class ImageButton extends StyledButton {

    //    Button normal image
    Image normalImage;
    //    Mouse enter image
    Image hoveredImage;
    //    Mouse pressed image
    Image activedImage;
    //    Disabled image
    Image disabledImage;
    //    Current image
    Image currentImage;


    /**
     * Initialize button information
     *
     * @param normalImage
     * @param hoveredImage
     * @param activedImage
     * @param disabledImage
     * @param normalBackColor
     * @param hoverBackColor
     * @param activeBackColor
     * @param disableBackColor
     */
    public ImageButton(String normalImage,
                       String hoveredImage,
                       String activedImage,
                       String disabledImage,
                       Color normalBackColor,
                       Color hoverBackColor,
                       Color activeBackColor,
                       Color disableBackColor) {
        super(normalBackColor, hoverBackColor, activeBackColor, disableBackColor);

        try {

            this.normalImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + normalImage));
            this.hoveredImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + hoveredImage));
            this.activedImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + activedImage));
            this.disabledImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + disabledImage));

            currentImage = this.normalImage;

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

    }


    @Override
    public void normal() {
        if(!super.isDisableState()) {
            currentImage = normalImage;
            super.normal();
        }
    }

    @Override
    public void actived() {
        currentImage = activedImage;
        super.actived();
    }

    @Override
    public void disabled() {
        currentImage = disabledImage;
        super.disabled();
    }

    @Override
    public void hovered() {
        if(!super.isDisableState()) {
            currentImage = hoveredImage;
            super.hovered();
        }
    }

    @Override
    public void redrawState() {
        super.redrawState();

        int containerWidth = (int) getPreferredSize().getWidth();
        int containerHeight = (int) getPreferredSize().getHeight();
        int imageWidth = currentImage.getWidth(this);
        int imageHeight = currentImage.getHeight(this);

        int imagePaddingTop = (containerHeight - imageHeight) / 2;
        int imagePaddingLeft = (containerWidth - imageWidth) / 2;
        Utilities.setHighQuality(graphics2D);

        graphics2D.drawImage(currentImage, imagePaddingLeft, imagePaddingTop, imageWidth, imageHeight, this);
    }
}
