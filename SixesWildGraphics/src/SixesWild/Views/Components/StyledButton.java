package SixesWild.Views.Components;

import SixesWild.Utilities;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class StyledButton extends JComponent{

    //   Normal background color
    Color normalBackColor;
    //    Mouse enter background color
    Color hoveredBackColor;
    //    Mouse pressed background color
    Color activedBackColor;
    //    Disabled background color
    Color disabledBackColor;
    //  Status of button, true when active
    Color currentBackColor;
    //    BufferImage
    Image bufferImage;
    //    BufferGraphics
    Graphics2D graphics2D;
    //    Padding top
    final int PADDING_TOP = 0;
    //    Padding left
    final int PADDING_LEFT = 0;

    /**
     * @param normalBackColor  Normal background color
     * @param hoveredBackColor   Mouse enter background color
     * @param activedBackColor  Mouse pressed background color
     * @param disabledBackColor Disabled background color
     */
    public StyledButton(Color normalBackColor, Color hoveredBackColor, Color activedBackColor, Color disabledBackColor) {
        this.normalBackColor = normalBackColor;
        this.hoveredBackColor = hoveredBackColor;
        this.activedBackColor = activedBackColor;
        this.disabledBackColor = disabledBackColor;

        currentBackColor = normalBackColor;
    }

    /**
     * @return
     */
    public void normal() {
        currentBackColor = normalBackColor;
        repaint();
    }

    /**
     * @return
     */
    public void actived() {
        currentBackColor = activedBackColor;
        repaint();
    }

    /**
     * @return
     */
    public void disabled() {
        currentBackColor = disabledBackColor;
        repaint();
    }

    /**
     * @return
     */
    public void hovered() {
        currentBackColor = hoveredBackColor;
        repaint();
    }

    void ensureImageAvailable() {
        if (bufferImage == null) {
            bufferImage = this.createImage((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());

            if(bufferImage!=null) {
                graphics2D = (Graphics2D) bufferImage.getGraphics();
            }
        }
    }

    protected void redrawState() {
        ensureImageAvailable();

        graphics2D.setColor(currentBackColor);
        graphics2D.fillRect(PADDING_TOP, PADDING_LEFT, (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
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

    public Color getNormalBackColor() {
        return normalBackColor;
    }

    public void setNormalBackColor(Color normalBackColor) {
        this.normalBackColor = normalBackColor;
    }

    public Color getHoveredBackColor() {
        return hoveredBackColor;
    }

    public void setHoveredBackColor(Color hoveredBackColor) {
        this.hoveredBackColor = hoveredBackColor;
    }

    public Color getActivedBackColor() {
        return activedBackColor;
    }

    public void setActivedBackColor(Color activedBackColor) {
        this.activedBackColor = activedBackColor;
    }

    public Color getDisabledBackColor() {
        return disabledBackColor;
    }

    public void setDisabledBackColor(Color disabledBackColor) {
        this.disabledBackColor = disabledBackColor;
    }


}