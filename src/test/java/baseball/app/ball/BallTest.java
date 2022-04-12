package baseball.app.ball;

import org.assertj.core.api.AbstractThrowableAssert;
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

}