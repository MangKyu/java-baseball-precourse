package baseball.app.ball;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void Ball생성성공(final String input) {
        // given

        // when
        final Ball ball = new Ball(input);

        // then
        assertThat(ball.getNumber()).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"`", "Z", "[", "}", "?"})
    void Ball생성실패_Integer가아님(final String input) {
        // given

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> new Ball(input));

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "10", "11"})
    void Ball생성실패_1부터9가아닌값(final String input) {
        // given

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> new Ball(input));

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void equalsHashCode가동일함() {
        // given
        final String input = "1";
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
        final String input = "1";
        final Ball ball = new Ball(input);

        // when
        final Ball result = new Ball("9");

        // then
        assertThat(result).isNotEqualTo(ball);
        assertThat(result.hashCode()).isNotEqualTo(ball.hashCode());
    }

}