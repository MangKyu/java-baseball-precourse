package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.printer.GameView;

public class Game {

    private final Player player;
    private final Computer computer;
    private boolean quit;

    public Game(final Player player, final Computer computer) {
        this.player = player;
        this.computer = computer;
        this.quit = false;
    }

    public void start() {
        while(!quit) {
            startGame();
            quit = quitGame();
        }

        GameView.printQuitGame();
    }

    private void startGame() {
        boolean isEnd = false;
        computer.prepareGame();

        while (!isEnd) {
            isEnd = playGame();
        }
    }

    private boolean playGame() {
        final Balls balls = player.inputBalls();
        return computer.isCorrect(balls);
    }

    private boolean quitGame() {
        return player.inputGameMenu() == GameMenu.QUIT;
    }

}