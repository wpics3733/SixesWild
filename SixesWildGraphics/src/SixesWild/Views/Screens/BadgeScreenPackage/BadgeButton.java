package SixesWild.Views.Screens.BadgeScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Components.LockableButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by harryliu on 5/4/15.
 */
public class BadgeButton extends LockableButton {
    Image lockedImage;
    int badgeCode;
    Image badgeImage;

    //    Background colors
    Color normalTextColor;
    Color hoveredTextColor;
    Color activedTextColor;
    Color disabledTextColor;

    Color currentTextColor;
    //    Current font of Text
    String currentFont;

    public BadgeButton(
            int badgeCode,
            Color normalTextColor,
            Color hoveredTextColor,
            Color activedTextColor,
            Color disabledTextColor,
            Color normalBackColor,
            Color hoverBackColor,
            Color activeBackColor,
            Color disableBackColor,
            String lockedImage,
            boolean isLocked) {
        super(
                normalBackColor,
                hoverBackColor,
                activeBackColor,
                disableBackColor,
                isLocked
        );

        this.badgeCode = badgeCode;
        this.normalTextColor = normalTextColor;
        this.hoveredTextColor = hoveredTextColor;
        this.activedTextColor = activedTextColor;
        this.disabledTextColor = disabledTextColor;

        this.currentTextColor = this.normalTextColor;

        try {
            this.lockedImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + lockedImage));
            this.badgeImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.BADGE_IMAGE_LIST[badgeCode]));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setRegularFont();
    }

    @Override
    public void redrawState() {
        int containerWidth = (int) getMinimumSize().getWidth();
        int containerHeight = (int) getMinimumSize().getHeight();
        if (isLocked() == false) {

            super.redrawState();
            //  Setup font

            int imageWidth = badgeImage.getWidth(this);
            int imageHeight = badgeImage.getHeight(this);

            int imagePaddingTop = (containerHeight - imageHeight) / 2;
            int imagePaddingLeft = (containerWidth - imageWidth) / 2;

            Utilities.setHighQuality(getGraphics2D());

            getGraphics2D().drawImage(badgeImage, imagePaddingLeft, imagePaddingTop, imageWidth, imageHeight, this);

        } else

        {
            if (!isActiveState()) {
                setCurrentBackColor(getDisabledBackColor());
            }
            super.redrawState();

            int imageWidth = lockedImage.getWidth(this);
            int imageHeight = lockedImage.getHeight(this);

            int imagePaddingTop = (containerHeight - imageHeight) / 2;
            int imagePaddingLeft = (containerWidth - imageWidth) / 2;

            Utilities.setHighQuality(getGraphics2D());

            getGraphics2D().drawImage(lockedImage, imagePaddingLeft, imagePaddingTop, imageWidth, imageHeight, this);
        }

    }

    @Override
    public void hovered() {
        if (!isLocked()) {
            super.hovered();
        } else {
            setCurrentBackColor(LOCKED_BACK_COLOR);
            repaint();
        }
    }

    @Override
    public void normal() {
        if (!isLocked()) {
            super.normal();
        } else {
            disabled();
        }
    }

    @Override
    public void actived() {
        if (!isLocked()) {
            super.actived();
        } else {
            setActiveState(true);
            setCurrentBackColor(LOCKED_BACK_COLOR);
            repaint();
        }
    }

    @Override
    public void disabled() {
        super.disabled();
    }

    @Override
    public void unlock() {
        super.unlock();
        normal();
    }

    @Override
    public void lock() {
        super.lock();
        disabled();
    }

    public void setRegularFont() {
        currentFont = Application.REGULAR_FONT_LOCATION;
    }

    public void setItalicFont() {
        currentFont = Application.ITALIC_FONT_LOCATION;
    }

    public void setBoldFont() {
        currentFont = Application.BOLD_FONT_LOCATION;
    }
}
