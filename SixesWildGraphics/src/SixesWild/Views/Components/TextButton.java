package SixesWild.Views.Components;

import SixesWild.Utilities;
import SixesWild.Views.Application;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.io.File;

/**
 *
 */
public class TextButton extends StyledButton {

    //    Background padding left
    final int BACK_PADDING_LEFT = 0;
    //    Background padding top
    final int BACK_PADDING_TOP = 0;

    //    Text displayed on button
    String text;

    //    Background color of button in normal state
    Color normalTextColor;
    //    Background color of button in hovered state
    Color hoveredTextColor;
    //    Background color of button in actived state
    Color activedTextColor;
    //    Background color of button in disabled state
    Color disabledTextColor;
    //    Current text color
    Color currentTextColor;
    //    Current font of Text
    String currentFont;

    //    Font size of text
    float fontSize;

    public TextButton(
            String text,
            float fontSize,
            Color normalTextColor,
            Color hoveredTextColor,
            Color activedTextColor,
            Color disabledTextColor,
            Color normalBackColor,
            Color hoverBackColor,
            Color activeBackColor,
            Color disableBackColor) {

        super(normalBackColor, hoverBackColor, activeBackColor, disableBackColor);
        this.text = text;
        this.fontSize = fontSize;
        this.normalTextColor = normalTextColor;
        this.hoveredTextColor = hoveredTextColor;
        this.activedTextColor = activedTextColor;
        this.disabledTextColor = disabledTextColor;

        this.currentTextColor = normalTextColor;
    }

    @Override
    public void hovered() {
        currentTextColor = hoveredTextColor;
        super.hovered();
    }

    @Override
    public void normal() {
        currentTextColor = normalTextColor;
        super.normal();
    }

    @Override
    public void actived() {
        currentTextColor = activedTextColor;
        super.actived();
    }

    @Override
    public void disabled() {
        currentTextColor = disabledTextColor;
        super.disabled();
    }

    @Override
    public void redrawState() {
        super.redrawState();

        int containerWidth = (int) getMinimumSize().getWidth();
        int containerHeight = (int) getMinimumSize().getHeight();

        //  Setup font

        Utilities.normalFont= Utilities.normalFont.deriveFont(fontSize);

        Utilities.setHighQuality(graphics2D);

        FontMetrics metrics = graphics2D.getFontMetrics(Utilities.normalFont);
        int fontWidth = metrics.stringWidth(text);

        FontRenderContext renderContext = graphics2D.getFontRenderContext();
        GlyphVector glyphVector = Utilities.normalFont.createGlyphVector(renderContext, text);
        Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

        int textPaddingTop = (containerHeight - visualBounds.y) / 2;
        int textPaddingLeft = (containerWidth - fontWidth) / 2;

        graphics2D.setColor(currentTextColor);
        graphics2D.setFont(Utilities.normalFont);
        graphics2D.drawString(text, textPaddingLeft, textPaddingTop);
    }
}