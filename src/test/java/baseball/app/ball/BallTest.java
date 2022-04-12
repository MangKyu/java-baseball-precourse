package baseball.app.ball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    void equalsHashCode가동일함() {
        // given
        final Number input = new Number(1);
        final Ball ball = new Ball(input, 1);

        // when
        final Ball result = new Ball(input, 1);

        // then
        assertThat(result).isEqualTo(ball);
        assertThat(result.hashCode()).isEqualTo(ball.hashCode());
    }

    @Test
    void equalsHashCode가다름() {
        // given
        final Number input = new Number(1);
        final Ball ball = new Ball(input, 1);

        // when
        final Ball result = new Ball(new Number(9), 1);

        // then
        assertThat(result).isNotEqualTo(ball);
        assertThat(result.hashCode()).isNotEqualTo(ball.hashCode());
    }

    @Test
    void ballJudgeStatus비교_스트라이크() {
        // given
        final Ball source = new Ball(new Number(1), 1);
        final Ball target = new Ball(new Number(1), 1);

        // when
        final BallJudgeStatus result = source.judgeStatus(target);

        // then
        assertThat(result).isEqualTo(BallJudgeStatus.STRIKE);
    }

    @Test
    void ballJudgeStatus비교_볼() {
        // given
        final Ball source = new Ball(new Number(1), 1);
        final Ball target = new Ball(new Number(1), 2);

        // when
        final BallJudgeStatus result = source.judgeStatus(target);

        // then
        assertThat(result).isEqualTo(BallJudgeStatus.BALL);
    }

    @Test
    void ballJudgeStatus비교_낫싱() {
        // given
        final Ball source = new Ball(new Number(2), 1);
        final Ball target = new Ball(new Number(1), 1);

        // when
        final BallJudgeStatus result = source.judgeStatus(target);

        // then
        assertThat(result).isEqualTo(BallJudgeStatus.NOTHING);
    }

}