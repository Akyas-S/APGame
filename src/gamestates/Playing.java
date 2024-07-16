package gamestates;

import entity.Player;
import main.GameController;
import utils.LoadImages;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Playing extends State implements Statemethods {
    private Player player;
    private BufferedImage pausebtn;

    private Rectangle pausebtnbounds;

    public Playing(GameController game) {
        super(game);
        initClasses();
        initPauseButton();
    }

    private void initPauseButton() {
        pausebtn = LoadImages.GetSprite(LoadImages.Pausebtnicon);

        pausebtnbounds = new Rectangle(10, 10, pausebtn.getWidth(), pausebtn.getHeight());
    }

    private void initClasses() {

        player = new Player(200,200);
    }

    public Player getPlayer(){
        return player;
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        g.drawImage(pausebtn, 10, 10, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();
        if (pausebtnbounds.contains(clickPoint)) {
            Gamestate.state = Gamestate.PAUSE;
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
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W){
            player.setUp(true);}
        if (temp == KeyEvent.VK_A){
            player.setLeft(true);}
        if (temp == KeyEvent.VK_D){
            player.setRight(true);}
        if (temp == KeyEvent.VK_S){
            player.setDown(true);}
        if (temp == KeyEvent.VK_ESCAPE){
            Gamestate.state = Gamestate.PAUSE;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int temp = e.getKeyCode();
        if (temp == KeyEvent.VK_W){
            player.setUp(false);}
        if (temp == KeyEvent.VK_A){
            player.setLeft(false);}
        if (temp == KeyEvent.VK_D){
            player.setRight(false);}
        if (temp == KeyEvent.VK_S){
            player.setDown(false);}
    }
}
