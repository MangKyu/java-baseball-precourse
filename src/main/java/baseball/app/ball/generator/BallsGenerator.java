package baseball.app.ball.generator;

import baseball.app.ball.Balls;

@FunctionalInterface
public interface BallsGenerator {

    Balls generate();

}
