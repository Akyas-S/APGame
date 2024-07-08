package levels;

import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Level1 {

    private BufferedImage img = LoadImages.GetSprite(LoadImages.LEVEL_BG);
    public void render(Graphics g){

        g.drawImage(img, 0,0,null);
    }
}
