package SixesWild;

import SixesWild.Views.Application;

import java.awt.*;
import java.io.File;

/**
 * Created by harryliu on 5/2/15.
 */
public class Utilities {

    public static Font normalFont;
    /**
     * Set graphics to be highest rendering quality
     * @param g Target graphics
     */
    public static void setHighQuality(Graphics g) {
        RenderingHints qualityHints=new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        ((Graphics2D)g).setRenderingHints(qualityHints);
    }

    public static void loadFont(){
        try {

            normalFont = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty(Application.ROOT_PATH) + Application.REGULAR_FONT_LOCATION));

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
