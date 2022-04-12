package baseball.app.ball;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @Test
    void Balls생성성공_중복없음() {
        // given

        // when
        final Balls result = balls(1, 2);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void Balls생성실패_중복있음() {
        // given

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> balls(1, 1));

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Balls결과확인_3스트라이트() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(1, 2, 3);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(3);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(0);
    }

    @Test
    void Balls결과확인_2스트라이트() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(1, 2, 4);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(2);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(1);
    }

    @Test
    void Balls결과확인_1스트라이트2볼() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(1, 3, 2);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(1);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(2);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(0);
    }

    @Test
    void Balls결과확인_1스트라이트1볼() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(1, 3, 9);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(1);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(1);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(1);
    }

    @Test
    void Balls결과확인_1스트라이트() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(1, 4, 9);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(1);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(2);
    }

    @Test
    void Balls결과확인_3볼() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(2, 3, 1);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(3);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(0);
    }

    @Test
    void Balls결과확인_2볼() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(2, 3, 9);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(2);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(1);
    }

    @Test
    void Balls결과확인_1볼() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(2, 6, 9);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(1);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(2);
    }

    @Test
    void Balls결과확인_0볼() {
        // given
        final Balls playerBalls = balls(1, 2, 3);
        final Balls computerBalls = balls(7, 8, 9);

        // when
        final BallsResult result = computerBalls.calculateResult(playerBalls);

        // then
        assertThat(result.getCount(BallJudgeStatus.STRIKE)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.BALL)).isEqualTo(0);
        assertThat(result.getCount(BallJudgeStatus.NOTHING)).isEqualTo(3);
    }

    private Balls balls(final int... ints) {
        final List<Ball> ballList = new ArrayList<>(ints.length);
        for (int i = 0, intsLength = ints.length; i < intsLength; i++) {
            final int value = ints[i];
            ballList.add(new Ball(new Number(value), i));
        }

        return new Balls(ballList);
    }

}