package baseball.app.ball.generator;

import baseball.app.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static baseball.constants.GameConstants.*;

public class AutoBallsGenerator extends AbstractBallsGenerator {

    @Override
    public Balls generate() {
        final List<Integer> integerList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, MAX_BALL_COUNT);
        return createBalls(integerList);
    }

}
