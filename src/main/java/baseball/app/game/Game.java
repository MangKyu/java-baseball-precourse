package baseball.app.game;

import baseball.app.ball.BallJudgeStatus;
import baseball.app.ball.Balls;
import baseball.app.ball.BallsResult;
import baseball.app.participant.Computer;
import baseball.app.participant.Player;
import baseball.app.view.GameView;

import static baseball.app.ball.constants.GameConstants.MAX_BALL_COUNT;

public class Game {

    private final Player player;
    private final Computer computer;
    private final GameView gameView;
    private boolean quit;

    public Game(final Player player, final Computer computer, final GameView gameView) {
        this.player = player;
        this.computer = computer;
        this.gameView = gameView;
        this.quit = false;
    }

    public void start() {
        while (!quit) {
            startGame();
            quit = quitGame();
        }

        gameView.printQuitGame();
    }

    private void startGame() {
        boolean isEnd = false;
        computer.prepareGame();

        while (!isEnd) {
            final BallsResult result = playGame();
            isEnd = isEnd(result);
        }
    }

    private BallsResult playGame() {
        final Balls balls = getPlayersBallInput();
        return computer.getBallsResult(balls);
    }

    private Balls getPlayersBallInput() {
        gameView.printInputNumber();
        return player.inputBalls();
    }

    private boolean isEnd(final BallsResult result) {
        gameView.printBallsResult(result);
        return result.getCount(BallJudgeStatus.STRIKE) == MAX_BALL_COUNT;
    }

    private boolean quitGame() {
        gameView.printMenu();
        return player.inputGameMenu() == GameMenu.QUIT;
    }

}