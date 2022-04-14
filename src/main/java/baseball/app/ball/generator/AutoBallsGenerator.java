package baseball.app.ball.generator;

import baseball.app.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.app.constants.GameConstants.*;

public class AutoBallsGenerator extends AbstractBallsGenerator {

    @Override
    public Balls generate() {
        final List<Integer> integerList = createUniqueIntegerList();
        return createBalls(integerList);
    }

    private List<Integer> createUniqueIntegerList() {
        final Set<Integer> set = new LinkedHashSet<>(MAX_BALL_COUNT);
        while (!isFullyPicked(set)) {
            final int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            set.add(number);
        }
        return new ArrayList<>(set);
    }

    private boolean isFullyPicked(final Set<Integer> set) {
        return set.size() == MAX_BALL_COUNT;
    }

}
