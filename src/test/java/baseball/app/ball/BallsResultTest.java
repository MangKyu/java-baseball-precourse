package baseball.app.ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallsResultTest {

    private BallsResult target;

    @BeforeEach
    void init() {
        target = new BallsResult();
    }

    @Test
    void 객체생성직후에는아무것도없음() {
        // given

        // when

        // then
        assertThat(target.getCount(BallJudgeStatus.STRIKE)).isEqualTo(0);
        assertThat(target.getCount(BallJudgeStatus.BALL)).isEqualTo(0);
        assertThat(target.getCount(BallJudgeStatus.NOTHING)).isEqualTo(0);
    }


    @Test
    void 값추가및조회성공() {
        // given

        // when
        target.addResult(BallJudgeStatus.STRIKE);

        // then
        assertThat(target.getCount(BallJudgeStatus.STRIKE)).isEqualTo(1);
        assertThat(target.getCount(BallJudgeStatus.BALL)).isEqualTo(0);
        assertThat(target.getCount(BallJudgeStatus.NOTHING)).isEqualTo(0);
    }

}