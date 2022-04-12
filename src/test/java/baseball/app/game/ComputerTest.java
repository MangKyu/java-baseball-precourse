package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.AutoBallsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer(new AutoBallsGenerator());
    }

    @Test
    void 컴퓨터는생성시에Balls를갖는다() {
        // given

        // when
        final Balls result = computer.getBalls();

        // then
        assertThat(result).isNotNull();
    }

}