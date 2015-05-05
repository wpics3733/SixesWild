package SixesWild.Views.Components;

import SixesWild.Utilities;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;


/**
 * Created by harryliu on 5/2/15.
 */
public class StyledLabel extends BufferedComponent {

    //    Color of text
    protected Color textColor;
    //    Label text
    protected String text;
    //    Font size of text
    protected float fontSize;
    //    font width;
    protected int fontWidth;

    //    Left align
    boolean isLeftAlign = false;

    public StyledLabel(String text, float fontSize, Color textColor, boolean isLeftAlign) {
        this.text = text;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.isLeftAlign = isLeftAlign;
    }

    protected void redrawState() {
        super.redrawState();

        int containerWidth = (int) getMinimumSize().getWidth();
        int containerHeight = (int) getMinimumSize().getHeight();

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
        graphics2D.fillRect(0, 0, (int) getMinimumSize().getWidth(), (int) getMinimumSize().getHeight());

        graphics2D.setColor(textColor);
        graphics2D.setFont(Utilities.normalFont);
        graphics2D.drawString(text, textPaddingLeft, textPaddingTop);
    }


//    Getters and setters

    public void setText(String text) {
        this.text = text;
    }
}
