package gamestates;

public enum Gamestate {
    PLAYING, MENU, STORE, SETTINGS, AUDIO, CONTROLS, PAUSE, NEXTLEVEL, DEATH, VICTORY ;

    public static Gamestate state = MENU;
}
