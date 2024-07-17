package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImages {

    public static final String PLAYER_SPRITE = "cat2/catsprite.png";
    public static final String LEVEL_BG = "levels/beach level.png";
    public static final String Startbtnimg = "MenuUI/start.png";
    public static final String Storebtnimg = "MenuUI/store.png";
    public static final String Settingsbtnimg = "MenuUI/settings.png";
    public static final String Exitbtnimg = "MenuUI/exit.png";
    public static final String Menuimg = "MenuUI/menu.png";
    public static final String Settingsimg = "SettingsUI/Settingsbg.png";
    public static final String Audiobtnimg = "SettingsUI/audiobtn.png";
    public static final String Closebtnimg = "SettingsUI/closebtn.png";
    public static final String Controlsbtnimg = "SettingsUI/controlsbtn.png";
    public static final String Videobtnimg = "SettingsUI/videobtn.png";
    public static final String Audioimg = "AudioUI/Audiobg.png";
    public static final String Checkbtnimg = "AudioUI/check.png";
    public static final String Crossbtnimg = "AudioUI/cross.png";
    public static final String Controlsimg = "ControlsUI/Controlsbg.png";
    public static final String Keybtnimg = "ControlsUI/keyicon.png";
    public static final String Pauseimg = "PauseUI/PauseMenu.png";
    public static final String Resumebtnimg = "PauseUI/resumebtn.png";
    public static final String Settpsimg = "PauseUI/settps.png";
    public static final String Quitbtnimg = "PauseUI/quitbtn.png";

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
