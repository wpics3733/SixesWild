package SixesWild.Views.Components;

import java.awt.*;

/**
 *
 */
public abstract class StarsView {

    /**
     *
     */
    int star;
    /**
     *
     */
    Image bufferedImage;
    /**
     *
     */
    String starImage;

    /**
     *
     */
    public StarsView() {
    }

    /**
     *
     */
    public void StarView() {
        // TODO implement here
    }

    /**
     * @param Graphics g
     * @return
     */
    abstract void drawOneStar(Graphics g);

    /**
     * @param Graphics g
     * @return
     */
    abstract void drawTwoStars(Graphics g);

    /**
     * @param Graphics g
     * @return
     */
    abstract void drawThreeStars(Graphics g);

    /**
     * @return
     */
    public abstract void getMinimunSize();

    /**
     * @return
     */
    public abstract void getMaximunSize();

    /**
     * @return
     */
    public abstract void getPreferredSize();

    /**
     * @param Graphics g
     * @return
     */
    public void paint(Graphics g) {
        // TODO implement here
        return;
    }

}