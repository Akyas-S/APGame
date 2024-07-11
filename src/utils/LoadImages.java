package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImages {

    public static final String PLAYER_SPRITE = "cat2/catsprite.png";
    public static final String LEVEL_BG = "levels/beach level.png";
    public static final String Startbtnimg = "Menubuttons/start.png";
    public static final String Storebtnimg = "Menubuttons/store.png";
    public static final String Settingsbtnimg = "Menubuttons/settings.png";
    public static final String Exitbtnimg = "Menubuttons/exit.png";
    public static final String Menuimg = "Menubuttons/menu.png";
    public static final String Settingsimg = "Settingsbuttons/Settingsbg.png";
    public static final String Audiobtnimg = "Settingsbuttons/audiobtn.png";
    public static final String Closebtnimg = "Settingsbuttons/closebtn.png";
    public static final String Controlsbtnimg = "Settingsbuttons/controlsbtn.png";
    public static final String Videobtnimg = "Settingsbuttons/videobtn.png";

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
