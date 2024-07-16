
package levels;

import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Level1 {
    private static BufferedImage background;

    static {
        background = LoadImages.GetSprite(LoadImages.LEVEL_BG);
    }



    public static void render(Graphics g) {
        if (background!= null) {
            g.drawImage(background, 0, 0, 1024,768,null);
        } else {
            // Draw a default background or an error message
            g.setColor(Color.RED);
            g.drawString("Error loading background image", 10, 20);
        }
    }
}
