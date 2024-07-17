package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImages {

    public static final String PLAYER_SPRITE = "cat2/catsprite.png";
    public static final String LEVEL_BG = "levels/beach level.png";
    public static final String PIRATE_SPRITE = "cat2/crabby_sprite.png";


    // static method because it will called often
    public static BufferedImage GetSprite(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadImages.class.getResourceAsStream("/" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }

}
