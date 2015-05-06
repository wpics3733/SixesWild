package SixesWild.Views.Components;

import SixesWild.Models.Value;
import SixesWild.Utilities;
import SixesWild.Views.IModelUpdated;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class IntegerView extends StyledLabel implements IModelUpdated{
    //    Space between integer and line
    final int GAP_INTEGER_LINE = 4;

    Value value;
    int thickness;

    public IntegerView(Value value, float fontSize, Color textColor, boolean isLeftAlign, int thickness) {
        super(value.toString(), fontSize, textColor, isLeftAlign);

        this.value = value;
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
        graphics2D.fillRect(PADDING_LEFT, textPaddingTop, (int) getMinimumSize().getWidth(), thickness);
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public void modelChanged() {
        setText(value.toString());
        super.modelChanged();
    }
}