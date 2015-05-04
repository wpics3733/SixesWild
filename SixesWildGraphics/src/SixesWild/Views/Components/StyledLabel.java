package SixesWild.Views.Components;

import SixesWild.Utilities;
import SixesWild.Views.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.io.File;


/**
 * Created by harryliu on 5/2/15.
 */
public class StyledLabel extends JComponent {
    //    Padding top
    final int PADDING_TOP = 0;
    //    Padding left
    final int PADDING_LEFT = 0;

    //    Current font of text
    String currentFont;
    //    Color of text
    Color textColor;
    //    Label text
    String text;
    //    Font size of text
    float fontSize;
    //    font width;
    int fontWidth;

    //    BufferImage
    Image bufferImage;
    //    BufferGraphics
    Graphics2D graphics2D;
    //    Left align
    boolean isLeftAlign = false;

    public StyledLabel(String text, float fontSize, Color textColor,boolean isLeftAlign) {
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.isLeftAlign = isLeftAlign;
    }

    protected void ensureImageAvailable() {
        if (bufferImage == null) {
            bufferImage = this.createImage((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
            graphics2D = (Graphics2D) bufferImage.getGraphics();
        }
    }

    protected void redrawState() {
        ensureImageAvailable();

        int containerWidth = (int) getPreferredSize().getWidth();
        int containerHeight = (int) getPreferredSize().getHeight();

        Utilities.normalFont = Utilities.normalFont.deriveFont(fontSize);

        Utilities.setHighQuality(graphics2D);

        FontMetrics metrics = graphics2D.getFontMetrics(Utilities.normalFont);
        fontWidth = metrics.stringWidth(text);

        FontRenderContext renderContext = graphics2D.getFontRenderContext();
        GlyphVector glyphVector = Utilities.normalFont.createGlyphVector(renderContext, text);
        Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

        int textPaddingTop = (containerHeight - visualBounds.y) / 2;
        int textPaddingLeft;
        if (!isLeftAlign) {
            textPaddingLeft = (containerWidth - fontWidth) / 2;
        } else {
            textPaddingLeft = 0;
        }

        graphics2D.setColor(this.getParent().getBackground());
        graphics2D.fillRect(0, 0, (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());

        graphics2D.setColor(textColor);
        graphics2D.setFont(Utilities.normalFont);
        graphics2D.drawString(text, textPaddingLeft, textPaddingTop);
    }

    @Override
    protected void paintComponent(Graphics g) {

        if (g == null) {
            return;
        }

        redrawState();

        Utilities.setHighQuality(g);

        g.drawImage(bufferImage, PADDING_TOP, PADDING_LEFT, (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight(), this);
    }

//    Getters and setters

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
