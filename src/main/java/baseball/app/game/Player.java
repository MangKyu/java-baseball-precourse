package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.BallsGenerator;

public class Player {

    private final BallsGenerator ballsGenerator;

    public Player(final BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public Balls inputBalls() {
        return ballsGenerator.generate();
    }

}
