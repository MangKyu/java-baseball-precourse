package baseball.app.ball;

import java.util.HashMap;
import java.util.Map;

public class BallsResult {

    private final Map<BallJudgeStatus, Integer> result;

    public BallsResult() {
        this.result = new HashMap<>();
        for (final BallJudgeStatus status : BallJudgeStatus.values()) {
            result.put(status, 0);
        }
    }

    public void addResult(final BallJudgeStatus judgeStatus) {
        result.put(judgeStatus, result.get(judgeStatus) + 1);
    }

    public int getCount(final BallJudgeStatus status) {
        return result.get(status);
    }

}
