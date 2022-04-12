package baseball.app.game;

import baseball.app.ball.Balls;
import baseball.app.game.GameInputReader;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static baseball.constants.GameConstants.MAX_BALL_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class GameInputReaderTest {

    private GameInputReader target;
    private MockedStatic<Console> console;

    @BeforeEach
    void init() {
        target = new GameInputReader();
        console = Mockito.mockStatic(Console.class);
    }

    @AfterEach
    void clear() {
        console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"231", "451", "2514", "962756", "8234"})
    void 번호를입력하여공을반환(final String input) {
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

}
