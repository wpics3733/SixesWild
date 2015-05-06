package SixesWild.Views.Components;

import SixesWild.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 */
public class StyledButton extends BufferedComponent {

    //   Normal background color
    protected Color normalBackColor;
    //    Mouse enter background color
    protected Color hoveredBackColor;
    //    Mouse pressed background color
    protected Color activedBackColor;
    //    Disabled background color
    protected Color disabledBackColor;
    //  Status of button, true when active
    protected Color currentBackColor;

    boolean activeState;

    boolean disableState;

    int roundRadius;

    /**
     * @param normalBackColor   Normal background color
     * @param hoveredBackColor  Mouse enter background color
     * @param activedBackColor  Mouse pressed background color
     * @param disabledBackColor Disabled background color
     */
    public StyledButton(Color normalBackColor, Color hoveredBackColor, Color activedBackColor, Color disabledBackColor,int roundRadius) {
        this.normalBackColor = normalBackColor;
        this.hoveredBackColor = hoveredBackColor;
        this.activedBackColor = activedBackColor;
        this.disabledBackColor = disabledBackColor;
        this.activeState = false;
        this.disableState = false;
        this.roundRadius = roundRadius;

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

    public void redrawState() {
        super.redrawState();

        graphics2D.setColor(currentBackColor);
        graphics2D.fillRoundRect(
                PADDING_TOP,
                PADDING_LEFT,
                (int) getMinimumSize().getWidth(),
                (int) getMinimumSize().getHeight(),
                roundRadius,
                roundRadius
        );

    }

    //    Getters and setters

    public Color getDisabledBackColor() {
        return disabledBackColor;
    }


    public Graphics2D getGraphics2D() {
        return graphics2D;
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