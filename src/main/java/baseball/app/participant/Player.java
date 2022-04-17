package baseball.app.participant;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.BallsGenerator;
import baseball.app.game.GameMenu;
import camp.nextstep.edu.missionutils.Console;

public class Player {

    private final BallsGenerator ballsGenerator;

    public Player(final BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public Balls inputBalls() {
        return ballsGenerator.generate();
    }

    public GameMenu inputGameMenu() {
        final String input = Console.readLine();
        try {
            return GameMenu.of(Integer.parseInt(input));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("Input is not an integer: " + input, e);
        }
    }

}
