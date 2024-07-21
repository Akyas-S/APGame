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

    public static boolean equipedSkin1;
    private Player player;
    private SaveLoad saveLoad;
    private BufferedImage store;
    private BufferedImage closestorebtn;

    private Rectangle closestorebtnbounds;
    private Rectangle buySkin1;
    private Rectangle equipSkin1;
    private Rectangle buySkin2;
    private Rectangle equipSkin2;

    private boolean boughtSkin1;
    private boolean boughtSkin2;
    private boolean equipedSkin2;
    private int Skin1Cost = 50;
    private int Skin2Cost = 50;

    public Store(GameController game,Player player) {
        super(game);
        loadStoreBackground();
        loadStoreButtons();
        this.player = player;
        SaveLoad saveLoad = new SaveLoad(player);
        this.saveLoad = saveLoad;

    }

    private void loadStoreButtons() {
        closestorebtn = LoadImages.GetSprite(LoadImages.Closebtnimg);
        closestorebtnbounds = new Rectangle(20, 20, 140, 140);


        buySkin1= new Rectangle(436, 292, 52, 26);
        equipSkin1 = new Rectangle(500, 292, 52, 26);
        buySkin2 = new Rectangle(607, 292, 52, 26);
        equipSkin2 = new Rectangle(673, 292, 52, 26);
    }

    private void loadStoreBackground() {
        store = LoadImages.GetSprite(LoadImages.Storebg);
    }

    private void showCoins(Graphics g){
        Font font = new Font("Jokerman", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.yellow);
        g.drawString("Coins: " + String.valueOf(saveLoad.loadCoins()),640,100);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(store, 0, 0,1280,720, null);
        g.drawImage(closestorebtn, 20, 20, 140, 140, null);

        g.setColor(Color.red);
        g.drawRect(436, 292, 52, 26);
        g.drawRect(500, 292, 52, 26);
        g.drawRect(607, 292, 52, 26);
        g.drawRect(673, 292, 52, 26);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("BUY", 436, 315);
        g.drawString("EQUIP", 500, 315);
        g.drawString("BUY", 607, 315);
        g.drawString("EQUIP", 673, 315);
        showCoins(g);
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
        }

    }


    @Override
    public void mouseClicked(MouseEvent aud) {
        Point clickPoint = aud.getPoint();
        if (closestorebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.MENU;
            game.getAudioPlayer().playButtonSound();
        }

        if (buySkin1.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            boughtSkin1 = true;
            boughSkin();
            System.out.println(String.valueOf(saveLoad.loadCoins()));
        }
        if (buySkin2.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            boughtSkin2 = true;
            boughSkin();
            System.out.println(String.valueOf(saveLoad.loadCoins()));
        }
        if (equipSkin1.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            equipedSkin1 = true;
            System.out.println("Equip 1 pressed");
        }
        if (equipSkin2.contains(clickPoint)) {
            game.getAudioPlayer().playButtonSound();
            equipedSkin2 = true;
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
