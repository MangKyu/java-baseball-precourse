package baseball.app.ball;

import java.util.Objects;

import static baseball.constants.GameConstants.MAX_BALL_COUNT;

public class Ball {

    private final Number number;
    private final Position position;

    public Ball(final Number number, final int index) {
        this.number = number;
        this.position = new Position(index);
    }

    public int getNumber() {
        return number.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ball ball = (Ball) o;
        return Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public BallJudgeStatus judgeStatus(final Ball ball) {
        if (!this.number.equals(ball.number)) {
            return BallJudgeStatus.NOTHING;
        }

        if (!this.position.equals(ball.position)) {
            return BallJudgeStatus.BALL;
        }

        return BallJudgeStatus.STRIKE;
    }

    private static class Position {

        private final int index;

        public Position(final int index) {
            if (index >= MAX_BALL_COUNT) {
                throw new IllegalArgumentException("Input position value is invalid: " + index);
            }
            this.index = index;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Position position = (Position) o;
            return index == position.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }

}
