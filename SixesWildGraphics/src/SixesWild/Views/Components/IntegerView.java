package SixesWild.Views.Components;

import SixesWild.Models.Value;
import SixesWild.Utilities;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class IntegerView extends StyledLabel {
    //    Space between integer and line
    final int GAP_INTEGER_LINE = 4;

    Value value;
    int thickness;

    public IntegerView(int value, float fontSize, Color textColor, boolean isLeftAlign, int thickness) {
        super(new Integer(value).toString(), fontSize, textColor, isLeftAlign);

        this.value = new Value(value);
        this.thickness = thickness;
    }

    @Override
    protected void redrawState() {
        super.redrawState();

        int containerHeight = (int) getMinimumSize().getHeight();

        Utilities.normalFont = Utilities.normalFont.deriveFont(fontSize);

        Utilities.setHighQuality(graphics2D);

        FontRenderContext renderContext = graphics2D.getFontRenderContext();
        GlyphVector glyphVector = Utilities.normalFont.createGlyphVector(renderContext, text);
        Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

        int textPaddingTop = (containerHeight + visualBounds.y) / 2 + visualBounds.height + GAP_INTEGER_LINE;

        graphics2D.setColor(textColor);
        graphics2D.fillRect(PADDING_LEFT, (int) textPaddingTop, (int) getMinimumSize().getWidth(), thickness);
    }

    public void increase(int amount) {
        value.increase(amount);
        repaint();
    }

    public void decrease(int amount) {
        value.decrease(amount);
        repaint();
    }
}