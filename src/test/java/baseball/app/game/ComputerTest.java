package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.AutoBallsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer(new AutoBallsGenerator());
    }

    @Test
    void 컴퓨터는생성시에Balls를갖지않는다() {
        // given

        // when
        final Balls result = computer.getBalls();

        // then
        assertThat(result).isNull();
    }

    @Test
    void prepareGame호출후에Balls를갖는다() {
        // given
        computer.prepareGame();

        // when
        final Balls result = computer.getBalls();

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void prepareGame2번째호출후에새로운Balls를갖는다() {
        // given
        computer.prepareGame();
        final Balls firstBall = computer.getBalls();
        computer.prepareGame();

        // when
        final Balls result = computer.getBalls();

        // then
        assertThat(firstBall).isNotEqualTo(result);
    }

    @Test
    void 정답이맞는지확인_맞음() {
        // given
        computer.prepareGame();
        final Balls firstBall = computer.getBalls();

        // when
        final boolean result = computer.isCorrect(firstBall);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 정답이맞는지확인_틀림() {
        // given
        computer.prepareGame();

        // when
        final boolean result = computer.isCorrect(new Balls(new ArrayList<>()));

        // then
        assertThat(result).isFalse();
    }

}