package gamestates;

import java.awt.image.BufferedImage;

public class LevelCompleted {

    private Playing playing;
    private UrmButton menu, next;
    private BufferedImage img;
    private int bgX, bgY, bgW, bgH;

    public LevelCompleted(Playing playing) {
        this.playing = playing;
        initImg();
    }

    private void initImg() {
    }

}

