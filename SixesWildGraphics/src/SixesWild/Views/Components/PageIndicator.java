package SixesWild.Views.Components;


import SixesWild.Contracts.ImageContract;
import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Screens.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 */
public class PageIndicator extends Canvas {

    //    Image paddings
    final int PADDING_TOP = 0;
    final int PADDING_LEFT = 0;

    //    Padding space between inactive indicators
    final int INACTIVE_INDICATOR_GAP = 12;

    //    Difference between distance between active indicators and distance between inactive Indicator
    final int DISTANCE_DIFFERENCE = 4;

    int current;
    int total;
    Image tabActiveImage;
    Image tabInactiveImage;

    BufferedImage bufferedImage;
    Graphics2D graphics2D;

    public PageIndicator(int current, int total) {
        this.current = current;
        this.total = total;

        try {
            tabActiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.PAGE_INDICATOR_TAB_ACTIVE_IMAGE));
            tabInactiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.PAGE_INDICATOR_TAB_INACTIVE_IMAGE));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void nextPage() {
        if (current < total) {
            current++;
            repaint();
        }
    }

    public void lastPage() {
        if (current > 0) {
            current--;
            repaint();
        }
    }

    void ensureImageAvailable() {
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(
                    (int) getMinimumSize().getWidth(),
                    (int) getMinimumSize().getHeight(),
                    BufferedImage.TYPE_4BYTE_ABGR
            );

            graphics2D = (Graphics2D) bufferedImage.getGraphics();
        }
    }

    void redrawState() {
        ensureImageAvailable();
        Utilities.setHighQuality(graphics2D);

        graphics2D.setColor(Screen.SCREEN_BACK_COLOR);

        graphics2D.fillRect(
                PADDING_LEFT,
                PADDING_TOP,
                (int) getPreferredSize().getWidth(),
                (int) getPreferredSize().getHeight()
        );

        int paddingLeft = (int) (getMinimumSize().getWidth() / 2 - (total / 2.0 * tabInactiveImage.getWidth(this) + INACTIVE_INDICATOR_GAP));

        for (int page = 0; page < total; page++) {
            if (page == current) {
                int paddingTop = (int) ((getMinimumSize().getHeight() - tabActiveImage.getHeight(this)) / 2);
                int activePaddingLeft = paddingLeft - DISTANCE_DIFFERENCE;
                graphics2D.drawImage(
                        tabActiveImage,
                        activePaddingLeft,
                        paddingTop,
                        tabActiveImage.getWidth(this),
                        tabActiveImage.getHeight(this),
                        this
                );
            } else {
                int paddingTop = (int) ((getMinimumSize().getHeight() - tabInactiveImage.getHeight(this)) / 2);
                graphics2D.drawImage(
                        tabInactiveImage,
                        paddingLeft,
                        paddingTop,
                        tabInactiveImage.getWidth(this),
                        tabInactiveImage.getHeight(this),
                        this
                );
            }
            paddingLeft += tabInactiveImage.getWidth(this) + INACTIVE_INDICATOR_GAP;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (g == null) {
            return;
        }

        Utilities.setHighQuality(g);
        g.drawImage(bufferedImage, PADDING_LEFT, PADDING_TOP, bufferedImage.getWidth(), bufferedImage.getHeight(), this);
    }

    @Override
    public void repaint() {
        redrawState();
        super.repaint();
    }
}