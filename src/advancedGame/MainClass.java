package advancedGame;

import advancedGame.game.Game;

public class MainClass {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
