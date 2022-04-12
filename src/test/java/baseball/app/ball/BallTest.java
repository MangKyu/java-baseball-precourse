package baseball.app.ball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    void equalsHashCode가동일함() {
        // given
        final Number input = new Number(1);
        final Ball ball = new Ball(input);

        // when
        final Ball result = new Ball(input);

        // then
        assertThat(result).isEqualTo(ball);
        assertThat(result.hashCode()).isEqualTo(ball.hashCode());
    }

    @Test
    void equalsHashCode가다름() {
        // given
        final Number input = new Number(1);
        final Ball ball = new Ball(input);

        // when
        final Ball result = new Ball(new Number(9));

        // then
        assertThat(result).isNotEqualTo(ball);
        assertThat(result.hashCode()).isNotEqualTo(ball.hashCode());
    }

}