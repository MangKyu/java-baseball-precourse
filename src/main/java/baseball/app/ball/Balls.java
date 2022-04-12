package baseball.app.ball;

import java.util.List;

public class Balls {

    private final List<Ball> ballList;

    public Balls(final List<Ball> ballList) {
        this.ballList = ballList;
    }

    public int get(final int index) {
        return ballList.get(index)
                .getNumber();
    }
}
