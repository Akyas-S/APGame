package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImages {

    public static final String PLAYER_SPRITE = "cat2/catsprite.png";
    public static final String LEVEL1_BG = "levels/beach level.png";
    public static final String LEVEL2_BG = "levels/map 2.png";
    public static final String PIRATE_GHOST = "cat2/rat ghost.png";
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
    public static final String Pausebtnicon = "levels/pausebtn.png";
    public static final String Storebg = "StoreUI/Storebg.png";
    public static final String PLAYER_HUD = "HUD/PlayerHUD.png";
    public static final String WON_BG = "IngameLevelMenus/bg_won.png";
    public static final String LOST_BG = "IngameLevelMenus/DeathScreen_withBG.png";
    public static final String EXIT_BUTTON = "IngameLevelMenus/exit.png";
    public static final String MENU_BUTTON = "IngameLevelMenus/menu_button.png";
    public static final String REPLAY_BUTTON = "IngameLevelMenus/replay_button.png";
    public static final String NEXT_LVL = "IngameLevelMenus/nextlvl.png";
    public static final String NEXT_BG = "IngameLevelMenus/bg_won_withBg.png";



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
