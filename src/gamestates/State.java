package gamestates;

import Audio.AudioPlayer;
import main.GameController;

public class State {
    protected GameController game;

    public State(GameController game){
        this.game = game;
    }

    public GameController getGame(){
        return game;
    }

    public void setGameState(Gamestate state){
        switch(state){case MENU -> game.getAudioPlayer().playMusic(AudioPlayer.MENU);
        }

        Gamestate.state = state;
    }

}
