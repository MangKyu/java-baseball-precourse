package baseball.app.ball.generator;

import baseball.app.ball.Balls;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.app.constants.GameConstants.MAX_BALL_COUNT;

public class ManualBallsGenerator extends AbstractBallsGenerator {

    @Override
    public Balls generate() {
        final String[] inputs = splitInputs(Console.readLine());
        if (isValid(inputs)) {
            throw new IllegalArgumentException("Input ball number is under " + MAX_BALL_COUNT);
        }

        return createBalls(toIntegerList(inputs));
    }

    private String[] splitInputs(final String inputLine) {
        return inputLine.split("");
    }

    private boolean isValid(final String[] inputs) {
        return inputs.length != MAX_BALL_COUNT;
    }

    private List<Integer> toIntegerList(final String[] inputs) {
        final List<Integer> integerList = new ArrayList<>(inputs.length);
        for (final String input : inputs) {
            integerList.add(toInteger(input));
        }
        return integerList;
    }

    private Integer toInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("Input is not an integer: " + input, e);
        }
    }

}