package SixesWild;

import java.awt.*;

/**
 * Created by harryliu on 5/2/15.
 */
public class Utilities {

    /**
     * Set graphics to be highest rendering quality
     * @param g Target graphics
     */
    public static void setHighQuality(Graphics g) {
        RenderingHints qualityHints=new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        ((Graphics2D)g).setRenderingHints(qualityHints);
    }
}
