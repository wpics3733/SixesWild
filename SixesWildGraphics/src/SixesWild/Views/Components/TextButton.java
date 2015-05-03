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
            Color textColor,
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

        normal();
        setRegularFont();
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
    protected void redrawState() {
        super.redrawState();

        int containerWidth = (int) getPreferredSize().getWidth();
        int containerHeight = (int) getPreferredSize().getHeight();

        //  Setup font
        Font font;

        try {

            font = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty(Application.ROOT_PATH) + currentFont));
            font = font.deriveFont(fontSize);

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        Utilities.setHighQuality(graphics2D);

        FontMetrics metrics = graphics2D.getFontMetrics(font);
        int fontWidth = metrics.stringWidth(text);

        FontRenderContext renderContext = graphics2D.getFontRenderContext();
        GlyphVector glyphVector = font.createGlyphVector(renderContext, text);
        Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

        int textPaddingTop = (containerHeight - visualBounds.y) / 2;
        int textPaddingLeft = (containerWidth - fontWidth) / 2;

        graphics2D.setColor(this.getParent().getBackground());
        graphics2D.fillRect(0, 0, (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());

        graphics2D.setColor(currentTextColor);
        graphics2D.setFont(font);
        graphics2D.drawString(text, textPaddingLeft, textPaddingTop);
    }

//    Getters and setters

    public Color getNormalTextColor() {
        return normalTextColor;
    }

    public void setNormalTextColor(Color normalTextColor) {
        this.normalTextColor = normalTextColor;
    }

    public Color getHoveredTextColor() {
        return hoveredTextColor;
    }

    public void setHoveredTextColor(Color hoveredTextColor) {
        this.hoveredTextColor = hoveredTextColor;
    }

    public Color getActivedTextColor() {
        return activedTextColor;
    }

    public void setActivedTextColor(Color activedTextColor) {
        this.activedTextColor = activedTextColor;
    }

    public Color getDisabledTextColor() {
        return disabledTextColor;
    }

    public void setDisabledTextColor(Color disabledTextColor) {
        this.disabledTextColor = disabledTextColor;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}