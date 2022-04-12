package baseball.app.ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> ballList;

    public Balls(final List<Ball> ballList) {
        this.ballList = new ArrayList<>();
        for (final Ball ball : ballList) {
            add(ball);
        }
    }

    private void add(final Ball ball) {
        if (ballList.contains(ball)) {
            throw new IllegalArgumentException("Input value is duplicated: " + ball.getNumber());
        }

        ballList.add(ball);
    }

    public int get(final int index) {
        return ballList.get(index)
                .getNumber();
    }

}
