package baseball.app.game;

import baseball.app.ball.BallJudgeStatus;
import baseball.app.ball.Balls;
import baseball.app.ball.BallsResult;
import baseball.app.ball.generator.BallsGenerator;
import baseball.app.printer.GameView;

import static baseball.constants.GameConstants.MAX_BALL_COUNT;

public class Computer {

    private final BallsGenerator ballsGenerator;
    private Balls balls;

    public Computer(final BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public void prepareGame() {
        this.balls = ballsGenerator.generate();
    }

    public Balls getBalls() {
        return balls;
    }

    public boolean isCorrect(final Balls playerBalls) {
        final BallsResult ballsResult = balls.calculateResult(playerBalls);
        GameView.printBallsResult(ballsResult);

        return ballsResult.isComplete();
    }
}
