package baseball.app.game;

public enum GameMenu {

    CONTINUE(1),
    QUIT(2),
    ;

    private final int code;

    GameMenu(final int code) {
        this.code = code;
    }

    public static GameMenu of(final int code) {
        if (code == CONTINUE.code) {
            return CONTINUE;
        }

        return QUIT;
    }

}
