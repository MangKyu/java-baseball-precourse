package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.ball.generator.ManualBallsGenerator;
import baseball.app.participant.Player;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static baseball.app.ball.constants.GameConstants.MAX_BALL_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player target;
    private MockedStatic<Console> console;

    @BeforeEach
    void init() {
        target = new Player(new ManualBallsGenerator());
        console = Mockito.mockStatic(Console.class);
    }

    @AfterEach
    void clear() {
        console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"231", "451", "254", "962", "823"})
    void 번호를입력하여공을반환성공(final String input) {
        // given
        final String[] inputs = input.split("");

        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final Balls result = target.inputBalls();

        // then
        for (int i = 0; i < MAX_BALL_COUNT; i++) {
            assertThat(result.get(i)).isEqualTo(Integer.parseInt(inputs[i]));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "23", "4", "2546", "96945"})
    void 번호를입력하여공을반환실패_3개가아닌입력값(final String input) {
        // given
        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> target.inputBalls());

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2[", "a", "25@", "?.X", "add"})
    void 번호를입력하여공을반환실패_정수가아닌입력값(final String input) {
        // given
        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> target.inputBalls());

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"092", "104", "910"})
    void 번호를입력하여공을반환실패_1부터9가아닌값이포함됨(final String input) {
        // given
        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> target.inputBalls());

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"119", "144", "717"})
    void 번호를입력하여공을반환실패_중복된값이포함됨(final String input) {
        // given
        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> target.inputBalls());

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 번호를입력하여게임메뉴를반환성공_계속게임하기() {
        // given
        console.when(Console::readLine)
                .thenReturn("1");

        // when
        final GameMenu result = target.inputGameMenu();

        // then
        assertThat(result).isEqualTo(GameMenu.CONTINUE);
    }


    @ParameterizedTest
    @ValueSource(strings = {"23", "4", "2546", "96945"})
    void 번호를입력하여게임메뉴를반환성공_게임종료하기(final String input) {
        // given
        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final GameMenu result = target.inputGameMenu();

        // then
        assertThat(result).isEqualTo(GameMenu.QUIT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "2[", "a", "25@", "?.X", "add"})
    void 번호를입력하여게임메뉴를반환실패_정수가아닌입력값(final String input) {
        // given
        console.when(Console::readLine)
                .thenReturn(input);

        // when
        final AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> target.inputGameMenu());

        // then
        result.isInstanceOf(IllegalArgumentException.class);
    }

}