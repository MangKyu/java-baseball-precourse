package baseball.app.ball;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @Test
    void Balls생성성공_중복없음() {
        // given

        // when
        final Balls result = new Balls(Arrays.asList(new Ball(new Number(1)), new Ball(new Number(2))));

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void Balls생성실패_중복있음() {
        // given

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> new Balls(Arrays.asList(new Ball(new Number(1)), new Ball(new Number(1)))));

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }
}