package SixesWild.Views.Components;

import SixesWild.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 */
public class StyledButton extends JComponent {

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
    BufferedImage bufferImage;
    //    BufferGraphics
    Graphics2D graphics2D;
    //    Padding top
    final int PADDING_TOP = 0;
    //    Padding left
    final int PADDING_LEFT = 0;

    boolean activeState;

    boolean disableState;

    /**
     * @param normalBackColor   Normal background color
     * @param hoveredBackColor  Mouse enter background color
     * @param activedBackColor  Mouse pressed background color
     * @param disabledBackColor Disabled background color
     */
    public StyledButton(Color normalBackColor, Color hoveredBackColor, Color activedBackColor, Color disabledBackColor) {
        this.normalBackColor = normalBackColor;
        this.hoveredBackColor = hoveredBackColor;
        this.activedBackColor = activedBackColor;
        this.disabledBackColor = disabledBackColor;
        this.activeState = false;
        this.disableState = false;

        currentBackColor = normalBackColor;
    }

    /**
     * @return
     */
    public void normal() {
        if (!activeState && !disableState) {
            currentBackColor = normalBackColor;
            repaint();
        }
    }

    /**
     * @return
     */
    public void actived() {
        activeState = true;
        disableState = false;

        currentBackColor = activedBackColor;
        repaint();
    }

    public void inactive() {
        this.activeState = false;
        normal();
    }

    /**
     * @return
     */
    public void disabled() {
        if (!activeState) {
            disableState = true;
            this.activeState = false;

            currentBackColor = disabledBackColor;
            repaint();
        }
    }

    public void enabled() {
        if (!activeState) {
            disableState = false;
            normal();
            repaint();
        }
    }

    /**
     * @return
     */
    public void hovered() {
        if (!activeState && !disableState) {
            currentBackColor = hoveredBackColor;
            repaint();
        }
    }

    public void ensureImageAvailable() {
        if (bufferImage == null) {

            int width = (int) getMinimumSize().getWidth();
            int height = (int) getMinimumSize().getHeight();

            bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            graphics2D = (Graphics2D) bufferImage.getGraphics();
        }
    }

    public void redrawState() {
        ensureImageAvailable();

        graphics2D.setColor(currentBackColor);
        graphics2D.fillRect(PADDING_TOP, PADDING_LEFT, (int) getMinimumSize().getWidth(), (int) getMinimumSize().getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }

        Utilities.setHighQuality(g);

        g.drawImage(bufferImage, PADDING_TOP, PADDING_LEFT, (int) getMinimumSize().getWidth(), (int) getMinimumSize().getHeight(), this);
    }

    @Override
    public void repaint() {
        redrawState();
        super.repaint();
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

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public Color getCurrentBackColor() {
        return currentBackColor;
    }

    public void setCurrentBackColor(Color currentBackColor) {
        this.currentBackColor = currentBackColor;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    public boolean isDisableState() {
        return disableState;
    }
}