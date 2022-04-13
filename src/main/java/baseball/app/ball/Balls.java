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

    public BallsResult calculateResult(final Balls targetBalls) {
        final BallsResult ballsResult = new BallsResult();
        for (final Ball ball : targetBalls.ballList) {
            ballsResult.addResult(judgeStatus(ball));
        }

        return ballsResult;
    }

    private BallJudgeStatus judgeStatus(final Ball targetBall) {
        if (!this.ballList.contains(targetBall)) {
            return BallJudgeStatus.NOTHING;
        }

        final Ball ball = findBall(targetBall);
        return ball.judgeStatus(targetBall);
    }

    private Ball findBall(final Ball targetBall) {
        final int index = ballList.indexOf(targetBall);
        return ballList.get(index);
    }

}
