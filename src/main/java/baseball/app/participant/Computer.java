package baseball.app.participant;

import baseball.app.ball.Balls;
import baseball.app.ball.BallsResult;
import baseball.app.ball.generator.BallsGenerator;

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

    public BallsResult getBallsResult(final Balls playerBalls) {
        return balls.calculateResult(playerBalls);
    }
}
