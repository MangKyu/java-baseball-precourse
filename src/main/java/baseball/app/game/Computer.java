package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.BallsGenerator;

public class Computer {

    private final Balls balls;
    private final BallsGenerator ballsGenerator;

    public Computer(final BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
        this.balls = ballsGenerator.generate();
    }

    public Balls getBalls() {
        return balls;
    }
}