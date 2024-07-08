package gamestates;


import main.GameController;

public class State {
    protected GameController game;

    public State(GameController game){
        this.game = game;
    }

    public GameController getGame(){
        return game;
    }
}
