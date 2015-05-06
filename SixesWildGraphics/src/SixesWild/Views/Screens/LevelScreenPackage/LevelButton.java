package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Components.LockableButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.io.File;

/**
 * Created by harryliu on 5/3/15.
 */
public class LevelButton extends LockableButton {

    Image lockedImage;
    String text;
    float fontSize;
    //    Background colors
    Color normalTextColor;
    Color hoveredTextColor;
    Color activedTextColor;
    Color disabledTextColor;

    Color currentTextColor;
    //    Current font of Text
    String currentFont;

    public LevelButton(
            String text,
            float fontSize,
            Color normalTextColor,
            Color hoveredTextColor,
            Color activedTextColor,
            Color disabledTextColor,
            Color normalBackColor,
            Color hoverBackColor,
            Color activeBackColor,
            Color disableBackColor,
            String lockedImage,
            boolean isLocked,
            int roundRadius) {
        super(
                normalBackColor,
                hoverBackColor,
                activeBackColor,
                disableBackColor,
                isLocked,
                roundRadius
        );

        this.text = text;
        this.fontSize = fontSize;
        this.normalTextColor = normalTextColor;
        this.hoveredTextColor = hoveredTextColor;
        this.activedTextColor = activedTextColor;
        this.disabledTextColor = disabledTextColor;

        this.currentTextColor = this.normalTextColor;

        try {
            this.lockedImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + lockedImage));
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
            Font font;

            try {

                font = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty(Application.ROOT_PATH) + currentFont));
                font = font.deriveFont(fontSize);

            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }

            Utilities.setHighQuality(getGraphics2D());


            FontMetrics metrics = getGraphics2D().getFontMetrics(font);
            int fontWidth = metrics.stringWidth(text);

            FontRenderContext renderContext = getGraphics2D().getFontRenderContext();
            GlyphVector glyphVector = font.createGlyphVector(renderContext, text);
            Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

            int textPaddingTop = (containerHeight - visualBounds.y) / 2;
            int textPaddingLeft = (containerWidth - fontWidth) / 2;

            getGraphics2D().setColor(currentTextColor);
            getGraphics2D().setFont(font);
            getGraphics2D().drawString(text, textPaddingLeft, textPaddingTop);

        } else {
            if(!isActiveState()) {
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
        if(!isLocked()) {
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
