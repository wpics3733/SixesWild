package SixesWild.Views.Components;

import SixesWild.Utilities;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

/**
 * Created by harryliu on 5/5/15.
 */
public class SpecialMoveButton extends ImageButton {

    //    Special move button size
    public static final Dimension SPECIAL_MOVE_BUTTON_SIZE = new Dimension(42, 42);

    //    Move left number size
    final int MOVE_LEFT_NUMBER_WIDTH = 16;
    final int MOVE_LEFT_NUMBER_HEIGHT = 16;

    //    Move left number font size
    final float MOVE_LEFT_NUMBER_FONT_SIZE = 12L;

    int moveLeft;

    public SpecialMoveButton(
            String normalImage,
            String hoveredImage,
            String activedImage,
            String disabledImage,
            Color normalBackColor,
            Color hoverBackColor,
            Color activeBackColor,
            Color disableBackColor,
            int moveLeft) {
        super(normalImage, hoveredImage, activedImage, disabledImage, normalBackColor, hoverBackColor, activeBackColor, disableBackColor);

        this.moveLeft = moveLeft;

        setPreferredSize(SPECIAL_MOVE_BUTTON_SIZE);
        setMaximumSize(SPECIAL_MOVE_BUTTON_SIZE);
        setMinimumSize(SPECIAL_MOVE_BUTTON_SIZE);
    }

    @Override
    public void redrawState() {
        ensureImageAvailable();
        graphics2D.setColor(currentBackColor);
        graphics2D.fillRect(
                PADDING_LEFT,
                PADDING_TOP + MOVE_LEFT_NUMBER_HEIGHT / 2,
                (int) getMinimumSize().getWidth() - MOVE_LEFT_NUMBER_WIDTH / 2,
                (int) getMinimumSize().getHeight() - MOVE_LEFT_NUMBER_HEIGHT / 2
        );

        int containerWidth = (int) getMinimumSize().getWidth();
        int containerHeight = (int) getMinimumSize().getHeight();
        int imageWidth = currentImage.getWidth(this);
        int imageHeight = currentImage.getHeight(this);

        int imagePaddingTop = (containerHeight - imageHeight) / 2;
        int imagePaddingLeft = (containerWidth - imageWidth) / 2;
        Utilities.setHighQuality(graphics2D);

        graphics2D.drawImage(
                currentImage,
                imagePaddingLeft,
                imagePaddingTop + MOVE_LEFT_NUMBER_HEIGHT / 2,
                imageWidth - MOVE_LEFT_NUMBER_WIDTH / 2,
                imageHeight - MOVE_LEFT_NUMBER_HEIGHT / 2,
                this
        );

//        Special move left number

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(
                (int) getMinimumSize().getWidth() - MOVE_LEFT_NUMBER_WIDTH,
                PADDING_TOP,
                MOVE_LEFT_NUMBER_WIDTH,
                MOVE_LEFT_NUMBER_HEIGHT
        );

        //  Setup font

        containerWidth = MOVE_LEFT_NUMBER_WIDTH;
        containerHeight = MOVE_LEFT_NUMBER_HEIGHT;

        String text = new Integer(moveLeft).toString();


        Utilities.normalFont = Utilities.normalFont.deriveFont(MOVE_LEFT_NUMBER_FONT_SIZE);

        Utilities.setHighQuality(graphics2D);

        FontMetrics metrics = graphics2D.getFontMetrics(Utilities.normalFont);
        int fontWidth = metrics.stringWidth(text);

        FontRenderContext renderContext = graphics2D.getFontRenderContext();
        GlyphVector glyphVector = Utilities.normalFont.createGlyphVector(renderContext, text);
        Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

        int textPaddingTop = (containerHeight - visualBounds.y) / 2;
        int textPaddingLeft = (containerWidth - fontWidth) / 2;

        graphics2D.setColor(currentBackColor.darker());
        graphics2D.setFont(Utilities.normalFont);
        graphics2D.drawString(
                text,
                (int) getMinimumSize().getWidth() - MOVE_LEFT_NUMBER_WIDTH + textPaddingLeft,
                PADDING_TOP + textPaddingTop
        );
    }
}
