package baseball.app.ball.generator;

import baseball.app.ball.Ball;
import baseball.app.ball.Balls;
import baseball.app.ball.Number;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBallsGenerator implements BallsGenerator {

    protected Balls createBalls(final List<Integer> integerList) {
        return new Balls(toBallList(toNumberList(integerList)));
    }

    private List<Number> toNumberList(final List<Integer> integerList) {
        final List<Number> numberList = new ArrayList<>(integerList.size());
        for (final Integer value : integerList) {
            numberList.add(new Number(value));
        }
        return numberList;
    }

    private List<Ball> toBallList(final List<Number> numberList) {
        final List<Ball> ballList = new ArrayList<>(numberList.size());
        for (int i = 0, numberListSize = numberList.size(); i < numberListSize; i++) {
            final Number value = numberList.get(i);
            ballList.add(new Ball(value, i));
        }
        return ballList;
    }

}
