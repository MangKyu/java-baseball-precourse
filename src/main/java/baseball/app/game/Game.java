package baseball.app.game;

import baseball.app.ball.Balls;

public class Game {

    private final Player player;
    private final Computer computer;

    public Game(final Player player, final Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void startGame() {
        boolean isEnd = false;
        while (!isEnd) {
            isEnd = playGame();
        }
    }

    private boolean playGame() {
        final Balls balls = player.inputBalls();
        return computer.isCorrect(balls);
    }

}
