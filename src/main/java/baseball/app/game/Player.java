package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.BallsGenerator;
import baseball.app.printer.GameView;

public class Player {

    private final BallsGenerator ballsGenerator;

    public Player(final BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public Balls inputBalls() {
        GameView.printInputNumber();
        return ballsGenerator.generate();
    }

}
