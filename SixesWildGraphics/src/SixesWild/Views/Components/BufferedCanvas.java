package SixesWild.Views.Components;

import SixesWild.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by harryliu on 5/4/15.
 */
public class BufferedCanvas extends Canvas {

    //    Padding top
    protected final int PADDING_TOP = 0;
    //    Padding left
    protected final int PADDING_LEFT = 0;

    protected BufferedImage bufferedImage;
    protected Graphics2D graphics2D;

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

    protected void redrawState() {
        ensureImageAvailable();
        Utilities.setHighQuality(graphics2D);
    }

    public void paint(Graphics g) {
        if(g==null) {
            return;
        }

        Utilities.setHighQuality(g);

        g.drawImage(bufferedImage, PADDING_TOP, PADDING_LEFT, (int) getMinimumSize().getWidth(), (int) getMinimumSize().getHeight(), this);
    }

    public void repaint() {
        redrawState();
        super.repaint();
    }
}
