package baseball.app.game;

import baseball.app.ball.Balls;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.GameConstants.MAX_BALL_COUNT;

public class GameInputReader {

    public Balls inputBalls() {
        final String[] inputs = splitInputs(Console.readLine());
        if (inputs.length != MAX_BALL_COUNT) {
            throw new IllegalArgumentException("Input ball number is under " + MAX_BALL_COUNT);
        }

        return createBalls(inputs);
    }

    private static String[] splitInputs(final String inputLine) {
        return inputLine.split("");
    }

    private static Balls createBalls(final String[] inputs) {
        final Balls balls = new Balls();
        for (int i = 0; i < MAX_BALL_COUNT; i++) {
            balls.add(inputs[i]);
        }
        return balls;
    }

}
