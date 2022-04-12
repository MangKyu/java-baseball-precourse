package baseball.app.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameMenuTest {

    @Test
    void 메뉴조회_게임계속하기() {
        // given

        // when
        final GameMenu result = GameMenu.of(1);

        // then
        assertThat(result).isEqualTo(GameMenu.CONTINUE);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
    void 메뉴조회_게임종료하기(final int input) {
        // given

        // when
        final GameMenu result = GameMenu.of(input);

        // then
        assertThat(result).isEqualTo(GameMenu.QUIT);
    }

}