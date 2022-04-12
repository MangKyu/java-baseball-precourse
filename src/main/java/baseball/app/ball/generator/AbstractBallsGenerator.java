package baseball.app.ball.generator;

import baseball.app.ball.Ball;
import baseball.app.ball.Balls;
import baseball.app.ball.Number;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBallsGenerator implements BallsGenerator {

    protected Balls createBalls(final List<Integer> integerList) {
        final List<Number> numberList = convertToNumberList(integerList);
        final List<Ball> ballList = convertToBallList(numberList);
        return new Balls(ballList);
    }

    private List<Number> convertToNumberList(final List<Integer> integerList) {
        final List<Number> numberList = new ArrayList<>(integerList.size());
        for (final Integer value : integerList) {
            numberList.add(new Number(value));
        }
        return numberList;
    }

    private List<Ball> convertToBallList(final List<Number> numberList) {
        final List<Ball> ballList = new ArrayList<>(numberList.size());
        for (final Number value : numberList) {
            ballList.add(new Ball(value));
        }
        return ballList;
    }

}
