package entity;

import gamestates.Playing;
import utils.LoadImages;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyManager {

    private Playing playing;
    private BufferedImage[][] pirateArray;
    private ArrayList<Pirate> pirates = new ArrayList<>();

    public EnemyManager(Playing playing){
        this.playing = playing;
        loadEnemyImgs();
    }

    public void update(){

    }
    public void draw(Graphics g){
        drawPirates(g);
    }

    private void drawPirates(Graphics g) {
        for(Pirate p:pirates){
            g.drawImage(pirateArray[p.getEnemyState()][p.getAniIndex()],(int)p.getHitbox().x,(int)p.getHitbox().y,128,80,null);
        }
    }

    private void loadEnemyImgs(){

        pirateArray = new BufferedImage[5][9];
        BufferedImage img = LoadImages.GetSprite(LoadImages.PIRATE_SPRITE);

        for (int j = 0; j < pirateArray.length; j++ ){
            for(int i = 0; i< pirateArray[j].length; i++){
                pirateArray[j][i] = img.getSubimage(i*128,j*80,128,80);
            }
        }
    }
}
