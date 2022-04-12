package baseball.app.game;

import baseball.app.ball.Ball;
import baseball.app.ball.Balls;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
        return new Balls(createBallList(inputs));
    }

    private static List<Ball> createBallList(final String[] inputs) {
        final List<Ball> ballList = new ArrayList<>(MAX_BALL_COUNT);
        for (int i = 0; i < MAX_BALL_COUNT; i++) {
            ballList.add(new Ball(inputs[i]));
        }
        return ballList;
    }

}
