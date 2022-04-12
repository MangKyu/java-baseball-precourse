package baseball.app.game;

import baseball.app.ball.Balls;

public class Game {

    private final Player player;
    private final Computer computer;
    private boolean quit = false;

    public Game(final Player player, final Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void start() {
        while(!quit) {
            startGame();
            quit = quitGame();
        }
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
        final GameMenu gameMenu = player.inputGameMenu();
        return gameMenu == GameMenu.QUIT;
    }

}