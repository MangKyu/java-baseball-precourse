package baseball.app.ball.generator;

import baseball.app.ball.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoBallsGeneratorTest {

    private BallsGenerator target;

    @BeforeEach
    void init() {
        target = new AutoBallsGenerator();
    }

    @Test
    void 임의의Balls를생성함() {
        // given

        // when
        final Balls result = target.generate();

        // then
        assertThat(result).isNotNull();
    }


}