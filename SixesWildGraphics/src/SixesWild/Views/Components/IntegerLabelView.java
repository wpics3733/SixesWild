package SixesWild.Views.Components;

import javax.swing.*;
import java.awt.*;

public class IntegerLabelView extends JPanel {

//    Center align
    final boolean CENTER_ALIGN = false;

    //    Padding top
    final int PADDING_TOP = 0;

    //    Padding left
    final int PADDING_LEFT = 0;

    String text;
    int value;
    int thickness;
    float fontSize;
    Color textColor;
    boolean isLeftAlign;
    int textWidth;

    StyledLabel label;
    IntegerView integerView;

    public IntegerLabelView(
            String text,
            int value,
            int thickness,
            float fontSize,
            Color textColor,
            boolean isLeftAlign,
            int textWidth) {
        this.text = text;
        this.value = value;
        this.thickness = thickness;
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.isLeftAlign = isLeftAlign;
        this.textWidth = textWidth;
    }

    public void initialize() {
        setLayout(null);
        setBackground(getParent().getBackground());

        this.label = new StyledLabel(text, fontSize, textColor, isLeftAlign);
        label.setPreferredSize(new Dimension(textWidth, (int) getMinimumSize().getHeight()));
        label.setMaximumSize(new Dimension(textWidth, (int) getMinimumSize().getHeight()));
        label.setMinimumSize(new Dimension(textWidth, (int) getMinimumSize().getHeight()));
        label.setBounds(PADDING_LEFT, PADDING_TOP, textWidth, (int) getMinimumSize().getHeight());
        add(label);
        label.repaint();

        this.integerView = new IntegerView(value, fontSize, textColor, CENTER_ALIGN, thickness);
        integerView.setPreferredSize(new Dimension((int) getMinimumSize().getWidth() - textWidth, (int) getMinimumSize().getHeight()));
        integerView.setMaximumSize(new Dimension((int) getMinimumSize().getWidth() - textWidth, (int) getMinimumSize().getHeight()));
        integerView.setMinimumSize(new Dimension((int) getMinimumSize().getWidth() - textWidth, (int) getMinimumSize().getHeight()));
        integerView.setBounds(PADDING_LEFT + textWidth, PADDING_TOP, (int) getMinimumSize().getWidth() - textWidth, (int) getMinimumSize().getHeight());
        add(integerView);
        integerView.repaint();
    }

    public void increase(int amount) {
        integerView.increase(amount);
    }

    public void decrease(int amount) {
        integerView.decrease(amount);
    }
}