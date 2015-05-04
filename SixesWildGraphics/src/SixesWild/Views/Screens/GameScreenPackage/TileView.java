package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Tile;
import SixesWild.Utilities;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 */
public class TileView extends Canvas {
    //    Tile view size
    public static final Dimension TILE_VIEW_SIZE = new Dimension(56, 56);

    //    Tile font size
    final float FONT_SIZE = 28L;

    //    Tile background color
    final Color[] TILE_BACK_COLOR = {
            new Color(236, 113, 113),
            new Color(248, 160, 15),
            new Color(208, 87, 166),
            new Color(114, 174, 114),
            new Color(62, 152, 199),
            new Color(124, 62, 182)
    };

    //    Rounded arc x
    final int ROUNDED_ARC_X = 10;
    //    Rounded arc y
    final int ROUNDED_ARC_Y = 10;

    //    Paddings
    final int PADDING_TOP = 0;
    final int PADDING_LEFT = 0;

    //    Multiplier font size
    final float MULTIPLIER_FONT_SIZE = 12L;

    //    Multiply sign
    final String MULTIPLY_SIGN = "×";

    //    Multiplier padding
    final int MULTIPLIER_PADDING_RIGHT = 5;
    final int MULTIPLIER_PADDING_BOTTOM = 5;

    Tile tile;
    BufferedImage bufferedImage;
    Graphics2D graphics2D;

    int tileNum;
    int multiplier;

    public TileView(Tile tile) {
        this.tile = tile;

        setPreferredSize(TILE_VIEW_SIZE);
        setMaximumSize(TILE_VIEW_SIZE);
        setMinimumSize(TILE_VIEW_SIZE);

        setBackground(Color.WHITE);

        Random random = new Random();
        tileNum = random.nextInt(6) + 1;
        multiplier = random.nextInt(3) + 1;
    }

    void ensureImageAvailable() {
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(
                    (int) TILE_VIEW_SIZE.getWidth(),
                    (int) TILE_VIEW_SIZE.getHeight(),
                    BufferedImage.TYPE_4BYTE_ABGR
            );

            graphics2D = (Graphics2D) bufferedImage.getGraphics();
        }
    }

    public void redrawState() {
        ensureImageAvailable();

        graphics2D.setColor(TILE_BACK_COLOR[tileNum - 1]);

        graphics2D.fillRoundRect(
                PADDING_LEFT,
                PADDING_TOP,
                (int) TILE_VIEW_SIZE.getWidth(),
                (int) TILE_VIEW_SIZE.getHeight(),
                ROUNDED_ARC_X,
                ROUNDED_ARC_Y);

        Utilities.setHighQuality(graphics2D);

//        Setup font
        Utilities.normalFont = Utilities.normalFont.deriveFont(FONT_SIZE);

        int containerWidth = (int) getMinimumSize().getWidth();
        int containerHeight = (int) getMinimumSize().getHeight();
        String text = new Integer(tileNum).toString();

        FontMetrics metrics = graphics2D.getFontMetrics(Utilities.normalFont);
        int fontWidth = metrics.stringWidth(text);

        FontRenderContext renderContext = graphics2D.getFontRenderContext();
        GlyphVector glyphVector = Utilities.normalFont.createGlyphVector(renderContext, text);
        Rectangle visualBounds = glyphVector.getVisualBounds().getBounds();

        int textPaddingTop = (containerHeight - visualBounds.y) / 2;
        int textPaddingLeft = (containerWidth - fontWidth) / 2;

        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(Utilities.normalFont);
        graphics2D.drawString(text, textPaddingLeft, textPaddingTop);


//        Draw multiplier
        text = MULTIPLY_SIGN + new Integer(multiplier).toString();
        Utilities.normalFont = Utilities.normalFont.deriveFont(MULTIPLIER_FONT_SIZE);
        metrics = graphics2D.getFontMetrics(Utilities.normalFont);
        fontWidth = metrics.stringWidth(text);

        renderContext = graphics2D.getFontRenderContext();
        glyphVector = Utilities.normalFont.createGlyphVector(renderContext, text);
        visualBounds = glyphVector.getVisualBounds().getBounds();

        textPaddingTop = containerHeight - visualBounds.y - visualBounds.height - MULTIPLIER_PADDING_BOTTOM;
        textPaddingLeft = containerWidth - fontWidth - MULTIPLIER_PADDING_RIGHT;

        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(Utilities.normalFont);
        graphics2D.drawString(text, textPaddingLeft, textPaddingTop);
    }

    @Override
    public void paint(Graphics g) {
        if (g == null) {
            return;
        }

        if (bufferedImage == null) {
            redrawState();
        }

        g.setColor(Color.WHITE);
        g.fillRect(PADDING_LEFT, PADDING_TOP, bufferedImage.getWidth(),bufferedImage.getHeight());

//        Utilities.setHighQuality(g);
        g.drawImage(bufferedImage, PADDING_LEFT,PADDING_TOP, bufferedImage.getWidth(), bufferedImage.getHeight(), this);
    }

    @Override
    public void repaint() {
        redrawState();
        super.repaint();
    }
}