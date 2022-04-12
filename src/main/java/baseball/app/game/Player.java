package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.BallsGenerator;

public class Player {

    private final BallsGenerator ballsGenerator;
    private Balls balls;

    public Player(final BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public Balls inputBalls() {
        this.balls = ballsGenerator.generate();
        return this.balls;
    }

    public Balls getBalls() {
        return balls;
    }

}
