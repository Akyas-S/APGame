package gamestates;
// Enum class to represent the different game states
public enum Gamestate {
    PLAYING, MENU, STORE, SETTINGS, AUDIO, CONTROLS, PAUSE, NEXTLEVEL, DEATH, VICTORY ;

    public static Gamestate state = MENU;
}
