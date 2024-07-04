public class GameController {
    //Controls the game scenes

    Window window;
    GamePanel gamePanel;

    public GameController(){

        gamePanel = new GamePanel();
        window = new Window(gamePanel);
        gamePanel.requestFocus();
    }


}
