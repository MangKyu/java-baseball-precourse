package baseball.app.game;

import baseball.app.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static baseball.constants.GameConstants.MAX_BALL_COUNT;

public class Computer {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final Balls balls;

    public Computer() {
        this.balls = initBalls();
    }

    private Balls initBalls() {
        final List<Integer> integerList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, MAX_BALL_COUNT);
        final Balls balls = new Balls();
        for (Integer input : integerList) {
            balls.add(input);
        }
        return balls;
    }

    public Balls getBalls() {
        return balls;
    }
}
