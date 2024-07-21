package gamestates;

import data.SaveLoad;
import entity.Player;
import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Store extends State implements Statemethods {
    public static BufferedImage spriteskin;
    private BufferedImage store;
    private BufferedImage closestorebtn;
    private BufferedImage buybtn;
    private BufferedImage buybtn2;


    private BufferedImage equipbtn;
    private BufferedImage equipbtn2;


    private BufferedImage pinkpaw;


    private Rectangle closestorebtnbounds;
    private Rectangle buybtnbounds;
    private Rectangle buybtnbounds2;

    private Rectangle equipbtnbounds;
    private Rectangle equipbtnbounds2;

    private SaveLoad saveLoad;
    private Player player;

    private boolean boughtSkin1;
    private boolean boughtSkin2;
    private boolean equipedSkin2;
    private int Skin1Cost = 50;
    private int Skin2Cost = 50;

    public Store(GameController game, Player player) {
        super(game);
        loadStoreBackground();
        this.player = player;
        SaveLoad saveLoad = new SaveLoad(player);
        this.saveLoad = saveLoad;
        loadStoreButtons();
        loadSpriteicon();
    }




    private void loadSpriteicon() {
        spriteskin=LoadImages.GetSprite(LoadImages.PLAYER_SPRITE);
        pinkpaw = LoadImages.GetSprite(LoadImages.PINKPAWSKIN);
    }


    private void loadStoreButtons() {
        closestorebtn = LoadImages.GetSprite(LoadImages.Closebtnimg);
        buybtn = LoadImages.GetSprite(LoadImages.BUYBTN);
        buybtn2 = LoadImages.GetSprite(LoadImages.BUYBTN);

        equipbtn = LoadImages.GetSprite(LoadImages.EQUIPBTN);
        equipbtn2 = LoadImages.GetSprite(LoadImages.EQUIPBTN);


        closestorebtnbounds = new Rectangle(20, 20, 140, 140);
        buybtnbounds = new Rectangle(430,290,68, 30);
        buybtnbounds2 = new Rectangle(600,290,68, 30);


        equipbtnbounds = new Rectangle(500, 290, 68, 30);
        equipbtnbounds2 = new Rectangle(670, 290, 68, 30);

    }

    private void loadStoreBackground() {
        store = LoadImages.GetSprite(LoadImages.Storebg);
    }

    private void showCoins(Graphics g){
        Font font = new Font("Arial", Font.BOLD, 40);
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawString(String.valueOf(saveLoad.loadCoins()),1124 ,73);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(store, 0, 0,1280,720, null);
        showCoins(g);
        g.drawImage(pinkpaw, 460, 200, 69,91,null);

        g.drawImage(closestorebtn, 20, 20, 140, 140, null);
        g.drawImage(buybtn, 430, 290, 68, 30, null);
        g.drawImage(buybtn2, 600, 290, 68, 30, null);


        g.drawImage(equipbtn, 500,290, 68, 30, null);
        g.drawImage(equipbtn2, 670, 290, 68, 30, null);

    }

    public void boughSkin(){
        if(boughtSkin1 && player.playerTotalCoins > Skin1Cost){
            player.playerTotalCoins = player.playerTotalCoins - Skin1Cost;
            saveLoad.saveCoins();
            System.out.println("Skin 1 Bought!");
            System.out.println(String.valueOf(saveLoad.loadCoins()));
        } else if (player.playerTotalCoins < Skin1Cost) {
            System.out.println("Don't have enough coins");
        }
        if (boughtSkin2 && player.playerTotalCoins > Skin2Cost){
            player.playerTotalCoins = player.playerTotalCoins - Skin2Cost;
            saveLoad.saveCoins();
            System.out.println("Skin 2 Bought!");
        } else if (player.playerTotalCoins < Skin1Cost) {
            System.out.println("Don't have enough coins");
        }}

    @Override
    public void mouseClicked(MouseEvent aud) {
        Point clickPoint = aud.getPoint();
        if (closestorebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
            game.getAudioPlayer().playButtonSound();
        }
        else if (buybtnbounds.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            boughtSkin1 = true;
            boughSkin();
            System.out.println(String.valueOf(saveLoad.loadCoins()));
            System.out.println("skin 1 bought");
        }
        else if (buybtnbounds2.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            boughtSkin2 = true;
            boughSkin();
            System.out.println(String.valueOf(saveLoad.loadCoins()));
            System.out.println("skin 2 bought");
        }
        else if (equipbtnbounds.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            System.out.println("skin 1 equipped");
            spriteskin = LoadImages.GetSprite(LoadImages.PINKPAWSKIN);
        }
        else if (equipbtnbounds2.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            System.out.println("skin 2 equipped");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
