package Inputs;

import gamestates.Gamestate;
import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseClicked(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseClicked(e);
                break;
            case SETTINGS:
                gamePanel.getGame().getSettings().mouseClicked(e);
                break;
            case AUDIO:
                gamePanel.getGame().getAudio().mouseClicked(e);
                break;
            case CONTROLS:
                gamePanel.getGame().getControls().mouseClicked(e);
                break;
            case PAUSE:
                gamePanel.getGame().getPause().mouseClicked(e);
                break;

            case STORE:
                gamePanel.getGame().getStore().mouseClicked(e);

            case NEXTLEVEL2:
                gamePanel.getGame().getNextLevel2().mouseClicked(e);
                break;
            case DEATH:
                gamePanel.getGame().getDeath().mouseClicked(e);
                break;
            case VICTORY:
                gamePanel.getGame().getVictory().mouseClicked(e);
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mousePressed(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mousePressed(e);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseReleased(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseReleased(e);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseMoved(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseMoved(e);
                break;
            default:
                break;
        }
    }

}
