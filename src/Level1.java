package levels;

import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Level1 {


    public static void render(Graphics g){
        BufferedImage img = LoadImages.GetSprite(LoadImages.LEVEL_BG);

        g.drawImage(img, 0,0,1920,1080,null);
    }
}
